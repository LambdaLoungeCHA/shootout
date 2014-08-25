\ stack manipulation tutorial

: -rot ( a b c -- c a b )
    swap rot swap ;

: 4rev ( a b c d -- d c b a )
    swap 2swap swap ;

: clear ( n -- )
    begin
	dup 0> while
	    swap drop 1-
    repeat
    drop ;

\ actual rabbits

: fib-naive ( factor n -- factor m )
    dup 1 > if
	over swap			\ k k n
	1- 2dup 1-			\ k k n-1 k n-2
	recurse *			\ k k n-1 x
	-rot				\ k x k n-1
	recurse				\ k x k y
	swap drop
	+				\ k z
    then ;

\ second fib implementation, uses the n-2 result twice

: fib-memo* ( k n1 n2 n -- k n1 n2 n )
    dup 1 > if
	1- -rot
	over swap			\ k n-1 n1 n1 n2
	4 pick				\ k n-1 n1 n1 n2 k
	* +				\ k n-1 n1 n1'
	swap rot			\ k n1' n1 n-1
	recurse
    then ;

: fib-memo ( k n -- k n )
    1 0 rot
    fib-memo*
    2drop ;

\ interface

: fib-impl fib-memo ;

: fib ( n -- m )
    1 swap fib-impl
    swap drop ;

: rabbit ( kits gens -- m )
    fib-impl
    swap drop ;

\ tests

: fib-test ( n -- )
    begin
	dup 0> while
	    dup fib dec. 1-
    repeat
    drop ;

: rabbit-test ( kits gens -- )
    begin
	dup 0> while
	    2dup rabbit dec. 1-
    repeat
    2drop ;

: fib-impl fib-naive ;
10 fib-test
3 10 rabbit-test

: fib-impl fib-memo ;
10 fib-test
3 10 rabbit-test
