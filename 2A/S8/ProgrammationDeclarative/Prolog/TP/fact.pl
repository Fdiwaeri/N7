/**************************/
/* Definition of fact/2 */
/**************************/
fact(0,1).
fact(N, Y) :- N>0 , N1 is N-1, fact(N1,X), Y is N*X.
