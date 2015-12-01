CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
C     WASCALLY WABBITS                               C
CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC
C
C     Compute the number of Wabbits at generation n
C     Written in FORTRAN 77
C     Author: Stephen Spalding
C
       SUBROUTINE WABBITS(N, K)
       INTEGER N, K, I
       INTEGER(8) A,B,TMP

       A = 0
       B = 1
       DO 10 I = 1, N-1
           TMP = B + A * K
           A = B
           B = TMP
  10   CONTINUE
       WRITE (*,*) TMP
       ENDSUBROUTINE

C
C     Read arguments and run WABBITS !!!
C
       PROGRAM MAIN
       CHARACTER(2) ARG1, ARG2
       INTEGER N, K
       REAL T1, T2

       CALL GET_COMMAND_ARGUMENT(1, ARG1)
       CALL GET_COMMAND_ARGUMENT(2, ARG2)
       READ(ARG1, '(I2)') N
       READ(ARG2, '(I2)') K

       CALL CPU_TIME(T1)
       CALL WABBITS(N, K)
       CALL CPU_TIME(T2)
       WRITE (*,*) T2 - T1
       END

