\ calculate the total population, leave the bits on the stack
: prop-population ( k m n -- n m k pop )
    2dup +				\ k m n n+m
    2swap				\ n n+m k m
    swap rot				\ n m k n+m
    over +				\ n m k n+m+k
    \ 4rev
;

: in ( num dom -- f_factor )
    swap s>f s>f f/ ;

: add f* f+ ;
: 1/2 f* .5e add ;
: 3/4 f* .75e add ;

: k over ;
: p over ;
: p-1 p 1 - ;
: m 2 pick ;
: n 3 pick ;

: fprob-dominant ( k m n -- f_prob )
    prop-population ( k m n -- n m k pop )
    \ prob-dom-dom
    k p in
    \ prob-dom-mix
    k p in m p-1 in add
    \ \ prob-dom-rec
    k p in n p-1 in add
    \ \ prob-mix-mix
    m p in m 1 - p-1 in 3/4
    \ \ prob-mix-rec
    m p in n p-1 in 1/2
    \ \ prob-rec-rec
    n p in n 1 - p-1 in add
    2drop 2drop ;

: fprob ( k m n -- f_prob )
    fprob-dominant
    f. ;

2 0 0 fprob
0 2 0 fprob
0 0 2 fprob
0 2 2 fprob
2 2 0 fprob
2 2 2 fprob
