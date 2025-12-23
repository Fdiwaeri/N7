
module type Scheduler = sig
  type prog = unit -> unit

  (* rend la main *)
  val yield : unit -> unit

  (* rend la main et lance l'exécution d'une nouvelle fonction *)
  val spawn : prog -> unit

  (* "tue" le processus appelant *)
  val stop : unit -> unit

  (* handler/ordonnanceur *)
  val run : prog -> unit
end

module Scheduler : Scheduler = struct
  type prog = unit -> unit

  type _ eff +=
    | Yield : unit eff
    | Spawn : prog -> unit eff
    | Stop : unit eff

  let yield () = Effect.perform Yield
  let spawn prog = Effect.perform (Spawn prog)
  let stop () = Effect.perform Stop

  (* handler/ordonnanceur *)
  let rec run = 
    let running : prog Queue.t = Queue.create () in
    let suspend p = Queue.add p running in
    let resume () = match Queue.take_opt running with
          |None -> ()
          |Some p -> p ()
  in fun p -> match p () with
  |() -> resume ()
  |effect Yield, k -> suspend (fun () -> Effect.Deep.continue k ()); resume ()
  |effect Spawn prog, k -> suspend (fun () -> Effect.Deep.continue k ()); run prog
  |effect Stop, k -> resume ()
end

open Scheduler

let task name = 
  for i=1 to 10 do
    print_endline name;
    yield ()
  done
let ping () = task "ping!"
let pong () = task "pong!"

let ping_pong () = spawn ping; spawn pong
    
module type Channel = sig
  val create : unit -> ('a -> unit) * (unit -> 'a)
end

module Channel : Channel = struct
  open Scheduler

  let create () =
    let buffer : 'a Queue.t = Queue.create () in
    let ecriture : 'a -> unit = fun a -> Queue.add a buffer in
    let rec lecture : unit -> 'a = fun () -> match (Queue.take_opt buffer) with
     |None -> yield (); lecture ()
     |Some a -> a
  in (ecriture, lecture)
end


(* crible d'Eratosthène *)
let sieve max =
  let open Scheduler in
  let rec filter recv_from_parent =
    let v0 = recv_from_parent () in
    if v0 < 0 then stop ();
    Format.printf "%d@." v0;
    yield ();
    let send, recv = Channel.create () in
    spawn (fun () -> filter recv);
    while true do
      let v = recv_from_parent () in
      yield ();
      if v mod v0 <> 0 then send v;
      if v < 0 then stop ()
    done
  in
  let main () =
    if max < 2 then stop ();
    let send, recv = Channel.create () in
    spawn (fun () -> filter recv);
    for i = 2 to max do
      send i;
      yield ()
    done;
    send (-1);
    stop ()
  in
  run main      
