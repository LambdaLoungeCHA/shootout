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

: fib ( n -- m )
    1 swap fib-naive
    swap drop ;

: fib-test ( n -- )
    begin
	dup 0> while
	    dup fib dec. 1-
    repeat
    drop ;

: rabbit ( kits gens -- m )
    fib-naive
    swap drop ;

: rabbit-test ( kits gens -- )
    begin
	dup 0> while
	    2dup rabbit dec. 1-
    repeat
    2drop ;

10 fib-test
3 10 rabbit-test
