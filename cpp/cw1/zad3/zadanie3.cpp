#include <iostream>
#include <string.h>

using namespace std;

char* rekurencja(char *slowo, char *wspak, int r);

int main(int argv, char* arg[])
{
  char *slowo, *wspak, bufor[255];

  cout << "Program do wyswietlania napisu wspak w sposob rekurencyjny" << endl << "Prosze wpisac jakies slowo: ";
  cin >> bufor;
  slowo = new char[strlen(bufor)];
  wspak = new char[strlen(bufor)];
  strcpy(slowo,bufor);
  cout << "Slowo: " << slowo <<" obrocone na wspak wyglada tak: " << rekurencja(slowo, wspak, 0) <<endl;

  delete slowo;
  delete wspak;
  return 0;
}

char* rekurencja(char *slowo, char *wspak, int r)
{
  if (slowo[r]!='\0')
    {
      wspak[strlen(slowo)-r-1]=slowo[r]; // pamiętać ze numerowanie zaczyna się od 0
      wspak=rekurencja(slowo, wspak, r+1);
    }
  return wspak;
}
