\ utilities

: -frot
    fswap frot fswap ;

: 4rev
    swap 2swap swap ;

: p 2 pick ;
: p, 3 pick ;
: k 3 pick ;
: k, 4 pick ;
: m 4 pick ;
: m, 5 pick ;
: n 5 pick ;
: n, 6 pick ;

\ calculate the total population, leave the bits on the stack
: prop-population ( k m n -- n m k pop )
    2dup +				\ k m n n+m
    2swap				\ n n+m k m
    swap rot				\ n m k n+m
    over +				\ n m k n+m+k
    \ 4rev
;

\ k/p
: prob-dom-dom ( n m k pop num dom -- n m k pop dom num )
    k + swap
    p + swap ;

\ find the common demoninator for p*p-1
: pp-1 ( n m k pop dom num -- n m k pop dom num )
    over * swap
    p 1 - * swap ;

\  m/p * k/p-1
: prob-dom-mix ( n m k pop dom num -- n m k pop dom num )
    m k, * + ;

\  n/p * k/p-1
: prob-dom-rec ( n m k pop dom num -- n m k pop dom num )
    n k, * + ;

\  (m/p * k/p-1) * 1/2
: prob-mix-rec ( n m k pop dom num -- n m k pop dom num )
    m k, * + swap 
    * 2 swap ;

\ (m/p * m-1/p-1) * 3/4
: prob-mix-mix ( n m k pop dom num -- n m k pop dom num )
    m m, 1 - * 3 * + swap
    4 * swap ;
    
\ n/p * n-1/p-1
: prob-rec-rec ( n m k pop dom num -- n m k pop dom num )
    n n, 1 - * + ;

: prob-dominant ( k m n -- dom num )
    prop-population
    0 0
    prob-dom-dom
    pp-1
    prob-dom-mix
    prob-dom-rec
    prob-mix-mix
    prob-mix-rec
    prob-rec-rec
    2swap 2drop 2swap 2drop ;

: fprob ( k m n -- f_prob )
    prob-dominant
    s>f s>f
    f/
    f. ;
    
1 0 0 fprob
0 1 0 fprob

\ 1 0 0 fprob
\ 1 1 0 fprob
\ 1 0 1 fprob
\ 0 1 1 fprob
\ 0 0 1 fprob
\ 2 2 2 fprob
