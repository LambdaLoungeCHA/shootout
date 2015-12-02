# Wascally Wabbits
http://rosalind.info/problems/fib/

## Problem
Given: Positive integers n≤40 and k≤5.

Return: The total number of rabbit pairs that will be present after n months if we begin with 1 pair and in each generation, every pair of reproduction-age rabbits produces a litter of k rabbit pairs (Instead of only 1 pair).

Sample Dataset

    5 3

Sample Output

    19

## Implementations
Implementations were written in FORTRAN77 and Julia. The Fortran implementation is a basic iterative approach. In Julia, 4 different approaches were used.

## Benchmarks
    18:49 0 MBPSSpalding% make test  
    ./WABBITS 5 3
                    19
    2.20001675E-05
    ./wabbits.jl 5 3 r
    19
    0.044562 seconds (17.50 k allocations: 980.430 KB)
    ./wabbits.jl 5 3 m
    19
    0.045699 seconds (17.89 k allocations: 1004.182 KB)
    ./wabbits.jl 5 3 l
    19
    0.390996 seconds (753.52 k allocations: 35.080 MB, 5.94% gc time)
    ./wabbits.jl 5 3 c
    19.000000000000007
    0.066770 seconds (43.13 k allocations: 2.155 MB)
    ./WABBITS 50 3
    359426118413557441
    2.09999271E-05
    ./wabbits.jl 50 3 m
    359426118413557441
    0.049073 seconds (17.89 k allocations: 1004.229 KB)
    ./wabbits.jl 50 3 l
    359426118413557441
    0.387383 seconds (753.53 k allocations: 35.081 MB, 5.83% gc time)
    ./wabbits.jl 50 3 c
    3.594261184135585e17
    0.068513 seconds (43.14 k allocations: 2.155 MB)
    ./wabbits.jl 50 3 r
    359426118413557441
    109.043193 seconds (17.50 k allocations: 980.477 KB)
