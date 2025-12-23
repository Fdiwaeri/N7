type zero = private Dummy1
type _ succ = private Dummy2
type nil = private Dummy3
type 'a list = Nil | Cons of 'a * 'a list

(* Exercice 1 *)
type ('a, 'n) nlist = 
| Nil : ('a, zero) nlist
| Cons :  'a * ('a, 'n) nlist -> ('a, 'n succ) nlist

let rec map : type n. ('a -> 'b) -> ('a, n) nlist -> ('b, n) nlist =
  fun f liste -> match liste with 
  |Nil -> Nil
  |Cons (t, q) -> Cons (f t, map f q)

let rec snoc : type n. 'a -> ('a, n) nlist -> ('a, n succ) nlist =
  fun elt liste -> match liste with
  |Nil -> Cons (elt, Nil)
  |Cons (t, q) -> Cons (t, snoc elt q)

let tail : type n. ('a, n succ) nlist -> ('a, n) nlist =
  fun (Cons (_, q)) -> q

let rec rev : type n. ('a, n) nlist -> ('a, n) nlist =
  fun l ->
    match l with
    |Nil -> Nil
    |Cons (t,q) -> snoc t (rev q)

(* Ex 2 *)
let rec insert : type n. 'a -> ('a, n) nlist -> ('a, n succ) nlist =
  fun x l ->
    match l with
    |Nil -> Cons (x, Nil)
    |Cons (t,q) -> if t<x then Cons (t, insert x q) else Cons (x, l)

let rec insertion_sort : type n. ('a, n) nlist -> ('a, n) nlist =
  fun l -> match l with
  |Nil -> Nil
  |Cons (t, q) -> insert t (insertion_sort q)

(* Ex 3 *)
(* Cons (1, Cons (true, Nil)) : (int * (bool * nil)) hlist *)
type _ hlist =
  |Nil : nil hlist
  |Cons : 'a * 'p hlist -> ('a * 'p) hlist

let rec tail : type p a. (a * p) hlist -> p hlist =
  fun (Cons (t, q)) -> q

let add : type p. (int * (int * p)) hlist -> (int * p) hlist =
  fun l -> 
    match l with
    |Cons (n1, Cons (n2, q)) -> Cons (n1 + n2, q)

(* Ex 4 *)
type 't expr = 
  | Entier : int -> int expr
  | Booleen : bool -> bool expr
  | Plus : int expr * int expr -> int expr
  | Egal : 't expr * 't expr -> bool expr

let rec eval : type t. t expr -> t =
  fun expr ->
    match expr with
    |Entier i -> i
    |Booleen b -> b
    |Plus (e1, e2) -> (eval e1) + (eval e2)
    |Egal (e1, e2) -> (eval e1) = (eval e2)

(* Ex 5 *)
type valeur = Int of int | Bool of bool
type code = PushI of int | PushB of bool | Add | Equ | Seq of code * code

let rec compile : type t. t expr -> code =
  fun expr ->
    match expr with
    |Entier i -> PushI i 
    |Booleen b -> PushB b
    |Plus (e1, e2) -> Seq(compile e1, Seq(compile e2, Add))
    |Egal (e1, e2) -> Seq(compile e1, Seq(compile e2, Equ))

let rec exec : code -> valeur list -> valeur list =
  fun code l ->
    match code, l with
    |PushI i, _ -> Cons((Int i),l)
    |PushB b, _ -> Cons((Bool b),l)
    | Add, Cons((Int i1),Cons((Int i2),q)) -> Cons((Int (i1+i2)),q)
    | Add, _ -> failwith "Erreur"
    | Equ, Cons((Int i1),Cons((Int i2),q)) -> Cons((Bool (i1=i2)),q)
    | Equ , Cons((Bool i1), Cons((Bool i2),q)) -> Cons((Bool (i1=i2)),q)
    | Equ, _ -> failwith "Erreur"
    | Seq (c1, c2), _ -> exec c2 (exec c1 l) 

(* Ex 6 *)
type ('stin, 'stout) ncode =
    | PushI : int -> ('s, int * 's) ncode
    | PushB : bool -> ('s, bool * 's) ncode
    | Add : (int * (int * 's), int * 's) ncode
    | Equ : ('a * ('a * 's), bool * 's) ncode
    | Seq : ('s1, 's2) ncode * ('s2, 's3) ncode -> ('s1, 's3) ncode

(* Ex 7 *)
let rec compile : type t stin. t expr -> (stin, t * stin) ncode =
  fun expr ->
    match expr with
    |Entier i -> PushI i 
    |Booleen b -> PushB b
    |Plus (e1, e2) -> Seq(compile e1, Seq(compile e2, Add))
    |Egal (e1, e2) -> Seq(compile e1, Seq(compile e2, Equ))


let rec exec : type stin stout . (stin, stout) ncode -> stin hlist -> stout hlist =
  fun code l ->
    match code, l with
    |PushI i, _ -> Cons(i,l)
    |PushB b, _ -> Cons(b,l)
    | Add, Cons(i1, Cons (i2,q)) -> Cons((i1+i2),q)
    | Equ, Cons(i1,Cons(i2,q)) -> Cons(i1=i2,q)
    | Seq (c1, c2), _ -> exec c2 (exec c1 l)
