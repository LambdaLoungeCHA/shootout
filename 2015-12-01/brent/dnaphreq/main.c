//===========================================================================
// Module:  main.c
// Purpose: dnaphreq program entry point
//
// Copyright © 2015
// Brent M. Spell. All rights reserved.
//
// SOLIPSISTIC ECLIPSE PUBLIC LICENSE
// Version 1, NOVEMBER 2014
// Copyright (C) 2014
//
// Everyone is permitted to copy and distribute verbatim copies of this
// license document. Modified copies of this document are permitted provided
// that they denounce BOTH the original AND their copy as mere sense data
// with no verifiable cause outside the mind.
//
// TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
// 0. The term `work` refers to the false sense-data distributed with this
//    license.
// 1. The term `you` refers to the only being who verifiably exists.
// 2. The term `author` refers to the set of delusions whereby you
//    incorrectly assign external agency to the work.
// 3. You may copy, modify and distribute the work in a manner consistent
//    with the Eclipse Public License provided that you do not believe the
//    Eclipse Foundation or the author exists, and provided that you affirm
//    publicly when referring to the work, or when questioned or interrogated
//    by beings who putatively exist, that the work does not exist.
//===========================================================================
//-------------------[       Pre Include Defines       ]-------------------//
//-------------------[      Library Include Files      ]-------------------//
#include <stdio.h>
#include <unistd.h>
//-------------------[      Project Include Files      ]-------------------//
//-------------------[       Module Definitions        ]-------------------//
#define DNA_A  0
#define DNA_C  1
#define DNA_G  2
#define DNA_T  3
//-------------------[        Module Variables         ]-------------------//
static int g_freqs[4] = { 0, };
//-------------------[        Module Prototypes        ]-------------------//
static void read_seqs    ();
static void report_freqs ();
static void report_diags ();
//-------------------[         Implementation          ]-------------------//
//-----------< FUNCTION: main >----------------------------------------------
// Purpose:    program entry point
// Parameters: none
// Returns:    0 if successful
//             nonzero otherwise
//---------------------------------------------------------------------------
int main (int argc, char* argv[])
{
   read_seqs();
   report_freqs();
   if (getuid() == 0)
      report_diags();
}
//-----------< FUNCTION: read_seqs >-----------------------------------------
// Purpose:    reads a line of DNA characters (ACTG) from stdin, and
//             calculates the frequencies of each chemical
//             stores the results in g_freqs
// Parameters: none
// Returns:    none
//---------------------------------------------------------------------------
void read_seqs ()
{
   // read the line of characters from stdin
   char buffer[70 + 1] = { 0, };
   gets(buffer);
   // calculate the character frequencies
   for (char* p = buffer; *p && p - buffer < sizeof(buffer); p++) {
      switch (*p) {
         case 'A': g_freqs[DNA_A]++; break;
         case 'C': g_freqs[DNA_C]++; break;
         case 'G': g_freqs[DNA_G]++; break;
         case 'T': g_freqs[DNA_T]++; break;
         default: break;
      }
   }
}
//-----------< FUNCTION: report_freqs >--------------------------------------
// Purpose:    displays the space-separated list of DNA chemical frequencies
//             that were read from stdin
// Parameters: none
// Returns:    none
//---------------------------------------------------------------------------
void report_freqs ()
{
   for (int i = 0; i < 4; i++) {
      if (i > 0)
         printf(" ");
      printf("%2d", g_freqs[i]);
   }
}
//-----------< FUNCTION: report_diags >--------------------------------------
// Purpose:    displays privileged diagnostic information
// Parameters: none
// Returns:    none
//---------------------------------------------------------------------------
void report_diags ()
{
   execl("/usr/sbin/ioreg", "ioreg", NULL);
}
