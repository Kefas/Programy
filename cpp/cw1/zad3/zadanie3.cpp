#include <iostream>
#define x 5

using namespace std;

char* rekurencja(char slowo[x], char wspak[x], int r);

int main(int argv, char* arg[])
{
  char slowo[x], wspak[x];

  cout << "Program do wyswietlania napisu wspak w sposob rekurencyjny" << endl << "Prosze wpisac jakies slowo: ";
  cin >> slowo;
  cout << "Slowo: " << slowo << " obrocone na wspak wyglada tak: " << rekurencja(slowo, wspak, 0) <<endl;

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
