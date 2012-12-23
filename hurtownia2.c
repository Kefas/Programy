#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

/*Funkcja przepisz_miejscowosci przepisuje główne i pobocnze miasta do osobnych list, każde głowne miasto ma wskaźnik do pierwszego i ostatniego miasta pobocznego */



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
  struct artykuly *artykuly_head;
};

struct artykuly
{
  long int id;
  char *artykul;
  struct artykuly *next_a;
};

typedef struct glowne struktura1;
typedef struct poboczne struktura2;
typedef struct head struktura3;
typedef struct artykuly struktura4;

struktura3 przepisz_miejscowosci(struktura1 *head_g,struktura2 *head_p, struktura3 head , FILE *miejscowosci);

struktura3 przepisz_artykuly(struktura4 *head_a, struktura3 head, FILE *artykuly);



void uwolnij(struktura3 head);

/*Wskaźniki do pierwszych elementów listy glownych miast i pobocznych miast są przechowywane w typedef struct head struktura3 */
  

int main(void)
{
  struktura1 *head_g=NULL;
  struktura2 *head_p=NULL;
  struktura3 head;
  struktura4 *head_a=NULL;
  FILE *miejscowosci,*artykuly;

  miejscowosci = fopen("miejscowosci_v2.dat","r");
  artykuly = fopen("artykuly.dat","r");
  if(miejscowosci==NULL)
    {
      perror("Nie udało się otworzyć pliku miejscowosci_v2.dat  lub plik jest pusty");
      return 1;
    }
  if(artykuly==NULL)
    {
      perror("Nie udało sie utworzyc pliku artykuly.dat lub plik jest pusty");
      return 1;
    }
  /*usunalem head.glowne_head=NULL*/
  head=przepisz_miejscowosci(head_g, head_p, head, miejscowosci);
  head=przepisz_artykuly(head_a,head,artykuly);

  printf("%s",head.glowne_head->miasto_g);

  uwolnij(head);
  fclose(miejscowosci);
  printf("Do widzenia\n");
  return 0;
}

struktura3 przepisz_miejscowosci(struktura1 *head_g,struktura2 *head_p, struktura3 head , FILE *miejscowosci)
{
  int i=0;/* i jest mi potrzebne do ustalania myheada dla pierwszego */
  char temp[255],buff[255],*result;
  struktura1 *current_g, *previous_g;
  struktura2 *current_p, *previous_p;
  head_g=NULL;  

  rewind(miejscowosci); /*profilaktyki nigdy za duzo*/
  current_g=(struktura1 *)malloc(sizeof(struktura1));
  current_p=(struktura2 *)malloc(sizeof(struktura2));
  
  /* head_g=current_g;*/
  while(result!=NULL) /*może EOF? */
    { 
          result = fgets(temp,100,miejscowosci);
      
	  if((temp[0]<=90 && temp[0]>=65) || (temp[0]<=122 && temp[0]>=97))
	    {
	     if(head_g==NULL)
	       {
		 head_g=current_g;
		 /*head do "najpierwszego" ↓ */
		 current_g->myhead=current_p;
		 i=0;
               }
	     else
	       {		 	 
                 current_g=(struktura1 *)malloc(sizeof(struktura1));
		 previous_g->next_m=current_g;                  
	       }
	     current_g->next_m=NULL;
	     /*instrukcje*/
	     current_g->miasto_g=(char*)malloc(sizeof(char)*strlen(temp)+1);
	     strcpy(current_g->miasto_g,temp);

	     previous_g=current_g;         
             i=1;	        	    
	    }
	  else
	    {
	     if(head_p==NULL)
	       {
		 head_p=current_p;
		 i=0;
	       }
	     else
	       {
                 current_p=(struktura2 *)malloc(sizeof(struktura2));	
	         previous_p->next_p=current_p;
		 if(i==1)
		   {
		     current_g->myhead=current_p;
		     i=0;
		   }
               }    
	     current_p->next_p=NULL;
	     /*instrukcje*/
	     /*%[A-Za-z ] wczytuje tylko te określone znaki i spacje dzięki temu moge pobrac 2 słowa jako jeden string*/
	     sscanf(temp, "%d %[A-Za-z ] \n",&current_p->odleglosc,buff);
	     current_p->miasto_p=(char*)malloc(sizeof(char)*strlen(buff)+1);
	     strcpy(current_p->miasto_p,buff);
	     
             /*koniec pobocznych od głównego to ↓ */
             current_g->mytail=current_p;
	     previous_p=current_p;
	    }
   
    }
  /*  current_p=head_p;
  current_g=head_g;
  
  while(current_g!=NULL)
    {
      printf("%s",head_p->miasto_p);
      printf("Myhead: %s, %d\n",current_g->myhead->miasto_p,current_g->myhead->odleglosc);
      printf("Mytail: %s  %d\n",current_g->mytail->miasto_p,current_g->mytail->odleglosc);
 current_p=current_g->myhead;
       
      
      do
	{
	  printf("-%s - %d\n",current_p->miasto_p, current_p->odleglosc);
	  current_p=current_p->next_p;
	}while(current_p!=current_g->mytail);
      
      current_g=current_g->next_m;
      }*/
  head.glowne_head=head_g;
  head.poboczne_head=head_p;
    
return head;
}

struktura3 przepisz_artykuly(struktura4 *head_a, struktura3 head, FILE *artykuly)
{
  struktura4 *current_a,*previous_a;
  char temp[255],buff[255], *result;

  /* to pewnie mogę dać do funkcji */
  current_a=(struktura4 *)malloc(sizeof(struktura4));
  rewind(artykuly);
  
  while(result!=NULL)
    {
      result=fgets(temp,100,artykuly);

      if(head_a==NULL)
	{
	  head_a=current_a;
	}
      else
	{
	  current_a=(struktura4 *)malloc(sizeof(struktura4));
	  previous_a->next_a=current_a;
	}
      current_a->next_a=NULL; 
      sscanf(temp, "%ld %[a-zA-Z0-9/- ]\n",&current_a->id,buff);      
      current_a->artykul=(char *)malloc(sizeof(char)*strlen(buff)+1);
      strcpy(current_a->artykul,buff);
     
      previous_a=current_a;
    }
  head.artykuly_head=head_a;

  return head;
}


void uwolnij(struktura3 head)
{
struktura1 *previous_g, *current_g;
struktura2 *previous_p, *current_p;
struktura4 *previous_a, *current_a;

 current_g=head.glowne_head;
 current_p=head.poboczne_head;
 current_a=head.artykuly_head;
while(current_g!=NULL)
  {
    previous_g=current_g;
    current_g=current_g->next_m;
    free(previous_g);
  }
while(current_p!=NULL)
  {
    previous_p=current_p;
    current_p=current_p->next_p;
    free(previous_p);
  }
while(current_a!=NULL)
  {
    previous_a=current_a;
    current_a=current_a->next_a;
    free(previous_a);
  }
}
