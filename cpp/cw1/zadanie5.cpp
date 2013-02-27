#include <iostream> // Funkcje sa zagniezdzone i nie bardzo kminie jak sie tablice  dwuwymiarowe przesuwa

using namespace std;

void pomnoz(int tablica[][10]);
void wyswietl(int tablica[][10]);


int main(int argv, char *arg[])
{
  int tablica[10][10],**pomocnicza;

  cout << "Tabliczka mnozenia" << endl;

  pomnoz(tablica);
  

  return 0;
}

void pomnoz(int tablica[][10])
{
  int x,y;

  for(y=1;y<=10;y++)
    for(x=1;x<=10;x++)
      {
	tablica[x-1][y-1]=x*y;
      }
  wyswietl(tablica);
}

void wyswietl(int tablica[][10])
{
  int y,x;

  for(y=0;y<10;y++)
    {
      for(x=0;x<10;x++)
	{
	  cout << tablica[x][y];
	  if( tablica[x][y]>9) cout << " ";
	  else cout <<"  ";
	}
      cout << endl;
    }
}
