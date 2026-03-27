void stacks_par_critical(stack_t *stacks, int n)
{

  int s, tmp;

#pragma omp parallel private(s, tmp)
  for (;;)
  {

    /* Get the stack number s */
    s = get_random_stack();

    if (s == -1)
      break;

    /* Push some value on stack s */
    // On sort la fonction process de la section critique parce que cela ne pose pas de problème/
    tmp = process();
#pragma omp critical
    stacks[s].elems[stacks[s].cnt++] = tmp;
  }
}

void stacks_par_atomic(stack_t *stacks, int n)
{

  int s, tmp;
#pragma omp parallel private(s, tmp)
  for (;;)
  {

    /* Get the stack number s */
    s = get_random_stack();

    if (s == -1)
      break;
#pragma omp atomic capture
    tmp = stacks[s].cnt++; // On réserve la pile

    /* Push some value on stack s */
    stacks[s].elems[tmp] = process();
  }
}

void stacks_par_locks(stack_t *stacks, int n)
{

  int s, tmp;
  omp_lock_t* lock = malloc(1000 * sizeof(omp_lock_t));

  for (int i = 0; i < 1000; i++)
  {
    omp_init_lock(lock + i);
  }

#pragma omp parallel private(s, tmp)
  for (;;)
  {

    /* Get the stack number s */
    s = get_random_stack();

    if (s == -1)
      break;

    tmp = process();

    /* Push some value on stack s */
    omp_set_lock(lock + s);
    stacks[s].elems[stacks[s].cnt++] = tmp;
    omp_unset_lock(lock + s);
  }
  for (int i = 0; i < 1000; i++)
  {
    omp_destroy_lock(lock + i);
  }
}
