#include "aux.h"


void bottom_up(int nleaves, struct node **leaves, int nnodes);

int main(int argc, char **argv){
  long   t_start, t_end;
  int    nnodes, nleaves;
  struct node **leaves;

  // Command line argument: number of nodes in the tree
  if ( argc == 2 ) {
    nnodes = atoi(argv[1]); 
  } else {
    printf("Usage:\n\n ./main n\n\nwhere n is the number of nodes in the tree.\n");
    return 1;
  }

  printf("\nGenerating a tree with %d nodes\n\n",nnodes);
  generate_tree(nnodes, &leaves, &nleaves);
  
  t_start = usecs();
  bottom_up(nleaves, leaves, nnodes);
  t_end = usecs();
  
  printf("Parallel time : %8.2f msec.\n\n",((double)t_end-t_start)/1000.0);

  check_result();
  
}
  

/* You can change the number and type of arguments if needed.     */
/* Just don't forget to update the interface declaration above.   */
void bottom_up(int nleaves, struct node **leaves, int nnodes){
  int i, old_visited;
  struct node *node, *parent;
  struct node **group, **next_group, **temp;
  int n_group, n_next_group, idx;

  group = leaves;
  n_group = nleaves;
  next_group = (struct node **) malloc(nnodes*sizeof(struct node *));
  n_next_group = 0;

  int *visited = (int*) malloc(nnodes*sizeof(int));
  for(int j=0; j<nnodes;j++) visited[j]=0;

  /* Implement this routine */
  #pragma omp parallel private(node, parent, idx, old_visited)
  {
    while (n_group!=0) {
      #pragma omp for
      for(i=0;i<n_group;i++){
        node = group[i];
        //printf("%d is going to process %d in iteration %d\n", omp_get_thread_num(), node->id, i);
        process_node(node);
        parent = node->parent;
        if(parent!=NULL) {
          #pragma omp atomic capture
          {
            old_visited = visited[parent->id-1];
            visited[parent->id-1] = 1;
          }
          printf("%d just processed %d in iteration %d and saw parent %d\n", omp_get_thread_num(), node->id, i, parent->id);
          if (old_visited != 1) {
            #pragma omp atomic capture
            idx = n_next_group++;

            next_group[idx] = parent;
            
          }
        }
      }

      #pragma omp single
      {
        temp = group;
        group = next_group;
        next_group = temp;
        n_group = n_next_group;
        n_next_group = 0;
      }
    }
  }
  return;
}
    




