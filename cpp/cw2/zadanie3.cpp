#include <iostream>
#define rozmiar 3

using namespace std;
void wyswietl(int tablica[][5],int rows, int cols);

int main(int argv, char *argc[])
{
  int tablica[rozmiar][5]={0};

  cout << "Wyswietlanie tablicy dwuwymiarowej za pomocą jednej pętli for" << endl;

  wyswietl(tablica,rozmiar,5);
 return 0;
}

void wyswietl(int tablica[][5],int rows, int cols)
{

  for(int i=0;i<rows;i++)
    {
      cout << *(*(tablica+i)+0) << " " << *(*(tablica+i)+1) << " " << *(*(tablica+i)+2) << " " << *(*(tablica+i)+3) << " " << *(*(tablica+i)+4) << endl;
    }
}
