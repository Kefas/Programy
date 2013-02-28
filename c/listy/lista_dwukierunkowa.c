#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct element
{
  struct element *nastepnik, *poprzednik;
  char tytul[255];
  int ocena;
};

int main(void)
{
  struct element *head=NULL,*tail;
  struct element *previous, *current;
  char temp[255],c;
  puts("Podaj pierwszy tytul filmu");
  
  
  while(gets(temp) != NULL && temp[0] != '\0')
    {
      current = (struct element *)malloc(sizeof(struct element));
      if(head == NULL)  /*zachodzi tylko w przypadku początku*/
	{	
         head=current;
	 current->poprzednik=NULL;
	}
      else
	{                 /* dla każdej następnej */
	previous->nastepnik=current;
	/* current->poprzednik=previous;*/
	}       
 
      current->nastepnik=NULL; /*wskażnik z ostatniego elementu wskazuje na NULL */
      strcpy(current->tytul,temp);
      puts("Podaj ocene");
      scanf("%d",&current->ocena);
      while(getchar() != '\n')
	continue;
      puts("Podaj nastepny tytul, pusty wiersz konczy program");
     current->poprzednik=previous;
      previous=current;
      
    }
  
  tail=current;

  if(head==NULL)
    printf("Nie wypisano żadnych danych");
  else
    {
    printf("oto lista filmow\n");
    current=head;
    printf("Film %s Ocena: %d\n", current->tytul, current->ocena);
    

}



printf("Nastepny (n) czy poprzedni (p) rekord? exit(e)");
  while(c!='e')
    {      
      c=getchar();
      if(c=='n')
	{ 
	  if(current->nastepnik==NULL)
	    {
	      printf("przykro mi ale dalej nic nie ma"); 
	    }
	  else
	    {
              current = current->nastepnik;
              printf("Film %s Ocena: %d\n", current->tytul, current->ocena);
	    }
	}
      if(c=='p')
	{
	  if(current->poprzednik==NULL)
	    {	  
             printf("Przykro mi ale nic już tam dalej nie ma");
	    }
	  else
	    {	  
             current=current->poprzednik;
	     printf("Film %s Ocena: %d\n", current->tytul, current->ocena);
	    }
	}
    }
  printf("pa");

  current=head;
  while(current!=NULL)   /*zwalnianie pamięci */
    {
      previous=current;
      current=previous->nastepnik;
      free(previous);
    }
  return 0;
  

}
