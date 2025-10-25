(* Evaluation des expressions simples *)


(* Module abstrayant les expressions *)
module type ExprSimple =
sig
  type t
  val const : int -> t
  val plus : t -> t -> t
  val mult : t-> t -> t
end

(* Module réalisant l'évaluation d'une expression *)
module EvalSimple : ExprSimple with type t = int =
struct
  type t = int
  let const c = c
  let plus e1 e2 = e1 + e2
  let mult e1 e2 = e1 * e2
end


(* Solution 1 pour tester *)
(* A l'aide de foncteur *)

(* Définition des expressions *)
module ExemplesSimples (E:ExprSimple) =
struct
  (* 1+(2*3) *)
  let exemple1  = E.(plus (const 1) (mult (const 2) (const 3)) )
  (* (5+2)*(2*3) *)
  let exemple2 =  E.(mult (plus (const 5) (const 2)) (mult (const 2) (const 3)) )
end

(* Module d'évaluation des exemples *)
module EvalExemples =  ExemplesSimples (EvalSimple)

let%test _ = (EvalExemples.exemple1 = 7)
let%test _ = (EvalExemples.exemple2 = 42)


(* Module permettant la conversion des expressions en chaines de caractères *)
module PrintSimple : ExprSimple with type t = string =
  struct
    type t = string
    let const c = string_of_int c
    let plus e1 e2 = "(" ^ e1 ^ " + " ^ e2 ^ ")"
    let mult e1 e2 = "(" ^ e1 ^ " * " ^ e2 ^ ")"
  end

(* Modules des exemples *)
module PrintExemples = ExemplesSimples (PrintSimple)
let%test _ = (PrintExemples.exemple1 = "(1 + (2 * 3))")
let%test _ = (PrintExemples.exemple2 = "((5 + 2) * (2 * 3))")


(* Module permettant de compter les opérations d'une expression *)
module CompteSimple : ExprSimple with type t = int =
struct
  type t = int
  let const _ = 0
  let plus e1 e2 = e1+e2+1
  let mult e1 e2 = e1+e2+1
end

(* Module des tests *)
module CompteExemples = ExemplesSimples (CompteSimple)
let%test _ = (CompteExemples.exemple1 = 2)
let%test _ = (CompteExemples.exemple2 = 3)


(* Interface/Module abstrayant les variables dans les expressions *)
module type ExprVar =
sig
  type t
  val var : string -> t
  val def : string -> t -> t -> t
end

(* Interface complète par inclusion *)
module type Expr =
sig
  (* On inclut ExprSimple *)
  include ExprSimple
  (* On inclut ExprVar, en spécifiant que son type 't' 
     est le même que celui déjà défini par ExprSimple *)
  include (ExprVar with type t := t)
end



(* Module d'affichage pour les variables, conforme à ExprVar *)
module PrintVar : ExprVar with type t = string =
struct
  type t = string
  let var s = s
  let def x e1 e2 = "(let " ^ x ^ " = " ^ e1 ^ " in " ^ e2 ^ ")"
end

(* Module d'affichage complet par inclusion *)
module Print : Expr with type t = string =
struct
  include PrintSimple
  include PrintVar  
end

(* Foncteur pour les expressions avec variables *)
module ExemplesAvecVar (E : Expr) =
struct
  (* let x = (1 + 2) in (x * 3) *)
  let exemple_var = E.(def "x" (plus (const 1) (const 2)) (mult (var "x") (const 3)))
end

(* Test du module d'affichage avec les nouvelles expressions *)
module PrintExemplesVar = ExemplesAvecVar (Print)
let%test _ = (PrintExemplesVar.exemple_var = "(let x = (1 + 2) in (x * 3))")

(* Tests de non-régression *)
module PrintNonRegression = ExemplesSimples (Print)
let%test _ = (PrintNonRegression.exemple1 = "(1 + (2 * 3))")
let%test _ = (PrintNonRegression.exemple2 = "((5 + 2) * (2 * 3))")