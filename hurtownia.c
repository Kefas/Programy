#include <stdio.h>
#include <string.h>
#include <stdlib.h>


struct struktura1
{
  char*  main_city;
  struct struktura2 *miasta_poboczne;
  
  };

struct struktura2
{
  char* city;
  int distance;
  int indeks;
};

void inicjalizacja(FILE *fp, int glowne, int poboczne);
/*  void wyswietl(struct struktura1 *miasta_glowne, struct struktura2 *miasta_poboczne);
 */

int main(void)
{
  FILE *fp;
  struct struktura1 *miasta_glowne;
  struct struktura2 *miasta_poboczne;
  int i, glowne,poboczne;
  char temp[255], *result;
  
fp = fopen("miejscowosci.txt","r");
  if(fp==NULL)
    {
      perror("Nie udało się otworzyć pliku lub plik jest pusty");
      return 1;
    } 
    for(i=0;i<100;i++)
      {
      result = fgets(temp, 50 ,fp);
      if(result!=NULL)
	{
	  printf("%d. %s",i,temp);
      if(temp[0]>=48 && temp[0]<=57)
	glowne++;
      if(temp[0]>=65 && temp[0]<=90)
        poboczne++;
	}      
     
       }
  printf("glowne2 %d, poboczne %d",glowne,poboczne);
   
  inicjalizacja(fp,glowne,poboczne);

  /*  wyswietl(miasta_glowne, miasta_poboczne); */
   
 fclose(fp);
  return 0;
}


void inicjalizacja(FILE *fp, int glowne, int poboczne)
{
  char temp[255],buff[255],*result;
  int i=0,j=0;
  
  struct struktura1* miasta_glowne=(struct stuktura1*)malloc(sizeof(struct struktura1)*(glowne));
  struct struktura2* miasta_poboczne=(struct struktura2*)malloc(sizeof(struct struktura2*)*(poboczne)); /* tu nie jestem pewien czy gwiazdka przy sizeof, edit na pewno bez:*/
  rewind(fp); /*ważne!!! przesuwa kursor na początek pliku */
 
   for(i=0;i<=glowne+poboczne-1;i++)
    {
      result = fgets(temp,100,fp);
      if(result != NULL)
	{
	  if(temp[0]>=65 && temp[0]<=90)
	    {
	   miasta_glowne[i].main_city=(char*)malloc(strlen(temp)*sizeof(char)+1);      
	   strcpy(miasta_glowne[i].main_city,temp);
	/*   printf("Moje miasto: %s\n",miasta_glowne[i].main_city); */
	   j=i;
	    }

	  else
	    {
	      sscanf(temp, "%d %s\n", &miasta_poboczne[i].distance,buff);
	      miasta_poboczne[i].city=(char*)malloc(strlen(buff)*sizeof(char)+1);
	      strcpy(miasta_poboczne[i].city,buff); 
	      /*  printf("Moje miasto poboczne: %s i odl %d\n",miasta_poboczne[i].city, miasta_poboczne[i].distance);*/    
	      miasta_poboczne[i].indeks=j; /*tu jest indeks do ktorego bede sie odwolywal*/
            }
	} 
           
    }

   /* poki co bedzie tak bo nie za bardzo mam pomysl i czas */

   printf("Podaj miasto glowne a ja wyswietle polaczenia");
   scanf("%d",&wybor);







}
/*
void wyswietl(struct struktura1 miasta_glowne, struct struktura2 miasta_poboczne)
{
  printf("A tera? %s", miasta_glowne[0].main_city);
}  */
 
