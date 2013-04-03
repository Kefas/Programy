//No idea how

#include <iostream>
#include <time.h>
#include <stdlib.h>
#define lenght 5

using namespace std;

void sortowanie(int *tablica, int rozmiar, *(porownanie)(int x,int y));
int *(porownanie)(int x,int y);

int main(int argv, char *argc[])
{
  int tablica[lenght],seed;

  seed=time(NULL);
  srand(seed);

  for(int i=0;i<lenght;i++)
    {
      tablica[i]=rand()%11;
      cout << tablica [i] << " ";
    }

  cout<< endl; << "Sortowanie babelkowe" << endl;
  sortowanie(tablica,lenght, 1);

  return 0;
}

int *(porownanie)(int x, int y)
{
}
