#include <stdio.h>

#define ROZMIAR 2

void sortuj(int tablica[5][ROZMIAR] );

int main(void)
{
 char nazwiska[ROZMIAR][30];
 char tytuly[5][20] = {"Nazwisko" , "Wielkosc lokaty", "Dzien", "Miesiac", "Rok"};
 int i, tablica[5][ROZMIAR];


 for(i=0; i<ROZMIAR; i++)
 {
  printf("\nPodaj mi %d. nazwisko ", i);
  scanf("%s",nazwiska[i]);
  tablica[0][i]=i;
  
   printf("\nPodaj mi Wielkosc lokaty %s ", nazwiska[i]);
    scanf("%d", &tablica[1][i]);
   printf("\nPodaj mi Dzien zalozenia lokaty %s ", nazwiska[i]);
    scanf("%d", &tablica[2][i]);
   printf("\nPodaj mi Miesiac zalozenia lokaty %s ", nazwiska[i]);
    scanf("%d", &tablica[3][i]);
   printf("\nPodaj Rok zalozenia tablicy %s ", nazwiska[i]);
    scanf("%d", &tablica[4][i]);
 }
   
  for(i=0;i<3;i++)
   printf(" %s ", tytuly[i] );
  
   printf("\n");

  printf("jestem tu");

  sortuj( tablica );
 
  for(i=0;i<ROZMIAR;i++)
    printf(" %s  %d  %d  %d  %d \n", nazwiska[ tablica[0][i] ], tablica[1][i], tablica[2][i], tablica[3][i], tablica[4][i] );
 
          
            


return 0;
}
void sortuj(int tablica[5][ROZMIAR]) 
{
  
  int j, porzadek,w, (*wsk)[ROZMIAR];
  wsk=tablica;
 printf("jestem tu");
 
  
  while(j<ROZMIAR+1)
    {
      if (( *(*(tablica)+4)<*(*(tablica+1)+4) )  ||  (( *(*(tablica)+4)==*(*(tablica+1)+4) ) && ( *(*(tablica)+3)<*(*(tablica+1)+3) )) || ( ( *(*(tablica)+4)==*(*(tablica+1)+4) ) && ( *(*(tablica)+3)==*(*(tablica+1)+3) ) && ( *(*(tablica)+2)<*(*(tablica+1)+2) )))  
       {
         w=(*tablica)[ROZMIAR];
         (*tablica)[ROZMIAR]=(*(tablica+1))[ROZMIAR];
         (*(tablica+1))[ROZMIAR]=w;

       }else porzadek++;
        j++;
        (*tablica)[ROZMIAR]=(*(tablica+1))[ROZMIAR];    
        if (porzadek!=ROZMIAR-1)
	  {
            j=0;
            tablica=wsk;
	  }

	  if (porzadek==ROZMIAR-1) break;    
	  }
}


