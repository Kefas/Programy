#include <stdio.h>

#define ROZMIAR 2

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
 printf("%d", tablica[4][1]);
  
  for(i=0;i<=4;i++)
   printf(" %s ", tytuly[i] );
  
   printf("\n");
 
  for(i=0;i<ROZMIAR;i++)
    printf(" %s  %d  %d  %d  %d \n", nazwiska[ tablica[0][i] ], tablica[1][i], tablica[2][i], tablica[3][i], tablica[4][i] );
 
          
            


return 0;
}

