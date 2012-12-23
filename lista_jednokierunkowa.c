#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct element
{
  struct element *next;
  char tytul[255];
  int ocena;
};

/* VFI! dodaj_element musi zwracać adres heada! Dlaczego? Jeśli deklaracja heada jest w mainie to wtedy jego zasięg jest automatyczny a nie globalny co znaczy, że trzeba go przekazać do funkcji ponieważ funkcja go nie zobaczy. Trzeba go również zwrócić jeżeli zmieniony head ma działać w innych funkcjach, zwróc uwagę, że funkcja jest z operatorem dereferencji (*) co ustala zwracaną wartość jako wskaźnik. 
Za kilka lat będę pewnie przerażony jakim jestem noobem, ale cóż. jestem.
~Piotr z przeszłości */

struct element *dodaj_element(struct element *head);
void wyswietl(struct element *head);
void uwolnij_pamiec(struct element *head);

int main(void)
{
  struct element *head=NULL;  /* wyrzucam wskaźnik do current i previous do każdej funkcji, mogą być tu ale trzeba je przekazać */
  head=dodaj_element(head);
  wyswietl(head);
  uwolnij_pamiec(head);
  
  return 0;
  

}

struct element *dodaj_element(struct element *head)  
{
  struct element *previous, *current;
  char temp[255];

  puts("Podaj pierwszy tytul filmu");

  while(gets(temp) != NULL && temp[0] != '\0')
    {
      current = (struct element *)malloc(sizeof(struct element));
      
      if(head == NULL)  /*zachodzi tylko w przypadku początku*/
	head=current;
      else                 /* dla każdej następnej */
	previous->next=current; /*tworze dowiazanie do nastepnego*/
      
      current->next=NULL; /*wskażnik z ostatniego elementu wskazuje na NULL */     /*uzupelnianie aktualnego elementu listy*/
      strcpy(current->tytul,temp);
      puts("Podaj ocene");
      scanf("%d",&current->ocena);

      while(getchar() != '\n')
	continue;

      puts("Podaj nastepny tytul, pusty wiersz konczy program");
      previous=current;
    }
  return head;
} 


void wyswietl(struct element *head)
{
  struct element *current;
  if(head==NULL)
    printf("Nie wypisano żadnych danych");
  else
    {
    printf("oto lista filmow\n");

    current=head;   
    
    while(current!=NULL)
     {
       printf("Film %s Ocena: %d\n", current->tytul, current->ocena);
       current = current->next;
     }
    }
  printf("pa");

}
void uwolnij_pamiec(struct element *head)
{
 struct element *previous, *current;
 current=head;

 while(current!=NULL)   /*zwalnianie pamięci */
    {
      previous=current;
      current=previous->next;
      free(previous);
    }
}
