#include <iostream>
#include <stdlib.h>
#include <time.h>
#include "funkcje.h"

using namespace std;

typedef int type;

void bubble_sort(type *tab, int length);


int main(int argc, char * argv[])
{
  int tab[10],seed;

  seed = time(NULL);
  srand(seed);

  for (int i=0; i<10; i++)
    tab[i]=rand()%100;
  print(tab,10);
  bubble_sort(tab,10);
  print(tab,10);

  return 0;
}


void bubble_sort(type *tab, int length)
{
  int n=length;

  do{
  for (int i=0; i<length-1; i++)
    {
      if (compare(tab[i],tab[i+1]) == -1)
	swap(tab,i,i+1);
    }
  n--;
  }while(n>1);
}
