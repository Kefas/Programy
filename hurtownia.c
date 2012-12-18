#include <stdio.h>
#include <string.h>
#include <stdlib.h>


struct struktura1
{
  char*  main_city;
  struct struktura2 *miasta_posrednie;
};

struct struktura2
{
  char* city;
  int distance;
};

void inicjalizacja(FILE *fp);



int main(void)
{
  FILE *fp;
  struct struktura1 *miasta_glowne;
  struct struktura2 *miasta_poboczne;
  fp = fopen("miejscowosci.txt","r");
  if(fp==NULL)
    {
      perror("Nie udało się otworzyć pliku lub plik jest pusty");
      return 1;
    }

  inicjalizacja(fp);

  
   
 fclose(fp);
  return 0;
}


void inicjalizacja(FILE *fp)
{
  char temp[255];
  int i=0,j=0;

  struct struktura1* miasta_glowne=(struct stuktura1*)malloc(sizeof(struct struktura1));
  struct struktura2* miasta_poboczne=(struct struktura2*)malloc(sizeof(struct struktura2));
  /* wydaje mi się, że tu należy alokować pamięć dla pierwszego elementu a w tym while'u poniżej należy alokować pamięć dla kolejnych elementów tablicy struktur a nie rozszerzać tą istniejącą.*/

  
  while(fscanf(fp,"%s",temp)!=EOF)
    {
      if(temp[1]=='1' || temp[1]=='2' || temp[1]=='3' || temp[1]=='4' || temp[1]=='5' || temp[1]=='6' || temp[1]=='7' || temp[1]=='8' || temp[1]=='9')
	{
	  struct struktura2* miasta_poboczne=(struct struktura2*)realloc(miasta_poboczne, (j+1)*sizeof(struct struktura2));
	  j++;	

	}
      else 
	{
	  struct struktura1 *miasta_glowne=(struct struktura1*)realloc(miasta_glowne, (i+1)*sizeof(struct struktura1));
	  i++;	
	}


  */

 
      printf("nic");
    
}

