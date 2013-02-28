#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct struktura
{
  char **tablica;
  int liczba;
};

typedef struct struktura struktura;

int main(void)
{
  struktura *temp;
  int i,j;
  char *slowo="ziemia",*slowo2="niebo";

  temp=(struktura*)malloc(sizeof(struktura));
  for(i=0;i<3;i++)
    {
      temp=realloc(temp,sizeof(struktura)*(i+1));
      for(j=0;j<3;j++)
	{
	  temp[i].tablica=realloc(temp[i].tablica,sizeof(char*)*(j+1));
	  temp[i].tablica[j]=(char*)malloc(sizeof(char)*strlen(slowo2));
	  strcpy(temp[i].tablica[j],slowo2);
	  printf(" %s",temp[i].tablica[j]);
	}
      
    }
  free(temp);






  return 0;
}
