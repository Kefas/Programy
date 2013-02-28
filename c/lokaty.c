#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 4

void sort(int tab[][5]);
void print(int tab[][5] ,char *names[SIZE], float profit[SIZE]);
void bonus(int tab[][5], int date[3], float profit[SIZE]);

int main(void)
{
  float profit[SIZE];
  char *names[SIZE];
  char buffor[30];
  int length, i, tab[SIZE][5], date[3], time;
  
  printf("Welcome, enter the date(day [enter] month [enter] year [enter]");  /*Pobranie daty*/
  for(i=0;i<3;i++)
    {
      scanf("%d",&time);
      date[i]=time;
    }
  
  for(i=0; i<SIZE; i++) profit[i]=0;                                        /*zerowanie tablicy profitów*/ 

  for(i=0;i<SIZE; i++)
    {
      gets(buffor);
      printf("Please type the name: ");                                     /* Przydział imienia do listy indeksu*/
      gets(buffor);
      length=strlen(buffor);
      names[i]=(char*)malloc((length+1)*sizeof(char));
    
      if (names[i]==NULL)
	{ 
	 printf("Memory allocate problem");
         return 1;
	}
      
      strcpy(names[i], buffor);
    
      
      
	tab[i][0]=i;                                                        /* Wpisywanie danych*/
      printf("Please type the size of investment %s : ", names[i]);
      scanf("%d", &tab[i][1]);
      printf("Please enter the day of starting this investment : ");
      scanf("%d", &tab[i][2]);
      printf("Please eneter the month of starting this investment : ");
      scanf("%d", &tab[i][3]);
      printf("Please enter the year of starting this investment : ");
      scanf("%d", &tab[i][4]);
      
      
}
 
  print(tab, names, profit);

  sort(tab);
  
  bonus(tab,date,profit);

  print(tab,names, profit);

return 0;
}

void print(int tab[][5],char *names[SIZE], float profit[SIZE])
{
  int i;

  printf("Name     amount      day      month     year     profit \n");
  for(i=0; i<SIZE; i++)
    {
      printf(" %s    %d    %d    %d    %d    %f  \n", names[tab[i][0]], tab[i][1], tab[i][2], tab[i][3], tab[i][4], profit[i]);
    }
}

void sort(int tab[][5])
{
 
  int stop=1,z,i,n;                                                    /*sortowanie bąblekowe ze znacznikiem*/
 while (stop!=0)
	{
        stop=0;
        for (i=0; i<SIZE-1; i++)
	  {
	    if ( (tab[i][4]<tab[i+1][4]) || ((tab[i][4]==tab[i+1][4])&&(tab[i][3]<tab[i+1][3])) || ((tab[i][4]==tab[i+1][4])&&(tab[i][3]==tab[i+1][3])&&(tab[i][2]<tab[i+1][2])) )
            {
              for(n=0;n<5;n++)
		{
                 z=tab[i][n];
                 tab[i][n]=tab[i+1][n];
                 tab[i+1][n]=z;
                 stop=1;
		}            
	    }
	  }

        } 
}


void bonus(int tab[][5], int date[3], float profit[SIZE])
{
  int i;
  float x;
  for(i=0;i<SIZE;i++)
    {
      x=tab[i][1];
      if ( ((date[2]-tab[i][4]>=1) && (date[1]-tab[i][3]>=0) && (date[i]-tab[i][2]>0)) || ((date[2]-tab[i][4]>=1)&&(date[1]-tab[i][3]>0)) ||  (date[2]-tab[i][4]>1))
    profit[i]=(x*5)/100;
      if ( ((date[2]-tab[i][4]<=1) && (date[1]-tab[i][3]>=3) && (date[1]-tab[i][3]>0)) || ( (date[2]-tab[i][4]=<1) && (date[1]+12-tab[i][3]>3)))
    profit[i]=(x*3)/100;
      if ( (date[2]-tab[i][4]<=1) && (date[1]-tab[i][3]>0) && (date[0]-tab[i][3]>=0) )
  profit[i]=x/100;
      if(((date[2]==tab[i][4]) && (date[1]==tab[i][3]))|| ((date[2]==tab[i][4])&& (date[1]-tab[i][3]==1)&&(date[0]<tab[i][2])))
	profit[i]=0;    
}
}
