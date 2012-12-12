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
    { /*poszerzam komorki na slowa*/
     slownik->wyrazy=(char**)realloc(slownik->wyrazy,(i+1)*sizeof(char*) );
     /*alokuje pamiec dla slowa*/
       slownik->wyrazy[i]=(char*)malloc(strlen(temp)*sizeof(char*));
      strcpy(slownik->wyrazy[i],temp); 
      i++;
    }
  slownik->r=i;
  
  return slownik;
}

/*void print(struct slownik *slownik)
{
  int i;
 for(i=0;i<slownik->r;i++)
    printf("%d. %s\n",i,slownik->wyrazy[i]); 
 
    }*/

struct krzyzowka* losuj(struct slownik *slownik)
{
  int i,j,min=0,max=0;
  struct krzyzowka *krzyzowka = (struct krzyzowka*)malloc(sizeof(struct krzyzowka));
  char *haslo = slownik->wyrazy[rand()%(slownik->r)]; /*Tu jest blad, zbyt duza liczba POPRAW*/
  
  krzyzowka->haslo=(char*)malloc(sizeof(char)*(strlen(haslo)+1));
  strcpy(krzyzowka->haslo,haslo);
  krzyzowka->r=strlen(haslo);
  krzyzowka->hasla=(char**)malloc(krzyzowka->r*sizeof(char*));
  printf("i was here");
  for(i=0;i<krzyzowka->r;i++)
    {
      for(j=0;j<slownik->r;j++)
	{     
          if(slownik->wyrazy[i][0]==haslo[i])  /*pierwszy wyraz na tą literę*/
	    {
	  min=j;
	  break;
	    }
	}
      for(j=min;j<krzyzowka->r;j++)
	{
	  if(slownik->wyrazy[j][0]==haslo[j]) /*ostatni wyraz na tą literę*/
          max=j;
	}
       do
     { 
printf("i was here");
 krzyzowka->hasla[i]=slownik->wyrazy[rand()%(max-min) + min])); /*a może tu też przydzielić pamięć? */
     }while(krzyzowka->hasla[i] != haslo[i]);
     }
  return krzyzowka;
}	
 

int main(void)
{
  FILE *fp;
  struct krzyzowka *krzyzowka; /* czemu musza być *?? */
  struct slownik *slownik;
  int i;

    fp=fopen("polish.txt","r");
  if(fp==NULL)
    {
      perror("Nie udało się otworzyć pliku");
      return 1;
    }
   
  printf("inicjalizacja struktury slownik");
  slownik=inicjalizacja(fp);
  /*  print(slownik);*/
  losuj(slownik);

  fclose(fp);
  return 0;
}
