#include "aux.h"



int main(int argc, char **argv){
  int    i, j, n, nrooms, nplayers, room, player, next_room, finish;
  int *rooms_list;
  long ts, te;
  
   /* Command line argument */
  if ( argc == 3 ) {
    nrooms    = atoi(argv[1]);    /* the number of rooms */
    nplayers  = atoi(argv[2]);    /* the number of players */
  } else {
    printf("Usage:\n\n ./main nrooms nplayers, nwhere\n");
    printf("nrooms      is the number of rooms\n");
    printf("nplayers    is the number of players\n");
    return 1;
  }

  finish = 0;
  
  init(nplayers, nrooms);
  
  printf("\n==================================================\n");
  printf("The escape game begins\n\n");
  int is_out = 0; // indique si un player a réussi à sortir (=found the escape door)

  omp_lock_t *room_locks; // exclusion mutuelle sur les chambres
  room_locks = (omp_lock_t*) malloc(nrooms*sizeof(omp_lock_t));
  for(int i=0;i<nrooms;i++) omp_init_lock(room_locks + i);


#pragma omp parallel num_threads(nplayers) private(player, room, next_room)
{
  player = omp_get_thread_num();

  room = get_my_first_room(player, nrooms);

  printf("Player %2d entering the game from room %2d\n",player,room);
  for (;;){
    int is_out_priv; // chaque thread possède son propre indicateur

    #pragma omp atomic read
    is_out_priv = is_out;
    if (is_out_priv==1) {// on sort
      break;
    }
    omp_set_lock(room_locks+room);

    // vérification après réservation de room
    #pragma omp atomic read
    is_out_priv = is_out;
    if (is_out_priv==1) { // on libère lock et on sort
      omp_unset_lock(room_locks+room);
      break;
    }
    // là le player commence à visiter room
    next_room = solve_enigma(player, room, nrooms);


    omp_unset_lock(room_locks+room);
    //printf("Player %2d got out of %2d\n",player,room); // j'ai utilisé cette ligne pour démontrer l'exclusion mutuelle des rooms
    
    if(next_room==-999) {
      omp_unset_lock(room_locks+room);
      printf("There was an error!!!  %2d %2d\n",player,room);
      break;
    } else if (next_room==1000){
      /* Found the exit door!!! quit the game*/
      #pragma omp atomic write
      is_out = 1;
      printf("Yahi! Player %2d found the exit door!\n",player);
      omp_unset_lock(room_locks+room);
      break;
    } else {
      omp_unset_lock(room_locks+room);
      room = next_room;
    }

  } 
  printf("Player %2d is out!\n",player);
}
  for(int i=0;i<nrooms;i++) omp_destroy_lock(room_locks + i);
  free(room_locks);
  printf("\n==================================================\n");

  return 0;
}
