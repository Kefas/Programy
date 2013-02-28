#include <stdio.h>

int silnia(int n);

int main(void)
{
 int n, wynik=0;
 char ch;
printf("To program do liczenia silni od 0 do 7, Podaj liczbę\n");
 
do
{ 
   while(scanf("%d",&n)==1)
    {
      if(n>7)
	printf("zly zakres\n");
      else if(n<0)
	printf("zly zakres\n");
      else
	{
         wynik=silnia(n);
         printf("wynik to %d\n", wynik);
	}
      printf("kontynuować? y/n");
    }
 } while((ch=getchar())!='n');
return 0;
}

int silnia(int n)
{
if(n<=1)
  return 1;
if(n>=2)
  return n*silnia(n-1);
return 0;
}
