open GrandNombre

module IntListBigNum : sig

  include IGrandNombre with type t = bool * int list

  val comparer_listes : int list -> int list -> int

  val plus_listes : int list -> int list -> int list

  val moins_listes : int list -> int list -> int list

  val mult_coeff : int list -> int -> int list

end = struct
  (* Type pour le grand nombre *)
  type t = bool * int list

  (* normalise : int list -> int list
     Normalise une liste de chiffres, c'est à dire retire autant de 0
     que possible du début du nombre.
     Paramètres :
         n : int list, nombre à normaliser (list de chiffre)
     Retour : n' tel que n et n' représentent le même nombre, mais n' ne
     commence pas par 0
  *)
  let normalise n =
    List.fold_right (fun t nq -> if t = 0 && nq = [] then [] else t::nq) n []

  let%test "normalise-1" = (normalise [1;2;3;0;0;0;0;0] = [1;2;3])
  let%test "normalise-2" = (normalise [1;0;1;0;1;0;1;0] = [1;0;1;0;1;0;1])
  let%test "normalise-3" = (normalise [2] = [2])
  let%test "normalise-4" = (normalise [] = [])
  let%test "normalise-5" = (normalise [0;0;0;0;0;0;0;0;0;0;0;0;0;0;0] = [])

  (* from_int : int -> t
     Transforme un entier "normal" en liste d'entiers
     Paramètres :
         n : int, entier à transformer
     Retour : t, liste d'entiers
  *)
  let from_int n =
    if n=0 then (false,[])
    else
      let rec aux n =
        if n<100 then [n]
        else let r=(n mod 100) in (r::(aux ((n-r)/100)))
      in (n<0, aux (abs n))

  (* Tests : TO DO *)
  let%test "from_int-1" = (from_int 1234567 = (false, [67; 45; 23; 1]))
  let%test "from_int-2" = (from_int 80907 = (false, [7; 9; 8]))
  let%test "from_int-3" = (from_int 0 = (false, []))
  let%test "from_int-4" = (from_int (-1) = (true, [1]))
  let%test "from_int-5" = (from_int (-1000) = (true, [0; 10]))


  (* from_digits : bool -> int list -> t
     Transforme une suite de chiffre en grand nombre (signé)
     Paramètres :
         signum : bool, true si le nombre doit être négatif
         chiffres : int list, suite de chiffres représentant le grand nombre
     Retour : un grand nombre du signe désiré, composé de la suite de chiffre donnée
     Par exemple : from_digits true [1;2;3;4;5;6;7] = le grand nombre "(true, [67;45;23;1])"
  *)
  let from_digits signum chiffres =
    let list_chiffres= 
      match ((List.length chiffres) mod 2) with
        |1-> 0::chiffres
        |0-> chiffres
    in let rec aux l =
      match l with
      |[]-> []
      |t1::t2::q-> (t1*10 + t2)::(aux q)
    in (signum, normalise (List.rev (aux list_chiffres)))


let%test "from_digits-0" = (from_digits false [0;0] = (false, []))
let%test "from_digits-1" = (from_digits false [1;2;3;4;5;6;7] = (false, [67;45;23;1]))
let%test "from_digits-2" = (from_digits true [0;0;0;4;2] = (true, [42]))
let%test "from_digits-3" = (from_digits false [1;0;0;0;0] = (false, [0;0;1]))
let%test "from_digits-4" = (from_digits true [] = (true, []))
let%test "from_digits-5" = (from_digits true [9] = (true, [9]))


  let afficher_list =
    let rec afficher_aux fmt = function
      | [] -> ()
      | d :: q -> Format.fprintf fmt "%a%.2d" afficher_aux q d
    in
    fun fmt l ->
      match l with
      | [] -> Format.pp_print_char fmt '0'
      | _ -> afficher_aux fmt l

  let afficher (s,n) =
    Format.printf "%t%a"
      (fun fmt -> if s then Format.pp_print_char fmt '-' else ())
      afficher_list n


  (* comparer_listes : int list -> int list -> int
     Compare deux listes pour savoir laquelle représente le nombre le plus grand.
     Paramètres :
         n1,n2 : int list, nombres à comparer (liste de chiffres)
     Retour : > 0 si n1 > n2, < 0 si n2 > n1, = 0 sinon
  *)
  let rec comparer_listes n1 n2 =
    let c=((List.length n1)- (List.length n2)) in
    if c=0 then 
      if n1=[] then 0
      else match (List.rev n1, List.rev n2) with
          |[],[]-> 0
          |t1::q1,t2::q2 -> if t1!=t2 then t1-t2
          else comparer_listes (List.rev q1) (List.rev q2)
    else c

let%test "comparer_listes-0" = (comparer_listes [] [] = 0)
let%test "comparer_listes-1" = (comparer_listes [12] [] > 0)
let%test "comparer_listes-2" = (comparer_listes [] [12] < 0)
let%test "comparer_listes-3" = (comparer_listes [78;56;34;12] [78;56;34;12] = 0)
let%test "comparer_listes-4" = (comparer_listes [78;56;34;12] [79;56;34;12] < 0)
let%test "comparer_listes-5" = (comparer_listes [56;34;12] [11;11;11;11] < 0)

  let comparer (b1, l1) (b2, l2) =
    match (l1,l2) with 
    |[],[]-> 0
    |_->
    match (b1,b2) with
      |true,false-> -1
      |false,true-> 1
      |_,_-> comparer_listes l1 l2

  (* Le module IntListTest, défini en fin de fonction, permet de tester les fonctions sur les grands nombres *)
  (* Tests complémentaires pour les cas limites *)

