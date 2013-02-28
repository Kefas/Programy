#include <stdio.h>
#include <stdio.h>

#define ROZMIAR 5
 

int main(void)
{
    int zarodek;
    zarodek= time(NULL);
    srand(zarodek); 

int *p,w,m, *emax, i, z, *wsk, n;

int tablica[ROZMIAR];
int tablica2[ROZMIAR];


for(z=1;z<=ROZMIAR;z++)
  {
   tablica2[z-1]=z;
   tablica[z-1]=rand()%1000000;   
  }
p=tablica;
wsk=tablica2;

printf("rozmiar = %d", ROZMIAR);
emax=(tablica + ROZMIAR-1);

printf("wyniki nieuporzadkowane:\n");
for(n=0;n<=ROZMIAR-1;n++)
printf("Kandydat %d  - Liczba głosów: %d\n",*(wsk+n), *(p+n));

i=0;


while(i<ROZMIAR-1)
{
 if ( *p < *(p+1) )
    {
            
      w=*p;
      *p=*(p+1);
      *(p+1)=w;
      
      m=*wsk;
      *wsk=*(wsk+1);
      *(wsk+1)=m;
     
    } else i++;
   p=p+1;
   wsk=wsk+1;
 if ( (p==emax)&&(i!=ROZMIAR-1) )
    {
      i=0;
      p=tablica;
      wsk=tablica2;
    } else;
}

p=tablica;    /*trzeba ustawić wskaźniki na początek znowu*/
wsk=tablica2;

printf("wyniki:\n");
for(n=0;n<=ROZMIAR-1;n++)
printf("Kandydat %d  - Liczba głosów: %d\n",*(wsk+n), *(p+n));

return 0;

}
