//Program liczący silnię w sposób iteracyjny oraz rekurencyjny

#include <iostream>

using namespace std;

long int iteracja(int liczba);
long int rekurencja(int liczba, long int wynik);


int main(int argv, char* arg[])
{
  int liczba;
  long int wynik_it, wynik_rek;

  cout << "Program do liczenia silni rekurencyjnie i iteracyjnie" << endl;
  cout << "Podaj liczbę: ";
  cin >> liczba;

  wynik_it=iteracja(liczba);
  wynik_rek=rekurencja(liczba,1);


  cout << "Silnia z " << liczba << " obliczona iteracyjnie wynosi: " <<  wynik_it;
  cout << " a rekurencyjnie : " << wynik_rek << endl;

  return 0;
}

long int iteracja(int liczba)
{
  long int wynik=1;
  int i;

  for(i=1;i<=liczba;i++)
    {
      wynik=wynik*i;
    }

  return wynik;
}

long int rekurencja(int liczba, long int wynik)
{

  if (liczba > 1)
    {
      wynik=rekurencja(liczba-1,wynik*liczba);
    }
  return wynik;
}
	      




