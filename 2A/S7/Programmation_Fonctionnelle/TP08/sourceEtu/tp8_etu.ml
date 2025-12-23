(****** Algorithmes combinatoires et monades ********)

module type FONCTEUR =
  sig
    type 'a t
    val map : ('a -> 'b) -> ('a t -> 'b t)
  end

module type MONADE =
  sig
    include FONCTEUR
    val return : 'a -> 'a t
    val (>>=)  : 'a t -> ('a -> 'b t) -> 'b t
  end

module type MONADE_PLUS =
  sig
    include MONADE
    val zero : 'a t
    val (++) : 'a t -> 'a t -> 'a t
  end

(* interface incluant l'affichage des éléments calculés *)
(* pour les listes d'entiers uniquement                 *)
module type MONADE_PLUS_PRINT =
  sig
    include MONADE_PLUS
    val print : Format.formatter -> int list t -> unit
  end

(* fonction auxiliaire pour compter le nombre maximum d'octets alloués en mémoire *)
let max_bytes () =
  let stat = Gc.stat () in
  8. *. (stat.minor_words +. stat.major_words -. stat.promoted_words)

(* fonction auxiliaire pour afficher une liste d'entiers *)
let print_int_list fmt l =
  begin
    Format.fprintf fmt "[";
    List.iter (Format.fprintf fmt "%d; ") l;
    Format.fprintf fmt "]"
  end


(* implantation de la monade ND avec des listes *)
(* ne fonctionne qu'en l'absence de doublons    *)
module NDList : MONADE_PLUS_PRINT =
  struct
    type 'a t = 'a list
    let map = List.map
    let return v = [v]
    let (>>=) s f = List.flatten (List.map f s)
    let zero = []
    let (++) = (@)

    (* fonction d'affichage pour les tests *)
    let print fmt =
      List.iter (Format.fprintf fmt "%a@." print_int_list) 
  end


(*** Combinaisons d'une liste ***)

module Exo1 (ND : MONADE_PLUS) =
  struct
    (* CONTRAT 
       Fonction qui renvoie toutes les combinaisons possible de k éléments d'une liste l
       Paramètre k : le nombre d'éléments dans la liste retournée
       Precondition : k>= taille de l
       Paramètre l : la liste dans laquelle on prend les éléments
       Resultat : les combinaisons de k éléments choisis dans l
     *)
    let rec combinaisons k l = 
      if k=0 then ND.(return []) else 
      match l with
      |[] -> ND.zero
      |t::q -> ND.( ( (combinaisons (k-1) q) >>= (fun l -> return (t::l)) ) ++ (combinaisons k q))
      end

(* TESTS *)
let test1 (module ND : MONADE_PLUS_PRINT) =
  let module M = Exo1 (ND) in
  let old_bytes = max_bytes () in
  let result = M.combinaisons 4 [1;2;3;4;5;6;7;8;9;10] in
  begin
    Format.printf "@.TEST combinaisons@.memory used: %f@.result:@. %a@." (max_bytes () -. old_bytes) ND.print result
  end

let _ = test1 (module NDList)


(*** Permutations d'une liste ***)

module Exo2 (ND : MONADE_PLUS) =
  struct
    (* CONTRAT
       Fonction prend en paramètre un élément e et une liste l et qui insére e à toutes les possitions possibles dans l
       Pamaètre e : ('a) l'élément à insérer
       Paramètre l : ('a l  ist) la liste initiale dans laquelle insérer e
       Résultat : toutes les insertions possible de e dans l
     *)
    let rec insertion e l = 
      match l with
      |[] -> ND.return [e]
      |t::q -> ND.( (return(e::l)) ++ ((insertion e q) >>= (fun l -> return (t::l))) )

    (* CONTRAT
       Fonction qui renvoie la liste des permutations d'une liste
       Paramètre l : une liste
       Résultat : les permutations de l (toutes différentes si les élements de l sont différents deux à deux)
     *)
    let rec permutations l =
      match l with
      |[] -> ND.return []
      |t::q -> ND.( (permutations q) >>= (fun liste -> insertion t liste) )
end

(* TESTS *)
let test2 (module ND : MONADE_PLUS_PRINT) =
  let module M = Exo2 (ND) in
  let old_bytes = max_bytes () in
  let result = M.permutations [1;2;3;4;5] in
  begin
    Format.printf "@.TEST permutations@.memory used: %f@.result:@. %a@." (max_bytes () -. old_bytes) ND.print result
  end

let _ = test2 (module NDList)


(*** Partition d'un entier ***)

module Exo3 (ND : MONADE_PLUS) =
  struct
    (* CONTRAT
       partition int -> int list
       Fonction qui calcule toutes les partitions possibles d'un entier n
       Paramètre n : un entier dont on veut calculer les partitions
       Préconditions : n >0
       Résultat : les partitions de n
     *)
    let partitions n =
      let rec aux n t =
        if n = 0 then ND.return [] (* Cas de base : partition vide *)
        else if n = t then ND.return [t]
        else ND.(
          (* Option 1 : utiliser t si possible *)
          (if n - t >= t then (aux (n - t) t >>= fun l -> return (t :: l)) else zero) 
          ++ 
          (* Option 2 : passer à la part suivante *)
          (aux n (t + 1))
        )
      in aux n 1
  end

(* TESTS *)
let test3 (module ND : MONADE_PLUS_PRINT) =
  let module M = Exo3 (ND) in
  let old_bytes = max_bytes () in
  let result = M.partitions 5 in
  begin
    Format.printf "@.TEST partitions@.memory used: %f@.result: %a@." (max_bytes () -. old_bytes) ND.print result
  end

let _ = test3 (module NDList)


(* fonction auxiliaire pour réaliser tous les tests des fonctions combinatoires *)
let test_combinatoire (module ND : MONADE_PLUS_PRINT) =
  begin
    test1 (module ND);
    test2 (module ND);
    test3 (module ND)
  end

(*** Autre implantation de ND par itérateurs ***)
    
module NDIter : MONADE_PLUS_PRINT =
  struct
    type 'a t = Tick of ('a * 'a t) option Lazy.t

    let uncons (Tick flux) = Lazy.force flux
    let rec ( ++ ) flux1 flux2 = Tick (lazy (
      match uncons flux1, uncons flux2 with
      |None, _ -> uncons flux2
      |_, None -> uncons flux1
      |Some (t1,q1), Some (t2,q2) -> Some (t1, Tick (lazy( Some (t2, q1 ++ q2))))
    ))
    let zero =Tick (lazy (None))
    let rec ( >>= ) flux f = match uncons flux with
    |None -> zero
    |Some (t,q) -> (f t) ++ ( q >>= f)
    let return a =  Tick (lazy (Some (a, zero)))
    let rec map f aflux = Tick (lazy ( 
      match uncons aflux with
      |None -> None
      |Some (t,q) -> Some (f t, map f q)
    ))

    (* fonction d'affichage pour les tests *)
    let rec print fmt it =
      match uncons it with
      | None          -> Format.fprintf fmt "@."
      | Some (a, it') -> Format.fprintf fmt "%a@.%a" print_int_list a print it'
  end

(* TESTS *)
let test_iter () =
  begin
    Format.printf "@.TEST itérateur@.";
    test_combinatoire (module NDIter)
  end


(*** Autre implantation de ND par tirage aléatoire ***)

module NDRandom : MONADE_PLUS_PRINT =
  struct
    type 'a t = unit -> 'a option

    (* à compléter *)
    let ( ++ ) a b = if Random.bool () then a else b
    let zero () =  None
    let ( >>= ) a f = match (a ()) with
    |None -> zero
    |Some b -> f b
    let return a () =  Some a
    let map f choix () = match choix () with
    |None -> None
    |Some a -> Some (f a)

    (* fonction d'affichage pour les tests *)
    let print fmt it =
      match it () with
      | None   -> Format.fprintf fmt "@."
      | Some v -> Format.fprintf fmt "%a@." print_int_list v
  end

(* TESTS *)
let test_random (module ND : MONADE_PLUS_PRINT) =
  begin
    Format.printf "@.TEST aléatoire@."; test_combinatoire (module ND)
  end

let _ = test_random (module NDRandom)


(*** Autre implantation de ND par tirage aléatoire équitable ***)

module NDFairRandom : MONADE_PLUS_PRINT =
  struct
    type 'a t = int * (unit -> 'a)

    (* à compléter *)
    let ( ++ ) (na, a) (nb, b) = let n = na+nb in
     (n, fun () -> 
      if Random.int n < na then a() else b())
    let zero = (0, fun () -> failwith "c zero")
    let ( >>= ) (n, a) f = if n=0 then zero else f (a ())
    let return a = (1, fun () -> a)
    let map f (na, a) = (na, fun () -> f (a ()))

    (* fonction d'affichage pour les tests *)
    let print fmt (n, it) =
      match n with
      | 0 -> Format.fprintf fmt "@."
      | _ -> Format.fprintf fmt "%a@." print_int_list (it ())
  end

(* TESTS *)
let _ = test_random (module NDFairRandom)
