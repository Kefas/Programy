#ifndef FUNKCJE_H
#define FUNKCJE_H

#include <iostream>

using namespace std;

typedef int type;

void print(type *tab, int length)
{
  for (int i=0;i<length;i++)
    cout << tab[i] << " ";
  cout << endl;
}


int compare(type val1, type val2)
{
  if (val1 > val2) return -1;
  if (val1 == val2) return 0;
  if (val1 < val2) return 1;
}

void swap(type *tab,type val1, type val2)
{
  type temp;

  temp=tab[val1];
  tab[val1]=tab[val2];
  tab[val2]=temp;
}


#endif