let%test "comparer-0-1" = (comparer (false,[]) (false,[]) = 0)
let%test "comparer-0-2" = (comparer (false,[]) (true,[]) = 0)


  (* plus_listes : int list -> int list -> int list
     Réalise la somme de deux listes de "chiffres"
     Paramètres :
         n1,n2 : int list, nombres à additionner, sous forme de liste de "chiffres"
     Retour : somme de n1 et n2 (sous forme de liste de "chiffres")
     Le résultat est normalisé
  *)
  let plus_listes n1 n2 = 
    let rec aux n1 n2 (t::q) =
      match (n1,n2) with
      |[],[]-> t::q
      |[],_-> aux [t] n2 (0::q)
      |_,[]-> aux [t] n1 (0::q)
      |[t1],[t2]-> let r=((t1+t2+t) mod 100) in ((t1+t2+t-r)/100)::(r::q)
      |t1::q1,t2::q2-> let r=((t1+t2+t) mod 100)
      in (aux q1 q2 (((t1+t2+t-r)/100)::(r::q)))
    in normalise (List.rev (aux n1 n2 [0]))

let%test "plus_listes-base" = (plus_listes [] [] = []) (* 0 + 0 = 0 *)
let%test "plus_listes-zero-1" = (plus_listes [0] [1] = [1]) (* 0 + 1 = 1 *)
let%test "plus_listes-zero-2" = (plus_listes [34;12] [] = [34;12]) (* 1234+0 = 1234 *)
let%test "plus_listes-nominal-1" = (plus_listes [30;20;10] [1;5] = [31;25;10]) (* 102030 +501 = 102531 *)
let%test "plus_listes-nominal-2" = (plus_listes [4;5;6;7] [6;5;4;3] = [10;10;10;10]) (* 7060504 + 3040506 = 10101010 *)
let%test "plus_listes-carrier-1" = (plus_listes [99;10] [1] = [0;11]) (* 1099 + 1 = 1100 *)
let%test "plus_listes-carrier-2" = (plus_listes [10;5] [90;94] = [0;0;1]) (* 510 + 9490 = 10000*)


  (* moins_listes : int list -> int list -> int list
     Réalise la différence positive de deux listes de "chiffres"
     Paramètres :
         n1,n2 : int list, nombres à soustraire, sous forme de liste de "chiffres"
     Retour : différence entre n1 et n2 (sous forme de liste de "chiffres")
     Pré-conditions : n1 >= n2
     Le résultat est normalisé
  *)
  let moins_listes n1 n2 =
    let rec aux n1 n2 (t::q) =
      match (n1,n2) with
      |[],[]-> t::q
      |[],_-> aux [t] n2 (0::q)
      |_,[]-> aux [t] n1 (0::q)
      |[t1],[t2]-> let r=((t1-t2+t) mod 100) in ((t1-t2+t-r)/100)::(r::q)
      |t1::q1,t2::q2-> let r=((t1-t2+t) mod 100)
      in (aux q1 q2 (((t1-t2+t-r)/100)::(r::q)))
    in normalise (List.rev (aux n1 n2 [0]))
(*
let%test "moins_listes-base" = (moins_listes [] [] = [])
let%test "moins_listes-nominal-1" = (moins_listes [10;20;30] [1;1;1] = [9;19;29])
let%test "moins_listes-carrier-1" = (moins_listes [0;10] [1] = [99;9])
let%test "moins_listes-carrier-2" = (moins_listes [0;20;50] [1;20;1] = [99;99;48])
let%test "moins_listes-zero" = (moins_listes [1;2;3] [1;2;3] = [])
*)

  (* Note plus a besoin de moins et moins a besoin de plus ; on les définit
     ensemble. *)
  (*let rec plus (b1, l1) (b2, l2) = (compare l1 l2, plus_listes l1 l2)
  and moins (b1, l1) (b2, l2) = plus (b1, l1) (not b2, l2)*)


  (* mult_coeff : int list -> int -> int list
     Multiplie un grand nombre (une liste de chiffres) par un nombre entier "normal"
     Paramètres :
         n : int list, grand nombre (list de chiffres)
         m : int, entier qui sert de facteur
      Retour : n * m
      Post-conditions : nombre normalisé
  *)
  let mult_coeff _ _ = []
(*
let%test "mult_coeff-0" = mult_coeff [56;34;12] 0 = []
let%test "mult_coeff-1" = mult_coeff [34;12] 2  = [68;24]
let%test "mult_coeff-2" = mult_coeff [34;12] 10 = [40;23;1]
let%test "mult_coeff-3" = mult_coeff [34;12] 51 = [34;29;6]
let%test "mult_coeff-4" = mult_coeff [99;99] 99 = [01;99;98]
*)
  let mult _ _ = (false,[])

  let puiss _ _ = (false,[])
end

(* Décommenter pour lancer les tests ! *)
(*module IntListTest = GrandNombreTest (IntListBigNum)*)
(*module IntListAlgo = GrandNombreAlgorithmes (IntListBigNum)*)



