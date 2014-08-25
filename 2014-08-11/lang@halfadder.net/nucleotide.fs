: fib ( n -- fibn )
    dup 1 > if
	1- dup 1-			\ -1 -2
	recurse				\ -1 fib(-2)
	swap				
	recurse				\ fib(-2) fib(-1)
	+
    then
;

: rabbit { kit gen -- }
    dup 1 > if
	1- swap over			\ n-1 k n-1
	recurse				\ n-1 k fib(n-1)
	swap dup * swap			\ n-1 k k*fib(n-1)
	

\ create dna s" AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"
\ create ans 0 , 0 , 0 , 0 ,

