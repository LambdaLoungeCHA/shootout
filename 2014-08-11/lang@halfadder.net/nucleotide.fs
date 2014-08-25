: fib ( n -- fibn )
    dup 1 > if
	1- dup 1-			\ -1 -2
	recurse				\ -1 fib(-2)
	swap				
	recurse				\ fib(-2) fib(-1)
	+
    then
;

create dna s" AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"

create ans 0 , 0 , 0 , 0 ,

