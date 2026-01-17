# Ecrire les tests de l'algorithme du pas de Cauchy
using Test
using LinearAlgebra

function tester_cauchy(cauchy::Function)
    # Tolérance pour les tests
    tol_test = 1e-10

	Test.@testset "Pas de Cauchy" begin
        # Cas 1 : Gradient presque nul : s = 0
        g = [1e-15; 1e-15]
        H = [1.0 0.0; 0.0 1.0] 
        Δ = 1.0
        s = cauchy(g, H, Δ)
        Test.@test s ≈ [0.0; 0.0] atol=tol_test

        # Cas 2 : Cas SPD non saturé (le minimum est à l'intérieur)
        # q(t) = -t ||g||^2 + 0.5 t^2 (g'Hg). Min en t = ||g||^2 / (g'Hg)
        g = [1.0; 0.0]
        H = [2.0 0.0; 0.0 2.0] # g'Hg = 2. t* = 1/2 = 0.5. Pas s = -0.5 * [1,0]
        Δ = 1.0 # ||s|| = 0.5 < 1.0
        s = cauchy(g, H, Δ)
        Test.@test s ≈ [-0.5; 0.0] atol=tol_test

        # Cas 3 : Cas SPD saturé (le minimum est hors de la boule)
        g = [1.0; 0.0]
        H = [0.1 0.0; 0.0 0.1] # g'Hg = 0.1. t* = 1/0.1 = 10. Pas théorique de norme 10.
        Δ = 1.0 # On doit s'arrêter à 1.0
        s = cauchy(g, H, Δ)
        Test.@test norm(s) ≈ Δ atol=tol_test
        Test.@test s ≈ [-1.0; 0.0] atol=tol_test

        # Cas 4 : Hessienne indéfinie avec g'Hg > 0, pas à l'intérieur
        g = [1.0; 0.0]
        H = [2.0 0.0; 0.0 -2.0] # Indéfinie, mais courbure positive le long de g
        Δ = 1.0
        s = cauchy(g, H, Δ)
        Test.@test s ≈ [-0.5; 0.0] atol=tol_test

        # Cas 5 : Hessienne indéfinie avec g'Hg > 0, saturé
        g = [1.0; 0.0]
        H = [0.1 0.0; 0.0 -2.0]
        Δ = 1.0
        s = cauchy(g, H, Δ)
        Test.@test s ≈ [-1.0; 0.0] atol=tol_test

        # Cas 6 : Hessienne indéfinie avec g'Hg < 0 (Concave)
        # La fonction décroit indéfiniment, on sature la frontière
        g = [0.0; 1.0]
        H = [2.0 0.0; 0.0 -2.0] # Courbure négative le long de g ([0,1])
        Δ = 1.0
        s = cauchy(g, H, Δ)
        Test.@test norm(s) ≈ Δ atol=tol_test
        Test.@test s ≈ [0.0; -1.0] atol=tol_test # Direction -g

        # Cas 7 : Cas dégénéré g'Hg = 0 (Linéaire)
        # La fonction est linéaire décroissante, on sature la frontière
        g = [1.0; 0.0]
        H = [0.0 0.0; 0.0 0.0]
        Δ = 1.0
        s = cauchy(g, H, Δ)
        Test.@test norm(s) ≈ Δ atol=tol_test
        Test.@test s ≈ [-1.0; 0.0] atol=tol_test
    end

end
