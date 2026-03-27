#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <string.h>
#include <math.h>
#include "omp.h"
#include "aux.h"

void sequential_nn(layer *layers, int n, int L);
void parallel_nn_loops(layer *layers, int n, int L);
void parallel_nn_tasks(layer *layers, int n, int L);

int main(int argc, char **argv){
  int   n, m, N, L, i;
  long  t_start, t_end;
  layer *layers_se, *layers_pl, *layers_pt;
  
  // Command line arguments
  if ( argc == 3 ) {
    n = atoi(argv[1]);    /* size of layers */
    L = atoi(argv[2]);    /* number of layers in the network */
  } else {
    printf("Usage:\n\n ./main n L\n\nsuch that n is the size of the layers and L is the number of layers.\n");
    return 1;
  }

  layers_se = (layer*) malloc(sizeof(layer)*L);
  layers_pl = (layer*) malloc(sizeof(layer)*L);
  layers_pt = (layer*) malloc(sizeof(layer)*L);

  init(layers_se, n, L);
  copy_nn(layers_se, layers_pl, n, L);
  copy_nn(layers_se, layers_pt, n, L);
  

  t_start = usecs();
  sequential_nn(layers_se, n, L);
  t_end = usecs();
  printf("Sequential     time    : %8.2f msec.\n",((double)t_end-t_start)/1000.0);


  t_start = usecs();
  parallel_nn_loops(layers_pl, n, L);
  t_end = usecs();
  printf("Parallel loops time    : %8.2f msec.    ",((double)t_end-t_start)/1000.0);

  check_result(layers_se, layers_pl, n, L);
  

  t_start = usecs();
  parallel_nn_tasks(layers_pt, n, L);
  t_end = usecs();
  printf("Parallel tasks time    : %8.2f msec.    ",((double)t_end-t_start)/1000.0);

  check_result(layers_se, layers_pt, n, L);

  return 0;
  
}


void sequential_nn(layer *layers, int n, int L){
  int i, j, k, l, s;
  
  for(l=0; l<L-1; l++){
    /* printf("layer %2d  m:%2d\n",l,layers[l].m); */
    for(s=0; s<layers[l].m; s++){
      i = layers[l].syn[s].i;
      j = layers[l].syn[s].j;
      /* printf("layer %2d  i:%2d  j:%2d\n",l,i,j); */
      layers[l+1].neu[j].nv += update(layers[l].neu[i].nv, layers[l].syn[s].sv);
    }
  }
}


void parallel_nn_loops(layer *layers, int n, int L){
  int i, j, k, l, s;
  #pragma omp parallel num_threads(4) private(l)
  {
  for(l=0; l<L-1; l++){
    /* printf("layer %2d  m:%2d\n",l,layers[l].m); */
    #pragma omp for private(i,j)
    for(s=0; s<layers[l].m; s++){
      i = layers[l].syn[s].i;
      j = layers[l].syn[s].j;
      /* printf("layer %2d  i:%2d  j:%2d\n",l,i,j); */
      #pragma omp atomic
      layers[l+1].neu[j].nv += update(layers[l].neu[i].nv, layers[l].syn[s].sv);
    }
  }
  }
}



void parallel_nn_tasks(layer *layers, int n, int L){
  int i, j, k, l, s;
  #pragma omp parallel num_threads(4)
  {
    #pragma omp single
    {
  for(l=0; l<L-1; l++){
    /* printf("layer %2d  m:%2d\n",l,layers[l].m); */
    for(s=0; s<layers[l].m; s++){
      i = layers[l].syn[s].i;
      j = layers[l].syn[s].j;
      /* printf("layer %2d  i:%2d  j:%2d\n",l,i,j); */
      #pragma omp task firstprivate(i,j,l,s) depend(inout:layers[l+1].neu[j].nv) depend(in:layers[l].neu[i].nv, layers[l].syn[s].sv)
      layers[l+1].neu[j].nv += update(layers[l].neu[i].nv, layers[l].syn[s].sv);
    }
    #pragma omp taskwait
  }
}
}
}

// Avec n=15 et L=10:
// Pour 1 thread:
//Sequential     time    :  1417.96 msec.
//Parallel loops time    :  1417.96 msec.    Result is correct :-)
//Parallel tasks time    :  1417.92 msec.    Result is correct :-)
// On a les memes résultats car on fait comme s'il y a pas de parallelisme (1 thread = master)
//
//Pour 2 threads:
//Sequential     time    :  1417.97 msec.
//Parallel loops time    :   759.84 msec.    Result is correct :-)
//Parallel tasks time    :   745.73 msec.    Result is correct :-)
// On voit que les temps après parallesisations sont égales au temps séquantiel divisé par 2,
// c'est parce qu'on a deux threads qui divisent le tazvail entre eux.
//
//Pour 4 threads:
//Sequential     time    :  1419.60 msec.
//Parallel loops time    :   444.89 msec.    Result is correct :-)
//Parallel tasks time    :   401.58 msec.    Result is correct :-)
// The parallelized code is always better and more efficient than the sequential, however the
// tasks are slightly better than just "omp for".