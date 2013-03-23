#include <iostream>
#include <time.h>
#include <stdlib.h>

using namespace std;

//ważne!! sposób przydzielania pamięci dla tablicy dwuwymiarowej!!
int **przydziel_pamiec(int rows, int cols);
void zapelnij(int **tablica,int rows,int cols);
int znajdz(int **tablica,int rows,int cols);

int main(int argv, char *argc[])
{
  int rows,cols, **tablica;

  cout << "Program do szukania największego iloczynu dwóch liczb w tablicy stworzonej dynamicznie przy zlozonosci rzedu O(n)" << endl;

  cout << "Podaj pierwszy wymiar: ";
  cin >> cols;
  cout << "Podaj drugi wymiar: ";
  cin >> rows;


  tablica=przydziel_pamiec(rows,cols);
  zapelnij(tablica,rows,cols);
  int iloczyn=znajdz(tablica,rows,cols);

  cout << "Najwiekszy iloczyn=" << iloczyn <<endl;

  return 0;
}

int ** przydziel_pamiec(int rows, int cols)
{
  int **tablica;

  tablica = new int *[rows];
  for(int i=0;i<rows;i++)
    tablica[i] = new int [cols];
  return tablica;
}

void zapelnij(int **tablica,int rows,int cols)
{
  int seed;
  seed = time(NULL);
  srand(seed);
  for (int i=0;i<rows;i++)
    for(int j=0;j<cols;j++)
      *(*(tablica+i)+j)=rand() % 10;
  
}

int znajdz(int **tablica,int rows, int cols)
{
  int x=0,y=0;

  for(int i=0;i<rows;i++)
    for(int j=0;j<cols;j++)
      if (*(*(tablica+i)+j)>=x)
        {
	  y=x;
	  x=*(*(tablica+i)+j);
	}
  return x*y;
}
      
