#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct element
{
  struct element *next;
  char tytul[255];
  int ocena;
};

struct element *head;
struct element *previous, *current;


void dodaj_element();
void wyswietl();
void uwolnij_pamiec();

int main(void)
{
  
  dodaj_element();  
  wyswietl();
  uwolnij_pamiec();
  
  return 0;
  

}

void dodaj_element()
{
  
  char temp[255];
  head=NULL;
  puts("Podaj pierwszy tytul filmu");

  while(gets(temp) != NULL && temp[0] != '\0')
    {
      current = (struct element *)malloc(sizeof(struct element));
      if(head == NULL)  /*zachodzi tylko w przypadku początku*/
	head=current;
      else                 /* dla każdej następnej */
	previous->next=current;
      
      current->next=NULL; /*wskażnik z ostatniego elementu wskazuje na NULL */
      strcpy(current->tytul,temp);
      puts("Podaj ocene");
      scanf("%d",&current->ocena);
      while(getchar() != '\n')
	continue;
      puts("Podaj nastepny tytul, pusty wiersz konczy program");
      previous=current;
    }
  
 } 

/* Nie wiem co jest.. wchodzi do funkcji ale nic nie zwraca. Poczytać o wskaźnikach i przekazaniach do funkcji */


void wyswietl()
{
if(head==NULL)
    printf("Nie wypisano żadnych danych");
  else
    {
    printf("oto lista filmow\n");
    current=head;
    }
  while(current!=NULL)
    {
      printf("Film %s Ocena: %d\n", current->tytul, current->ocena);
      current = current->next;
    }
  printf("pa");
  
  current=head;
}

void uwolnij_pamiec()
{
while(current!=NULL)   /*zwalnianie pamięci */
    {
      previous=current;
      current=previous->next;
      free(previous);
    }
}
