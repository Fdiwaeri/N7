using LinearAlgebra
"""
Approximation de la solution du problème 

    min qₖ(s) = s'gₖ + 1/2 s' Hₖ s

        sous les contraintes s = -t gₖ, t > 0, ‖s‖ ≤ Δₖ

# Syntaxe

    s = cauchy(g, H, Δ; kwargs...)

# Entrées

    - g : (Vector{<:Real}) le vecteur gₖ
    - H : (Union{Matrix{<:Real}, UniformScaling{Bool}}) la matrice Hₖ
    - Δ : (Real) le scalaire Δₖ
    - kwargs  : les options sous formes d'arguments "keywords", c'est-à-dire des arguments nommés
        • tol_abs  : la tolérence absolue (optionnel, par défaut 1e-10)

# Sorties

    - s : (Vector{<:Real}) la solution du problème

# Exemple d'appel

    g = [0; 0]
    H = [7 0 ; 0 2]
    Δ = 1
    s = cauchy(g, H, Δ)

"""
function cauchy(g::Vector{<:Real}, H::Union{Matrix{<:Real}, UniformScaling{Bool}}, Δ::Real; tol_abs::Real = 1e-10)

    s = zeros(eltype(g), length(g))

    # Si le gradient est nul, le pas est nul
    norm_g = norm(g)
    if norm_g < tol_abs
        return s
    end

    # Paramètres de la quadratique 1D : psi(t) = 1/2 * a * t^2 + b * t
    # avec s = -t * g
    # b = g' * (-g) = - ||g||^2
    # a = (-g)' * H * (-g) = g' * H * g
    
    # Paramètres de la quadratique 1D : psi(t) = 1/2 * a * t^2 + b * t
    a = dot(g, H * g)  # a = (-g)' * H * (-g) = g' * H * g
    b = -norm_g^2  # b = g' * (-g) = - ||g||^2
    
    # La borne supérieure imposée par la région de confiance ||s|| ≤ Δ
    # ||s|| = ||-t*g|| = t * ||g||  => t ≤ Δ / ||g||
    t_bound = Δ / norm_g

    if a > 0
        # Cas convexe : le minimum sans contrainte est en -b/a
        t_opt = -b / a
        # On projette sur l'intervalle [0, t_bound]
        # si t_opt > t_bound, on sature la frontière
        t = min(t_opt, t_bound)
    else
        # Cas concave (a < 0) ou nul (a = 0) :
        # Le minimum se trouve donc sur la frontière de la région de confiance.
        t = t_bound
    end

    # La solution s :
    s = -t * g
    return s

end
