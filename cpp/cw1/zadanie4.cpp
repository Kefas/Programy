#include <iostream>
#include <stdio.h>
//Polecam dopisac funkcje czyszczaca ekran
using namespace std;

bool sprawdz(char slowo[10]);

int main(int argv, char* arg[])
{
  char slowo[10],c='1';
  cout << "Program do sprawdzania czy dane slowo jest palindromem" <<endl;
  while (c=='1' || c=='2')
    {
      cout << "1. Wyjscie" << endl << "2. sprawdz palindrom";
      c=getchar();
      if (c=='1') return 0;
      if (c=='2')
	{

	  cout << "Prosze wpisac slowo: ";
	  cin >> slowo;
	  if(sprawdz(slowo)==true) cout << "Slowo "<<slowo<<" to palindrom"<<endl;
	  else cout <<"Slowo " <<slowo<<" nie jest palindromem"<<endl;
	}
      c='1';
    }
}

bool sprawdz(char slowo[10])
{
  int x,i;

  x=sizeof(slowo);

  for(i=0;i<=x;i++)
    {
      if (slowo[i]!=slowo[x-i])
	return false;
      else return true;
    }
}
