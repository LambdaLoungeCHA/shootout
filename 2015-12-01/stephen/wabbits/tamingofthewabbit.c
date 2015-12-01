// ../tamingofthewabbit.spl
// compiled with splc.py (c) Sam Donow 2013-2015
#include <stdio.h>
#include <math.h>
#include "include/mathhelpers.h"
int condition = 0;
char inputbuffer[BUFSIZ];
int main() {

int Romeo = 2;
int Juliet = 2;
int Hamlet = 2;
int Macduff = 0;
int Ophelia = 1;
act1: {
goto act_1_scene1;
}
act_1_scene1: {
;
Juliet = (1 - 1) ;
Romeo = 1 ;

goto act_1_scene2;

}
act_1_scene2: {
;
fgets(inputbuffer, BUFSIZ, stdin);
sscanf(inputbuffer, "%d", &Macduff);
fgets(inputbuffer, BUFSIZ, stdin);
sscanf(inputbuffer, "%d", &Ophelia);

goto act2;

}
act2: {
goto act_2_scene1;
}
act_2_scene1: {
;
condition = (Macduff) > (1);
if (!condition) {
 goto act3;
 }
Hamlet = (Romeo + (Ophelia * Juliet)) ;
Juliet = Romeo ;
Romeo = Hamlet ;

goto act_2_scene2;

}
act_2_scene2: {
;
Macduff = (Macduff - 1) ;
goto act2;

goto act3;

}
act3: {
goto act_3_scene1;
}
act_3_scene1: {
;
fprintf(stdout, "%d", Romeo);

}
}
