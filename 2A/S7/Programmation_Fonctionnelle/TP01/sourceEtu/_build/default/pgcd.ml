(*  Exercice à rendre **)
(*  pgcd: int -> int -> int *)
(*  renvoie le plus grand commun diviseur de deux entiers *)
(*  Parametre a : int, le premier entier *)
(*  Parametre b : int, le deuxième entier *)
(*  Resultat : int, le pgcd de a et b *)
(*  Precondition: a et b non nuls *)
(*  Postcondition: le pgcd est strictement positif *)
let pgcd a b =
  let rec pgcd_pos x y =
     if x=y then x
     else if x>y then (pgcd_pos (x-y) y)
            else (pgcd_pos x (y-x))
  and
  abs z = if z>0 then z else -z
  in
  pgcd_pos (abs a) (abs b)
(*  tests unitaires *)
let%test _ = pgcd 3 (-3) = 3
let%test _ = pgcd (-3) 3 = 3
let%test _ = pgcd 10 50 = 10
let%test _ = pgcd (-6) (-9) = 3
