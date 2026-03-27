#include "aux.h"

void butterfly_seq(int n, int l, int *array);
void butterfly_par(int n, int l, int *array);

int main(int argc, char **argv){
  long   t_start, t_end;
  int    i, n, l, res;
  int    *array_seq, *array_par;

  if ( argc == 2 ) {
    l = atoi(argv[1]); 
  } else {
    printf("Usage:\n\n ./main l\n\nwhere l defines the size of the array  n=2^l.\n");
    return 1;
  }

  n = pow(2,l);
  
  printf("\nGenerating an array with %d elements\n",n);
  generate_array(n, &array_seq, &res);

  array_par = (int*)malloc(n*sizeof(int));
  for(i=0; i<n; i++)
    array_par[i] = array_seq[i];
    
  if(n<=32){
    printf("array_seq=[");
    for(i=0; i<n; i++){
      printf("%d ",array_seq[i]);
    }
    printf("]\n");
  }
  printf("The expected result is : %d\n\n\n\n",res);

  
  t_start = usecs();
  butterfly_seq(n, l, array_seq);
  t_end = usecs();
  
  printf("Sequential time : %8.2f msec.\n",((double)t_end-t_start)/1000.0);

  if(n<=32){
    printf("The result of the sequential reduction is\n");
    printf("array_seq=[");
    for(i=0; i<n; i++)
      printf("%d ",array_seq[i]);
    printf("]\n");
  }
  printf("\n\n\n");
  
  
  t_start = usecs();
  butterfly_par(n, l, array_par);
  t_end = usecs();
  
  printf("Parallel   time : %8.2f msec.\n",((double)t_end-t_start)/1000.0);
  
  if(n<=32){
    printf("The result of the parallel reduction is\n");
    printf("array_par=[");
    for(i=0; i<n; i++)
      printf("%d ",array_par[i]);
    printf("]\n\n");
  }
  
  check_result(n, array_par, res);
  
}
  
void butterfly_seq(int n, int l, int *array){

  int p, i, j, s;

  p = 0;
  
  while(p<l){
    s = pow(2,p);
    for(i=0; i<n; i+=2*s){
      for(j=0; j<s; j++){
        int r = operator(array[i+j],array[i+j+s]);
        array[i+j]   = r;
        array[i+j+s] = r;
      }
    }
    p+=1;
  }
}




void butterfly_par(int n, int l, int *array){

  int p, i, j, s;

  p = 0;
  #pragma omp parallel num_threads(4) firstprivate(p)
  {
  while(p<l){
    s = pow(2,p);
    #pragma omp for private(j)
    for(i=0; i<n; i+=2*s){
      for(j=0; j<s; j++){
        #pragma omp task firstprivate(i,j,s) depend(inout:array[i+j],array[i+j+s])
        {
          int r = operator(array[i+j],array[i+j+s]);
          array[i+j]   = r;
          array[i+j+s] = r;
        }
      }
    }
    p+=1;
    #pragma omp taskwait
  }
}
}


// For l=3:
// 1 thread:
// Sequential time :     1.20 msec.
// Parallel   time :     1.23 msec.
// 2 threads:
//Sequential time :     1.20 msec.
//Parallel   time :     0.79 msec.
// 4 threads:
// Sequential time :     1.20 msec.
// Parallel   time :    11.21 msec.

// For l=5:
// 1 thread:
// Sequential time :     8.01 msec.
// Parallel   time :     8.12 msec.
// 2 threads:
//Sequential time :     8.56 msec.
//Parallel   time :     7.13 msec.
// 4 threads:
// Sequential time :     8.04 msec.
// Parallel   time :     4.56 msec.

// For l=8:
// 1 thread:
// Sequential time :     102.62 msec.
// Parallel   time :     103.21 msec.
// 2 threads:
// Sequential time :   103.43 msec.
// Parallel   time :    53.30 msec.
// 4 threads:
// Sequential time :   102.75 msec.
// Parallel   time :    50.09 msec.