using LinearAlgebra
"""
Approximation de la solution du problème 

    min qₖ(s) = s'gₖ + 1/2 s' Hₖ s, sous la contrainte ‖s‖ ≤ Δₖ

# Syntaxe

    s = gct(g, H, Δ; kwargs...)

# Entrées

    - g : (Vector{<:Real}) le vecteur gₖ
    - H : (Matrix{<:Real}) la matrice Hₖ
    - Δ : (Real) le scalaire Δₖ
    - kwargs  : les options sous formes d'arguments "keywords", c'est-à-dire des arguments nommés
        • max_iter : le nombre maximal d'iterations (optionnel, par défaut 100)
        • tol_abs  : la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel  : la tolérence relative (optionnel, par défaut 1e-8)

# Sorties

    - s : (Vector{<:Real}) une approximation de la solution du problème

# Exemple d'appel

    g = [0; 0]
    H = [7 0 ; 0 2]
    Δ = 1
    s = gct(g, H, Δ, max_iter = 10)

"""
function gct(g::Vector{<:Real}, H::Matrix{<:Real}, Δ::Real; 
    max_iter::Int = 100, 
    tol_abs::Real = 1e-10, 
    tol_rel::Real = 1e-8)

    s = zeros(length(g))
    g_j = copy(g) # g_0      
    p = -copy(g) # p_0
    
    # Critère d'arrêt initial sur le gradient du modèle
    norm_g0 = norm(g)
    
    for j in 0:max_iter-1
        
        # Condition d'arrêt standard du GC
        if norm(g_j) <= max(norm_g0 * tol_rel, tol_abs)
            return s
        end

        # Calcul de la courbure
        Hp = H * p
        kappa = dot(p, Hp)

        # Cas 1 : Courbure négative ou nulle (non convexe)
        if kappa <= 0
            # On cherche les deux racines de ||s + sigma*p|| = Delta
            a = dot(p, p)
            b = 2 * dot(s, p)
            c = dot(s, s) - Δ^2
            
            delta_eq = b^2 - 4*a*c
            sigma1 = (-b - sqrt(delta_eq)) / (2*a)
            sigma2 = (-b + sqrt(delta_eq)) / (2*a)
            
            # On choisit la racine qui minimise le modèle quadratique
            function q_val(sigma)
                 s_test = s + sigma * p
                 return dot(g, s_test) + 0.5 * dot(s_test, H * s_test)
            end
            
            val1 = q_val(sigma1)
            val2 = q_val(sigma2)
            
            sigma_star = (val1 < val2) ? sigma1 : sigma2
            
            return s + sigma_star * p
        end

        # Calcul du pas alpha
        alpha = dot(g_j, g_j) / kappa

        # Cas 2 : On sort de la région de confiance
        if norm(s + alpha * p) >= Δ
            # On cherche la racine positive de ||s + sigma*p|| = Delta
            a = dot(p, p)
            b = 2 * dot(s, p)
            c = dot(s, s) - Δ^2
            
            delta_eq = b^2 - 4*a*c
            sigma = (-b + sqrt(delta_eq)) / (2*a)
            
            return s + sigma * p
        end

        # Mise à jour de s (on reste dans la région)
        s_next = s + alpha * p
        g_next = g_j + alpha * Hp
        
        # Mise à jour de la direction p
        beta = dot(g_next, g_next) / dot(g_j, g_j)
        p_next = -g_next + beta * p
        
        # Itération suivante
        s = s_next
        g_j = g_next
        p = p_next
    end

    return s
   
end
