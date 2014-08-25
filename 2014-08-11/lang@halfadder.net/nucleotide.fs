: fib ( n -- fibn )
    dup 1 > if
	1- dup 1-			\ -1 -2
	recurse				\ -1 fib(-2)
	swap				
	recurse				\ fib(-2) fib(-1)
	+
    then
;

\ 9 fib dec.

: rabbit ( kit gen -- kit n )
    dup 1 > if
	over swap			\ k k n
	1- 2dup				\ k k n-1 k n-1
	recurse *			\ k k n-1 k*fn-1
	-rot
	1- recurse *			\ k k*fn-1 k*fn-2
	+
    then
;

\ 5 3 rabbit

\ create dna s" AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
\ create ans 0 , 0 , 0 , 0 ,

