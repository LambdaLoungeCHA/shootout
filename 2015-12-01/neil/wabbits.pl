wabbits(1, _, 1).
wabbits(2, _, 1).
wabbits(N, K, F) :-
    N > 2,
    N1 is N - 1, wabbits(N1, K, F1),
    N2 is N - 2, wabbits(N2, K, F2),
    F is F1 + K * F2.

% Optimized for larger N (i.e. N >= 40)
rabbits(1, _, 1).
rabbits(N, K, F) :- N > 1, rabbits(N, K, F, _).
rabbits(2, _, 1, 1).
rabbits(N, K, F1, F2) :-
    N > 2,
    N1 is N - 1,
    rabbits(N1, K, F2, F3),
    F1 is F2 + K * F3.
