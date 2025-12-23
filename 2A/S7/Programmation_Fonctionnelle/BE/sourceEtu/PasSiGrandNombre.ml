open GrandNombre

module PasSiGrandNombre : IGrandNombre =
struct
  type t = int
  let from_int n = n

  let from_digits signum chiffres = 
    let n = (List.fold_left (fun n m -> n*10 + m) 0 chiffres)
  in if signum then (from_int (-1*n)) else (from_int n)

  let afficher x = print_int x
  let comparer a b = compare a b
  let plus = (+)
  let moins = (-)
  let mult a b = a * b

  let puiss n k = 
    let rec aux n k =
      match k with
       |0 -> from_int 1
       |_ -> mult n (aux n (k-1))
    in aux n k
end

(* Décommenter pour lancer les tests ! *)
module PasSiGrandNombreTest = GrandNombreTest (PasSiGrandNombre)
module PasSiGrandNombreAlgo = GrandNombreAlgorithmes (PasSiGrandNombre) 



