using LinearAlgebra
"""
Approximation d'une solution du problème min f(x), x ∈ Rⁿ, en utilisant l'algorithme de Newton.

# Syntaxe

   x_sol, f_sol, flag, nb_iters, xs = newton(f, ∇f, ∇²f, x0; kwargs...)

# Entrées

   - f       : (Function) la fonction à minimiser
   - ∇f   : (Function) le gradient de la fonction f
   - ∇²f   : (Function) la Hessienne de la fonction f
   - x0      : (Union{Real,Vector{<:Real}}) itéré initial
   - kwargs  : les options sous formes d'arguments "keywords"
      • max_iter : (Int) le nombre maximal d'iterations (optionnel, par défaut 1000)
      • tol_abs  : (Real) la tolérence absolue (optionnel, par défaut 1e-10)
      • tol_rel  : (Real) la tolérence relative (optionnel, par défaut 1e-8)
      • δ        : (Real) pour considérer ou non les tests de stagnation (optionnel, par défaut 1)

# Sorties

   - x_sol : (Union{Real,Vector{<:Real}}) une approximation de la solution du problème
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
   x_sol, f_sol, flag, nb_iters, xs = newton(f, ∇f, ∇²f, x0, max_iter=10)

"""
function newton(f::Function, ∇f::Function, ∇²f::Function, x0::Union{Real,Vector{<:Real}}; 
    max_iter::Int = 1000, 
    tol_abs::Real = 1e-10, 
    tol_rel::Real = 1e-8, 
    δ::Real = 1)

    #
    x_sol = x0
    f_sol = f(x_sol)
    flag  = -1
    nb_iters = 0
    xs = [Float64.(x0)]

    # Gradient initial pour le critère de convergence relative
    grad_f0 = ∇f(x0)
    norm_grad0 = norm(grad_f0)

    # Test de convergence initial (si on est déjà à la solution)
    if norm_grad0 <= max(tol_rel * norm_grad0, tol_abs)
        flag = 0
        return x_sol, f_sol, flag, nb_iters, xs
    end

    while nb_iters < max_iter
        
        grad_k = ∇f(x_sol)
        hess_k = ∇²f(x_sol)

        # Calcul de la direction de Newton
        d_k = hess_k \ (-grad_k) # \ lève SingularException si hess_k n'est pas inversible => validation du test
            
        # Mise à jour de l'itéré
        x_next = x_sol + d_k
        f_next = f(x_next)
        grad_next = ∇f(x_next)
        
        # Enregistrement
        nb_iters += 1
        push!(xs, Float64.(x_next))

        # Critère d'arrêt CN1 : Convergence du gradient
        if norm(grad_next) <= max(tol_rel * norm_grad0, tol_abs)
            flag = 0
            x_sol = x_next
            f_sol = f_next
            break
        end

        # Tests de stagnation
        if δ == 1 # seulement si δ == 1
            # Stagnation de l'itéré
            if norm(x_next - x_sol) <= max(tol_rel * norm(x_sol), tol_abs)
                flag = 1
                x_sol = x_next
                f_sol = f_next
                break
            end

            # Stagnation de la fonction
            if abs(f_next - f_sol) <= max(tol_rel * abs(f_sol), tol_abs)
                flag = 2
                x_sol = x_next
                f_sol = f_next
                break
            end
        end

        # Préparation itération suivante
        x_sol = x_next
        f_sol = f_next
    end

    # Si on sort de la boucle sans flag défini, c'est qu'on a atteint max_iter
    if flag == -1
        flag = 3
    end

    return x_sol, f_sol, flag, nb_iters, xs

end
