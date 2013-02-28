#include <stdio.h>
#include <conio.h>

int main(void)
{
float n, i;
int miesiace[12]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int index, j;

printf("podaj numer miesiaca 1-styczen 12-grudzien");
scanf("%d", &index-1);
printf("podaj od jakiego dnia ma sie zaczac 0- niedziela 7 sobota:");
scanf("%f", &n-1);

clrscr();

printf("Ni  Pn  Wt  Sr  Cz  Pt  Sb\n");

for (j=0; j<n; j++)
printf("    ");

for (i=1; i<miesiace[index]; i++)
{
printf("%2.0f  ", i);

 if ((((7-n)/i)==1) || (((14-n)/i)==1) || (((21-n)/i)==1) || (((28-n)/i)==1) || (((35-n)/i)==1))
printf("\n");
}
}

