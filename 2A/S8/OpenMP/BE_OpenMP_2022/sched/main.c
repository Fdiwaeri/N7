#include "aux.h"
#include "omp.h"

// Dans la première loop, chaque itération (appel à func1) dure 400,000 usecs, 
// une schedule static des itérations sur les threads est donc la plus convenable
// pour qu'ils traitent le meme nombre d'itérations et donc auront meme "load"
void loop1(int n){

  long   t_start, t_end;
  double time_it, load, max, min;
  float bal;
  int i;

  load = 0.0;
  max = 0.0;
  min = INFINITY;
  #pragma omp parallel firstprivate(load, t_start, time_it)
  {
  #pragma omp for schedule(static,1)
  for(i=0; i<n; i++){
    t_start=usecs();
    func1(i,n);
    time_it = (double)(usecs()-t_start);
    load+=time_it;
    if(n<=20) printf("Iteration %6d  of loop 1 took %.2f usecs\n",i, time_it);
  }
    #pragma omp atomic compare
    if(load<min) {min = load;}
    #pragma omp atomic compare
    if(load>max) {max = load;}
}
  bal = max / min;
  printf("min %f et max %f\n",min, max);
  printf("Balance %f\n",bal);

}

// In loop2 the processing time of iterations increases as we go, therefore it
// would be the wisest to decrease the chunk each thread gets as we go, that's why
// schedule guided is the best choice
void loop2(int n){

  long   t_start, t_end;
  double time_it, load, max, min;
  float bal;
  int i;

  load = 0.0;
  max = 0.0;
  min = INFINITY;
  #pragma omp parallel firstprivate(load, t_start, time_it)
  {
  #pragma omp for schedule(guided,1)
  for(i=0; i<n; i++){
    t_start=usecs();
    func2(i,n);
    time_it = (double)(usecs()-t_start);
    load+=time_it;
    if(n<=20) printf("Iteration %6d  of loop 2 took %.2f usecs\n",i, time_it);
  }
  #pragma omp atomic compare
  if(load<min) {min = load;}
  #pragma omp atomic compare
  if(load>max) {max = load;}
  }
  bal = max / min;
  printf("min %f et max %f\n",min, max);
  printf("Balance %f\n",bal);
}

// In loop3 the processing time of iterations decreases as we go, therefore it
// would be the wiser to give same size chunks to each thread, and whenever a 
// thread is done, give it another chunk, to let the other threads who got 
// bigger-processing-time iterations time to finish, that's why schedule dynamic is the best choice
void loop3(int n){

  long   t_start, t_end;
  double time_it, load, max, min;
  float bal;
  int i;

  load = 0.0;
  max = 0.0;
  min = INFINITY;
  #pragma omp parallel firstprivate(load, t_start, time_it)
  {
  #pragma omp for schedule(dynamic,1)
  for(i=0; i<n; i++){
    t_start=usecs();
    func3(i,n);
    time_it = (double)(usecs()-t_start);
    load+=time_it;
    if(n<=20) printf("Iteration %6d  of loop 3 took %.2f usecs\n",i, time_it);
  }
  #pragma omp atomic compare
  if(load<min) {min = load;}
  #pragma omp atomic compare
  if(load>max) {max = load;}
  }
  bal = max / min;
  printf("min %f et max %f\n",min, max);
  printf("Balance %f\n",bal);

}


int main(int argc, char **argv){
  int    i, j, n;

  // Command line argument
  if ( argc == 2 ) {
    n = atoi(argv[1]);    /* the number of loop iterations */
  } else {
    printf("Usage:\n\n ./main n \n\nwhere n is the number of iterations in the loops\n");
    return 1;
  }

  printf("\n");
  
  loop1(n);
  
  printf("\n");

  loop2(n);
  
  printf("\n");

  loop3(n);
  
  printf("\n");
  
  return 0;
}
