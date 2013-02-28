#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void)
{
  char **tablica;
  char slowo1[]="ptak",slowo2[]="fujara";
 
 tablica=(char**)malloc(sizeof(char*));
 *tablica=(char*)malloc(sizeof(char)*strlen(slowo1));
 strcpy(tablica[0],slowo1);
 printf("%s\n",tablica[0]);
 tablica=realloc(tablica, sizeof(char*));
 *(tablica+1)=(char*)malloc(sizeof(char)*strlen(slowo2));
 strcpy(tablica[1],slowo2);
 printf("%s,%s\n",tablica[0],tablica[1]);
 
 free(tablica); 

return 0;
}
