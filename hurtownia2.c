#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

/*Niestety coś chrzani się przy wskaźniku do pierwszego elementu listy.. jest to conajmniej dziwne to co się dzieje. Wygląda to tak jakby za każdym przejściem pętli while wykonywała się instrukcja head_g=current_g ale to występuje tylko w headzie, a sprawdzałem i tam program wchodzi tylko raz... */



struct glowne
{
  char *miasto_g;
  struct glowne *next_m;
  struct poboczne *myhead;
  struct poboczne *mytail;
};

struct poboczne
{
  char *miasto_p;
  int odleglosc;
  struct poboczne *next_p;
};

struct head
{
  struct glowne *glowne_head;
  struct poboczne *poboczne_head;
};

typedef struct glowne struktura1;
typedef struct poboczne struktura2;
typedef struct head struktura3;


struktura3 przepisz_miejscowosci(struktura1 *head_g,struktura2 *head_p, struktura3 head , FILE *miejscowosci);


/* Tworze listę miast głownych oraz osobną liste miast pobocznych, każde miasto głowne ma wskaźnik do pierwszego i ostatniego swojego miasta pobocznego*/
/*Wskaźniki do pierwszych elementów listy glownych miast i pobocznych miast są przechowywane w typedef struct head struktura3 */
  

int main(void)
{
  struktura1 *head_g=NULL;
  struktura2 *head_p=NULL;
  struktura3 head;
  FILE *miejscowosci;

  miejscowosci = fopen("miejscowosci_v2.dat","r");
  if(miejscowosci==NULL)
    {
      perror("Nie udało się otworzyć pliku lub plik jest pusty");
      return 1;
    }

  head.glowne_head=NULL;
  head.poboczne_head=NULL;

  head=przepisz_miejscowosci(head_g, head_p, head, miejscowosci);
   
  fclose(miejscowosci);
printf("Do widzenia\n");
  return 0;
}

struktura3 przepisz_miejscowosci(struktura1 *head_g,struktura2 *head_p, struktura3 head , FILE *miejscowosci)
{
  char temp[255],*result;
  struktura1 *current_g, *previous_g;
  struktura2 *current_p, *previous_p;

  

  rewind(miejscowosci); /*profilaktyki nigdy za duzo*/
  current_g=(struktura1 *)malloc(sizeof(struktura1));
  current_p=(struktura2 *)malloc(sizeof(struktura2));
  
  while(result!=NULL) /*może EOF? */
    { 
      result = fgets(temp,100,miejscowosci);
      if(result!=NULL)
	{
	  if((temp[0]<=100 && temp[0]>=65) || (temp[0]<=122 && temp[0]>=97))
	    {
	     if(head_g==NULL)
	       {
	       head_g=current_g;
	       current_g->myhead=current_p;
	       printf("say what again!");
	       }
	     else
	       {
		 previous_g=current_g; /*dałem to tutaj ze względu na liste pobocznych, do tej linijki cały czas pracuje na currentcie */
	        previous_g->next_m=current_g;
                current_g->myhead=previous_p->next_p; /*head dla każdego pobocznego*/
	       printf("%s",current_g->miasto_g);
	       printf("%s", previous_g->miasto_g);
	       printf("2%s",head_g->miasto_g);
               }
	     current_g->next_m=NULL;
	     current_g->miasto_g=(char *)malloc(sizeof(char)*strlen(temp)+1);
	     strcpy(current_g->miasto_g,temp);
	          	    
	    }
	  else
	    {
	      if(head_p==NULL)
		head_p=current_p; 
              else
		previous_p->next_p=current_p;

	      current_p->next_p=NULL;
	      current_p->miasto_p=(char*)malloc(sizeof(char)*strlen(temp)+1);
	      strcpy(current_p->miasto_p,temp);
	      /*printf("%s",current_p->miasto_p);*/
              current_g->mytail=current_p; /* zapisuje zawsze aż do zmiany| OK */                 
	      previous_p=current_p;
         
	    }
   
	}

    }
  
  
    /*
  while(current_g!=NULL)
    {
      printf("%s",current_g->miasto_g);
      current_g=current_g->next_m;
    }
  */
  
return head;
}
