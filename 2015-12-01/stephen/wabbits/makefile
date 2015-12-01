wabbits: WABBITS.FOR
	gfortran -o WABBITS WABBITS.FOR

test:
	./WABBITS 5 3
	./wabbits.jl 5 3 r
	./wabbits.jl 5 3 m
	./wabbits.jl 5 3 l
	./wabbits.jl 5 3 c

benchmark:
	./WABBITS 5 1
	./wabbits.jl 5 1 r
	./wabbits.jl 5 1 m
	./wabbits.jl 5 1 l
	./wabbits.jl 5 1 c
	./WABBITS 10 1
	./wabbits.jl 10 1 r
	./wabbits.jl 10 1 m
	./wabbits.jl 10 1 l
	./wabbits.jl 10 1 c
	./WABBITS 20 1
	./wabbits.jl 20 1 r
	./wabbits.jl 20 1 m
	./wabbits.jl 20 1 l
	./wabbits.jl 20 1 c
	./WABBITS 40 3
	./wabbits.jl 40 3 r
	./wabbits.jl 40 3 m
	./wabbits.jl 40 3 l
	./wabbits.jl 40 3 c
	./WABBITS 50 3
	./wabbits.jl 50 3 r
	./wabbits.jl 50 3 m
	./wabbits.jl 50 3 l
	./wabbits.jl 50 3 c
