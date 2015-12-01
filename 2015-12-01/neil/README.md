# Wascally Wabbits #

Implementation of the [Rabbits and Recurrence Relations Problem][1] in Prolog.

## Installing Prolog (on a Mac) ##

    brew install homebrew/x11/swi-prolog

## Running from the Prolog Interpreter ##

1. Import the code: `consult('wabbits.pl').`

2. Specify n and k:
   * Sample: `wabbits(5, 3, Out). % expect Out = 19`
   * From Graph: `wabbits(6, 1, Out). % expect Out = 8`

[1]: http://rosalind.info/problems/fib/
