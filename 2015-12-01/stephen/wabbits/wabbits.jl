#!/usr/bin/env julia
### Wascally Wabbits ###
USAGE = """
wabbits.jl <n> <k> <implementaion:default=l>

Implementations:
  r: recursive - O(φ^n)
  m: memoized - O(n)
  l(default): linear algebra - O(n)
  c: closed form (use floats for large n) - O(1)
"""

## recursive wabbits - O(φ^n)
fib_r(n,k) = n < 2 ? n : fib_r(n-1,k) + fib_r(n-2,k) * k

## memoized wabbits - O(n)
fib_m(n,k,a=1,b=0) = n < 2 ? a : fib_m(n-1,k,a+b*k,a)

## linear wabbits - O(n)
fib_l(n,k) = ([1 1;k 0]^(n-1))[1]

## closed form wabbits - O(1)
g(k) = sqrt(4*k+1);
fib_c(n,k) = ((1 + g(k))^n - (1 - g(k))^n) / (2^n * g(k))

## main
main(n,k,f='m') = eval(parse("fib_$f($n,$k)"))
@time println(length(ARGS) >= 2 ? main(ARGS...) : "Usage: $USAGE")
