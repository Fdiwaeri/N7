using LinearAlgebra
include("../src/newton.jl")
include("../src/regions_de_confiance.jl")
"""

Approximation d'une solution au problème 

    min f(x), x ∈ Rⁿ, sous la contrainte c(x) = 0,

par l'algorithme du lagrangien augmenté.

# Syntaxe

    x_sol, f_sol, flag, nb_iters, μs, λs = lagrangien_augmente(f, ∇f, ∇²f, c, ∇c, ∇²c, x0; kwargs...)

# Entrées

    - f      : (Function) la ftion à minimiser
    - ∇f     : (Function) le gradient de f
    - ∇²f    : (Function) la hessienne de f
    - c      : (Function) la c à valeur dans R
    - ∇c     : (Function) le gradient de c
    - ∇²c    : (Function) la hessienne de c
    - x0     : (Vector{<:Real}) itéré initial
    - kwargs : les options sous formes d'arguments "keywords"
        • max_iter  : (Int) le nombre maximal d'iterations (optionnel, par défaut 1000)
        • tol_abs   : (Real) la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel   : (Real) la tolérence relative (optionnel, par défaut 1e-8)
        • λ0        : (Real) le multiplicateur de lagrange associé à c initial (optionnel, par défaut 2)
        • μ0        : (Real) le facteur initial de pénalité de la c (optionnel, par défaut 10)
        • τ         : (Real) le facteur d'accroissement de μ (optionnel, par défaut 2)
        • algo_noc  : (String) l'algorithme sans c à utiliser (optionnel, par défaut "rc-gct")
            * "newton"    : pour l'algorithme de Newton
            * "rc-cauchy" : pour les régions de confiance avec pas de Cauchy
            * "rc-gct"    : pour les régions de confiance avec gradient conjugué tronqué

# Sorties

    - x_sol    : (Vector{<:Real}) une approximation de la solution du problème
    - f_sol    : (Real) f(x_sol)
    - flag     : (Int) indique le critère sur lequel le programme s'est arrêté
        • 0 : convergence
        • 1 : nombre maximal d'itération dépassé
    - nb_iters : (Int) le nombre d'itérations faites par le programme
    - μs       : (Vector{<:Real}) tableau des valeurs prises par μk au cours de l'exécution
    - λs       : (Vector{<:Real}) tableau des valeurs prises par λk au cours de l'exécution

# Exemple d'appel

    f(x)=100*(x[2]-x[1]^2)^2+(1-x[1])^2
    ∇f(x)=[-400*x[1]*(x[2]-x[1]^2)-2*(1-x[1]) ; 200*(x[2]-x[1]^2)]
    ∇²f(x)=[-400*(x[2]-3*x[1]^2)+2  -400*x[1];-400*x[1]  200]
    c(x) =  x[1]^2 + x[2]^2 - 1.5
    ∇c(x) = 2*x
    ∇²c(x) = [2 0; 0 2]
    x0 = [1; 0]
    x_sol, _ = lagrangien_augmente(f, ∇f, ∇²f, c, ∇c, ∇²c, x0, algo_noc="rc-gct")

"""
function lagrangien_augmente(f::Function, ∇f::Function, ∇²f::Function, 
        c::Function, ∇c::Function, ∇²c::Function, x0::Vector{<:Real}; 
        max_iter::Int=1000, tol_abs::Real=1e-10, tol_rel::Real=1e-8,
        λ0::Real=2, μ0::Real=10, τ::Real=2, algo_noc::String="rc-gct")

    #
    x_k = x0
    flag  = -1
    nb_iters = 0
    μs = [Float64(μ0)]
    λs = [Float64(λ0)]

    λ_k = λ0
    μ_k = μ0

    # Paramètres de l'algorithme
    β = 0.9
    η_hat = 0.1258925
    α = 0.1
    ε_0 = 1.0 / μ0
    η_0 = η_hat / (μ0^α)
    ε_k = ε_0
    η_k = η_0

    # Gradient initial du Lagrangien pour le critère relatif
    # ∇L = ∇f + λ * ∇c
    grad_L0 = ∇f(x0) + λ0 * ∇c(x0)
    grad_L0_norm = norm(grad_L0)
    
    # Sécurité si gradient nul au départ
    if grad_L0_norm == 0
        grad_L0_norm = 1.0
    end

    while nb_iters < max_iter
        
        # Critère d'arrêt Global
        cx_k = c(x_k)
        grad_L = ∇f(x_k) + λ_k * ∇c(x_k)
        
        norm_grad_L = norm(grad_L)
        norm_c = norm(cx_k)

        if (norm_grad_L <= max(tol_rel * grad_L0_norm, tol_abs)) && (norm_c <= max(tol_rel * norm(c(x0)), tol_abs))
            flag = 0
            break
        end

        # Définition du sous-problème : on définit les fonctions L_A, ∇L_A, ∇²L_A
        # On suppose que c(x) renvoie un scalaire
        
        function LA(x)
            val_c = c(x)
            return f(x) + λ_k * val_c + 0.5 * μ_k * val_c^2
        end

        function grad_LA(x)
            val_c = c(x)
            # ∇LA = ∇f + (λ + μ*c)*∇c
            return ∇f(x) + (λ_k + μ_k * val_c) * ∇c(x)
        end

        function hess_LA(x)
            val_c = c(x)
            grad_c = ∇c(x)
            # ∇²LA = ∇²f + (λ + μ*c)*∇²c + μ*∇c*∇c'
            return ∇²f(x) + (λ_k + μ_k * val_c) * ∇²c(x) + μ_k * (grad_c * grad_c')
        end

        # Résolution du sous-problème sans contraintes
        args_solveur = (max_iter=1000, tol_abs=ε_k, tol_rel=0.0) 

        if algo_noc == "newton"
            x_next, _, _, _, _ = newton(LA, grad_LA, hess_LA, x_k; args_solveur...)
        elseif algo_noc == "rc-cauchy"
            x_next, _, _, _, _ = regions_de_confiance(LA, grad_LA, hess_LA, x_k; algo_pas="cauchy", args_solveur...)
        elseif algo_noc == "rc-gct"
            x_next, _, _, _, _ = regions_de_confiance(LA, grad_LA, hess_LA, x_k; algo_pas="gct", args_solveur...)
        else
            error("Algorithme non contraint inconnu : $algo_noc")
        end

        # Mise à jour des paramètres (Algorithme 4)
        cx_next = c(x_next)
        
        if norm(cx_next) <= η_k
            # Cas favorable
            λ_k = λ_k + μ_k * cx_next
            ε_k = ε_k / μ_k
            η_k = η_k / (μ_k^β)
        else
            # Cas défavorable
            μ_k = τ * μ_k
            ε_k = ε_0 / μ_k
            η_k = η_hat / (μ_k^α)
        end

        # Itération suivante
        x_k = x_next
        nb_iters += 1
        
        push!(μs, Float64(μ_k))
        push!(λs, Float64(λ_k))

        if nb_iters == max_iter
            flag = 1
        end
    end

    f_sol = f(x_k)
    return x_k, f_sol, flag, nb_iters, μs, λs

end
