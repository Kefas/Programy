#include <iostream>

using namespace std;

void pomnoz(int **tablica, int cols, int rows);
void wyswietl(int **tablica, int cols, int rows);

int main(int argv, char *argc[])
{
  int **tablica,rows,cols;

  cout << "Program do alokacji pamięci dla tablicy R2" << endl;
  cout << "Podaj ilosc wierszy: ";
  cin >> cols;
  cout << "Podaj ilosc kolumn: ";
  cin >> rows;

  tablica = new int *[cols];
  
  for(int i=0;i<cols;i++)
    tablica[i]=new int [rows];

  pomnoz(tablica,cols,rows);
  wyswietl(tablica,cols,rows);

  for(int j=0;j<cols;j++)
    delete [] tablica[j];
 
  delete [] tablica;
 
  return 0;
}

void pomnoz(int **tablica, int cols, int rows)
{
  for(int i=0;i<cols;i++)
    for(int j=0;j<rows;j++)
      *(*(tablica+i)+j)=i*j;
}
void wyswietl(int **tablica,int cols, int rows)
{
  for(int i=0;i<cols;i++)
    {
      for(int j=0;j<rows;j++)
	{
	  cout << *(*(tablica+i)+j);
	  
	  if( i*j<10) cout << "  ";
	  else cout << " ";
	}
      cout << endl;
    }
}

