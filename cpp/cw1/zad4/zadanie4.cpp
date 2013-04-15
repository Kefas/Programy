#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

using namespace std;

bool sprawdz(char *slowo);

int main(int argv, char* arg[])
{
  char *slowo,bufor[255],c='1';
  cout << "Program do sprawdzania czy dane slowo jest palindromem" <<endl;
  while (c=='1' || c=='2')
    {
      cout << "1. Wyjscie" << endl << "2. sprawdz palindrom";
      c=getchar();
      if (c=='1') return 0;
      if (c=='2')
	{
	  system("clear");
	  cout << "Prosze wpisac slowo: ";
	  cin >> bufor;
	  slowo = new char[strlen(bufor)];
	  strcpy(slowo,bufor);

	  if(sprawdz(slowo)==true) cout << "Slowo "<< slowo <<" to palindrom" << endl;
	  else cout << "Slowo " << slowo << " nie jest palindromem" <<endl;
	}
      c='1';
      cin.ignore(1000,'\n'); //usuwanie z wejscia zbednych znakow 
    }
  delete [] slowo;
  return 0;
}

bool sprawdz(char *slowo)
{
  int x,i;

  x=strlen(slowo);
  for(i=0;i<x;i++)
    {
      if (slowo[i]!=slowo[x-1-i])
	return false;
    }
  return true;
}
