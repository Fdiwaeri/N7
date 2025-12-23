(* ========================================================================== *)
(* TP9: LOGO PARSER                               *)
(* ========================================================================== *)

(* -------------------------------------------------------------------------- *)
(* MODULES FLUX & SOLUTION (Fournis)                                          *)
(* -------------------------------------------------------------------------- *)
module Flux = Monadic_flux.Make ();;
module Solution = Monadic_flux.Make ();;

(* Types des parsers généraux *)
type ('a, 'b) result = ('b * 'a Flux.t) Solution.t;;
type ('a, 'b) parser = 'a Flux.t -> ('a, 'b) result;;

module type Parsing =
  sig
    val map : ('b -> 'c) -> ('a, 'b) parser -> ('a, 'c) parser
    val return : 'b -> ('a, 'b) parser
    val ( >>= ) : ('a, 'b) parser -> ('b -> ('a, 'c) parser) -> ('a, 'c) parser
    val zero : ('a, 'b) parser
    val ( ++ ) : ('a, 'b) parser -> ('a, 'b) parser -> ('a, 'b) parser
    val run : ('a, 'b) parser -> 'a Flux.t -> 'b Solution.t
    val pvide : ('a, unit) parser
    val ptest : ('a -> bool) -> ('a, 'a) parser
    val ( *> ) : ('a, 'b) parser -> ('a, 'c) parser -> ('a, 'b * 'c) parser
  end

module Parser : Parsing =
  struct
    let map fmap parse f = Solution.map (fun (b, f') -> (fmap b, f')) (parse f);;
    let return b f = Solution.return (b, f);;
    let (>>=) parse dep_parse = fun f -> Solution.(parse f >>= fun (b, f') -> dep_parse b f');;
    let zero f = Solution.zero;;
    let (++) parse1 parse2 = fun f -> Solution.(parse1 f ++ parse2 f);;
    let run parse f = Solution.(map fst (filter (fun (b, f') -> Flux.uncons f' = None) (parse f)));;
    let pvide f =
      match Flux.uncons f with
      | None   -> Solution.return ((), f)
      | Some _ -> Solution.zero;;
    let ptest p f =
      match Flux.uncons f with
      | None        -> Solution.zero
      | Some (t, q) -> if p t then Solution.return (t, q) else Solution.zero;;
    (* Attention : *> retourne une paire (b, c) ici, d'où l'erreur précédente *)
    let ( *> ) parse1 parse2 = fun f ->
      Solution.(parse1 f >>= fun (b, f') -> parse2 f' >>= fun (c, f'') -> return ((b, c), f''));;
  end

open Parser

(* -------------------------------------------------------------------------- *)
(* TYPES DU LANGAGE LOGO ÉTENDU (Exercice 3)                                  *)
(* -------------------------------------------------------------------------- *)

type prog = decl list * inst       (* Un programme = déclarations + instructions *)
and decl = Decl of string * prog   (* Une déclaration = nom + sous-programme *)
and inst = cmd list
and cmd =
  | Repeat of int * prog
  | Move of int
  | Turn of int
  | On
  | Off
  | Call of string                 (* Nouvelle commande pour appeler une procédure *)

(* -------------------------------------------------------------------------- *)
(* ANALYSE LEXICALE (Parsers de base)                                         *)
(* -------------------------------------------------------------------------- *)

let drop p = map (fun x -> ()) p;;
let is_space c = String.contains " \t\r\n" c;;
let space  = drop (ptest is_space);;

let rec eat_space p flux =
  (map snd (space *> (eat_space p)) ++ p) flux;;

let p_car c = drop (ptest ((=) c));;

let p_chaine s =
  let rec parse i =
    if i < 0
    then return ()
    else map fst (parse (i-1) *> p_car s.[i])
  in parse (String.length s - 1)

let p_eof = eat_space pvide;;

(* Mots-clés *)
let p_ptvirg = eat_space (p_car ';');;
let p_begin  = eat_space (p_chaine "begin");;
let p_end    = eat_space (p_chaine "end");;
let p_repeat = eat_space (p_chaine "repeat");;
let p_move   = eat_space (p_chaine "move");;
let p_turn   = eat_space (p_chaine "turn");;
let p_on     = eat_space (p_chaine "on");;
let p_off    = eat_space (p_chaine "off");;

(* Nouveaux mots-clés pour l'extension *)
let p_proc   = eat_space (p_chaine "proc");;
let p_call   = eat_space (p_chaine "call");;

(* Constantes entières *)
let is_chiffre c = String.contains "0123456789" c;;
let p_chiffre = ptest is_chiffre;; 

let p_entier =
  let rec horner acc =
    p_chiffre >>= fun c -> let acc' = 10 * acc + (Char.code c - Char.code '0') in horner acc' ++ return acc'
  in eat_space (horner 0);;

(* Parser pour les identifiants (chaines de minuscules) *)
let is_lower c = (c >= 'a' && c <= 'z');;
let p_lower = ptest is_lower;;

let p_ident =
  let rec build_ident acc =
    (p_lower >>= fun c -> build_ident (acc ^ (String.make 1 c)))
    ++ return acc
  in
  eat_space (p_lower >>= fun c -> build_ident (String.make 1 c));;

(* -------------------------------------------------------------------------- *)
(* GRAMMAIRE ET PARSERS RÉCURSIFS (Exercice 3 & Correction typage)            *)
(* -------------------------------------------------------------------------- *)

(*
   Grammaire étendue :
   P -> begin D I end
   I -> C ; I | epsilon
   D -> S ; D | epsilon
   S -> proc ident P
   C -> ... | call ident
*)

let rec parse_P : (char, prog) parser = fun flux ->
  (
    p_begin >>= fun () ->    (* On consomme begin *)
    parse_D >>= fun d  ->    (* On lit les déclarations *)
    parse_I >>= fun i  ->    (* On lit les instructions *)
    p_end   >>= fun () ->    (* On consomme end *)
    return (d, i)            (* On retourne la paire *)
  ) flux

and parse_I : (char, inst) parser = fun flux ->
  (
    (parse_C >>= fun c -> p_ptvirg >>= fun () -> parse_I >>= fun i -> return (c :: i))
    ++ return []
  ) flux

and parse_D : (char, decl list) parser = fun flux ->
  (
    (parse_S >>= fun s -> p_ptvirg >>= fun () -> parse_D >>= fun d -> return (s :: d))
    ++ return []
  ) flux

and parse_S : (char, decl) parser = fun flux ->
  (
    p_proc >>= fun () ->
    p_ident >>= fun name ->
    parse_P >>= fun prog ->
    return (Decl(name, prog))
  ) flux

and parse_C : (char, cmd) parser = fun flux ->
  (
    (p_repeat >>= fun () -> p_entier >>= fun n -> parse_P >>= fun p -> return (Repeat (n, p)))
    ++ (p_move >>= fun () -> p_entier >>= fun d -> return (Move d))
    ++ (p_turn >>= fun () -> p_entier >>= fun a -> return (Turn a))
    ++ (p_on   >>= fun () -> return On)
    ++ (p_off  >>= fun () -> return Off)
    ++ (p_call >>= fun () -> p_ident >>= fun id -> return (Call id))
  ) flux

(* Fonction principale de parsing *)
let parse_logo flux = run (map fst (parse_P *> p_eof)) flux;;

(* -------------------------------------------------------------------------- *)
(* UTILITAIRES D'AFFICHAGE ET FICHIERS                                        *)
(* -------------------------------------------------------------------------- *)

let flux_of_string s =
  Flux.unfold (fun (i, l) -> if i = l then None else Some (s.[i], (i+1, l))) (0, String.length s);;

let flux_of_file name =
  let f = open_in name in
  Flux.unfold (fun () -> try Some (input_char f, ()) with End_of_file -> close_in f; None) ();;

(* Conversion en chaîne pour debug *)
let rec prog_to_string (decls, insts) =
  let d_str = String.concat "; " (List.map decl_to_string decls) in
  let i_str = String.concat "; " (List.map cmd_to_string insts) in
  if d_str = "" then i_str else d_str ^ "; " ^ i_str

and decl_to_string (Decl(n, p)) =
  Format.sprintf "proc %s begin %s end" n (prog_to_string p)

and cmd_to_string c =
  match c with
  | Repeat (n, p) -> Format.sprintf "repeat %d begin %s end" n (prog_to_string p)
  | Move   d      -> Format.sprintf "move %d" d
  | Turn   a      -> Format.sprintf "turn %d" a
  | On            -> "on"
  | Off           -> "off"
  | Call   s      -> Format.sprintf "call %s" s

let rec print_solutions progs =
  match Solution.uncons progs with
  | None        -> ()
  | Some (p, q) ->
     begin
       Format.printf "LOGO program recognized: %s@." (prog_to_string p);
       print_solutions q
     end;;

let test_parser_logo () =
  let rec loop () =
    Format.printf "programme?@.";
    flush stdout;
    let l = read_line () in
    let f = flux_of_string l in
    let progs = parse_logo f in
    match Solution.uncons progs with
    | None        -> (Format.printf "** parsing failed ! **@."; loop ())
    | Some (p, q) ->
       begin
         print_solutions (Solution.cons p q);
         loop ()
      end
  in loop ();;

(* -------------------------------------------------------------------------- *)
(* INTERPRÉTEUR LOGO ÉTENDU (Exercice 4)                                      *)
(* -------------------------------------------------------------------------- *)

let rad_of_deg = 2. *. Float.pi /. 360.

(* Environnement : liste associative (nom -> programme) *)
type env = (string * prog) list

let rec lookup name env =
  match env with
  | [] -> failwith ("Procedure inconnue : " ^ name)
  | (n, p) :: rest -> if n = name then p else lookup name rest

(* Exécution avec environnement *)
let rec exec_logo (on, x, y, a) (decls, insts) env =
  (* 1. On enrichit l'environnement avec les nouvelles déclarations locales *)
  let new_env = List.fold_left (fun acc (Decl(n, p)) -> (n, p) :: acc) env decls in
  (* 2. On exécute les instructions avec ce nouvel environnement *)
  List.fold_left (fun state cmd -> exec_cmd state cmd new_env) (on, x, y, a) insts

and exec_cmd (on, x, y, a) cmd env =
  match cmd with
  | Repeat (n, p) -> 
      if n <= 0 then (on, x, y, a) 
      else 
        let state' = exec_logo (on, x, y, a) p env in
        exec_cmd state' (Repeat (n-1, p)) env
  | Move d -> 
      let x' = x +. float_of_int d *. cos (rad_of_deg *. a)
      and y' = y +. float_of_int d *. sin (rad_of_deg *. a) in
      begin
         (if on then Graphics.lineto else Graphics.moveto) (int_of_float x') (int_of_float y');
         (on, x', y', a)
      end
  | Turn b -> (on, x, y, mod_float (a +. (float_of_int b)) 360.)
  | On -> (true , x, y, a)
  | Off -> (false, x, y, a)
  | Call name -> 
      (* Appel de procédure : on récupère son code et on l'exécute *)
      let p = lookup name env in
      exec_logo (on, x, y, a) p env

let run_logo prog =
  begin
    Graphics.open_graph " 800*600";
    Graphics.moveto 400 300;
    (* On commence avec un environnement vide [] *)
    ignore (exec_logo (false, 400., 300., 0.) prog []);
    ignore (read_line ());
    Graphics.close_graph ()
  end;;

(* Fonction pour exécuter un fichier (Bonus/Exercice 2 adapté) *)
let run_file name =
  let f = flux_of_file name in
  let progs = parse_logo f in
  match Solution.uncons progs with
  | None -> Format.printf "** Parsing failed on file %s ! **@." name
  | Some (p, _) -> 
      Format.printf "Programme reconnu, lancement de l'execution...@.";
      run_logo p
