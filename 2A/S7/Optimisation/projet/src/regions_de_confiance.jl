using LinearAlgebra
include("../src/cauchy.jl")
include("../src/gct.jl")
"""
Approximation de la solution du problème min f(x), x ∈ Rⁿ.

L'algorithme des régions de confiance résout à chaque itération, un modèle quadratique
de la fonction f dans une boule (appelée la région de confiance) de centre l'itéré 
courant. Cette minimisation se fait soit par un pas de Cauchy ou par l'algorithme 
du gradient conjugué tronqué.

# Syntaxe

    x_sol, f_sol, flag, nb_iters, xs = regions_de_confiance(f, ∇f, ∇²f, x0; kwargs...)

# Entrées

    - f       : (Function) la fonction à minimiser
    - ∇f   : (Function) le gradient de la fonction f
    - ∇²f   : (Function) la hessienne de la fonction f
    - x0      : (Vector{<:Real}) itéré initial
    - kwargs  : les options sous formes d'arguments "keywords"
        • max_iter      : (Int) le nombre maximal d'iterations (optionnel, par défaut 5000)
        • tol_abs       : (Real) la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel       : (Real) la tolérence relative (optionnel, par défaut 1e-8)
        • δ             : (Real) pour considérer ou non les tests de stagnation (optionnel, par défaut 1)
        • Δ0            : (Real) le rayon initial de la région de confiance (optionnel, par défaut 2)
        • Δmax          : (Real) le rayon maximal de la région de confiance (optionnel, par défaut 10)
        • γ1, γ2        : (Real) les facteurs de mise à jour de la région de confiance (optionnel, par défaut 0.5 et 2)
        • η1, η2        : (Real) les seuils pour la mise à jour de la région de confiance (optionnel, par défaut 0.25 et 0.75)
        • algo_pas      : (String) l'algorithme de calcul du pas - "cauchy" ou "gct" (optionnel, par défaut "gct")
        • max_iter_gct  : (Int) le nombre maximal d'iterations du GCT (optionnel, par défaut 2*length(x0))

# Sorties

    - x_sol : (Vector{<:Real}) une approximation de la solution du problème
    - f_sol : (Real) f(x_sol)
    - flag  : (Int) indique le critère sur lequel le programme s'est arrêté
        • 0  : convergence
        • 1  : stagnation du xk
        • 2  : stagnation du f
        • 3  : nombre maximal d'itération dépassé
    - nb_iters : (Int) le nombre d'itérations faites par le programme
    - xs    : (Vector{Vector{<:Real}}) les itérés

# Exemple d'appel

    f(x)=100*(x[2]-x[1]^2)^2+(1-x[1])^2
    ∇f(x)=[-400*x[1]*(x[2]-x[1]^2)-2*(1-x[1]) ; 200*(x[2]-x[1]^2)]
    ∇²f(x)=[-400*(x[2]-3*x[1]^2)+2  -400*x[1];-400*x[1]  200]
    x0 = [1; 0]
    x_sol, f_sol, flag, nb_iters, xs = regions_de_confiance(f, ∇f, ∇²f, x0, algo_pas="gct")

"""
function regions_de_confiance(f::Function, ∇f::Function, ∇²f::Function, x0::Vector{<:Real};
    max_iter::Int=5000, tol_abs::Real=1e-10, tol_rel::Real=1e-8, δ::Real=1, 
    Δ0::Real=2, Δmax::Real=10, γ1::Real=0.5, γ2::Real=2, η1::Real=0.25, η2::Real=0.75, algo_pas::String="gct",
    max_iter_gct::Int = 2*length(x0))

    x_k = x0
    f_k = f(x_k)
    flag  = -1
    nb_iters = 0
    xs = [Float64.(x0)]

    g_k = ∇f(x_k) # Gradient initial
    H_k = ∇²f(x_k) # Hessienne initiale
    Δ_k = Δ0
    
    grad_f0_norm = norm(g_k)

    # Test initial (si on est déjà à la solution)
    if grad_f0_norm <= max(tol_rel * grad_f0_norm, tol_abs)
        flag = 0
        return x_k, f_k, flag, nb_iters, xs
    end

    while nb_iters < max_iter

        # Calcul du pas s_k
        if algo_pas == "cauchy"
            s_k = cauchy(g_k, H_k, Δ_k; tol_abs=tol_abs)
        elseif algo_pas == "gct"
            s_k = gct(g_k, H_k, Δ_k; max_iter=max_iter_gct, tol_abs=tol_abs, tol_rel=tol_rel)
        else
            error("Algorithme de pas inconnu : $algo_pas")
        end

        # Calcul du ratio rho_k
        pred_red = -(dot(g_k, s_k) + 0.5 * dot(s_k, H_k * s_k))
        f_trial = f(x_k + s_k)
        actual_red = f_k - f_trial
        
        if pred_red == 0
            ρ_k = 0.0
        else
            ρ_k = actual_red / pred_red
        end

        # Mise à jour de l'itéré et gestion de l'acceptation
        x_next = x_k
        f_next = f_k
        step_accepted = false

        if ρ_k >= η1
            x_next = x_k + s_k
            f_next = f_trial
            step_accepted = true
        end

        # Mise à jour de la région de confiance
        if ρ_k >= η2
            Δ_k = min(γ2 * Δ_k, Δmax)
        elseif ρ_k >= η1
            Δ_k = Δ_k
        else
            Δ_k = γ1 * Δ_k
        end

        nb_iters += 1

        # Si pas accepté => mettre à jour gradients, tester CN1 puis stagnation
        if step_accepted
            x_k = x_next
            f_k = f_next
            g_k = ∇f(x_k)
            H_k = ∇²f(x_k)
            push!(xs, Float64.(x_k))
            
            # CRITÈRE 0 : Convergence du gradient
            if norm(g_k) <= max(tol_rel * grad_f0_norm, tol_abs)
                flag = 0
                break
            end
            
            # CRITÈRES DE STAGNATION (si CN1 n'est pas vérifié)
            if δ == 1
                # Stagnation de l'itéré 
                if norm(s_k) <= max(tol_rel * norm(x_k), tol_abs)
                    flag = 1
                    break
                end
                
                # Stagnation de la fonction
                if abs(actual_red) <= max(tol_rel * abs(f_k), tol_abs)
                    flag = 2
                    break
                end
            end
        else
        end
    end

    if flag == -1
        flag = 3
    end

    return x_k, f_k, flag, nb_iters, xs
end
