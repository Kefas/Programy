#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

struct slownik 
{
  int r;
  char **wyrazy;
};

struct krzyzowka
{
  int r;
  char *haslo, **hasla, **stan;
};

struct slownik* inicjalizacja(FILE *fp)
{ 
  char temp[255];
  int i=0;
  struct slownik* slownik=(struct slownik*)malloc(sizeof(struct slownik));
 
  printf("Przypisuję miejsce dla całej struktury.");

  slownik->wyrazy=(char**)malloc(sizeof(char)); /*Przypisanie poczatku tabeli której potem bede rozszerzał*/

  while(fscanf(fp,"%s", temp)!=EOF) /*skanowanie po wyrazie z pliku do tabeli*/
    { /*poszerzam komorki na litery??*/
     slownik->wyrazy=(char**)realloc(slownik->wyrazy,(i+1)*sizeof(char*) );
      
       slownik->wyrazy[i]=(char*)malloc(strlen(temp)*sizeof(char*));
      strcpy(slownik->wyrazy[i],temp); 
      i++;
    }
  slownik->r=i;
  printf("hasla: %s",slownik->wyrazy[23]);  
return slownik;
}


int main(void)
{

  struct slownik slownik;
  struct krzyzowka krzyzowka;

  FILE *fp;

    fp=fopen("polish.txt","r");
  if(fp==NULL)
    {
      perror("Nie udało się otworzyć pliku");
      return 1;
    }
   
  printf("inicjalizacja struktury slownik");
  inicjalizacja(fp);
  fclose(fp);
  return 0;
}
