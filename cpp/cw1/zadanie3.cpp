#include <iostream>
#define x 5

using namespace std;

char* rekurencja(char slowo[x], char wspak[x], int r);

int main(int argv, char* arg[])
{
  char slowo[x], wspak[x], *wynik;

  cout << "Program do wyswietlania napisu wspak w sposob rekurencyjny" <<endl;
  cout << "Prosze wpisac jakies slowo: ";
  cin >> slowo;

  wynik=rekurencja(slowo, wspak, 0);

  cout << "Slowo: " << slowo << " obrocone na wspak wyglada tak: " << wynik <<endl;

  return 0;
}

char* rekurencja(char slowo[x], char wspak[x], int r)
{

  if (slowo[r]!='\0')
    {
      wspak[sizeof(slowo)-r]=slowo[r];
      wspak=rekurencja(slowo, wspak, r+1);
    }
  return wspak;
}
