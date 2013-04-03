#include <iostream>
#include <stdlib.h>

using namespace std;

void pomnoz(int tablica[][10]);
void wyswietl(int tablica[][10]);


int main(int argv, char *arg[])
{
  int tablica[10][10],**pomocnicza;
  system("clear");
  cout << "Tabliczka mnozenia" << endl;
  pomnoz(tablica);
  wyswietl(tablica);

  return 0;
}

void pomnoz(int tablica[][10])
{
  for(int y=1;y<=10;y++)
    for(int x=1;x<=10;x++)
      {
	tablica[x-1][y-1]=x*y;
      }
 }

void wyswietl(int tablica[][10])
{
  for(int y=0;y<10;y++)
    {
      for(int x=0;x<10;x++)
	{
	  cout << tablica[x][y];
	  if( tablica[x][y]>9) cout << " ";
	  else cout <<"  ";
	}
      cout << endl;
    }
}
