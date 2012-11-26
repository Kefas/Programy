#include <stdio.h>

#define ROZMIAR 2

void sortuj(int (*tablica)[ROZMIAR]);

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
   
  for(i=0;i<=4;i++)
   printf(" %s ", tytuly[i] );
  
   printf("\n");

   sortuj(tablica);
 
  for(i=0;i<ROZMIAR;i++)
    printf(" %s  %d  %d  %d  %d \n", nazwiska[ tablica[0][i] ], tablica[1][i], tablica[2][i], tablica[3][i], tablica[4][i] );
 
          
            


return 0;
}
void sortuj(int (*tablica)[ROZMIAR]) //wszystko spoko.. tylko, że to nie zadziała.. chyba, że zwrócę wartości tej tablicy ale chyba lepiej pozamieniać adresy wskaźników.y
{
  int j,porzadek;
  
  while(j<ROZMIAR+1) //pętla nieskonczona UWAGA
    {
      if(((tablica[4][j]<tablica[4][j+1])) || ((tablica[4][j]==tablica[4][j+1]) && (tablica[3][j]<tablica[3][j+1])) || ((tablica[4][j]==tablica[4][j+1]) && (tablica[3][jtablica[3][j+1]) && (tablica[2][j]<tablica[2][j+1]) ) )
       {
        for(w=4;w=0;w--) 
         {
         z=tablica[w][j];
         tablica[w][j]=tablica[w][j+1];
         tablica[w][j+1]=z;
         }
        }else porzadek++;
        j++;    
        if (porzadek!=ROZMIAR-1) j=0;
        if (porzadek==ROZMIAR-1) break;
   return 0;    
   }




