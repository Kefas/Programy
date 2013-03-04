#include <iostream>
#include "dtab.h"

using namespace std;


void DTab::resize(int newSize)
{
  cout << "cos";
  if (length>=newSize) cout << "Rozmiar jest mniejszy od tablicy";
  if (length<newSize)
    {
      double *nowa=new double [newSize];
      if (length>0 && length < newSize)
	{ 
	  for(int i=0;i<length;i++)
	    nowa[i]=tab[i];
	  tab=nowa;
	  nowa=NULL;
	} 
    }
};


DTab::DTab():length(0),last(0)
{
  cout << "Tworze tablice 10";
  resize(10);
};

/*
DTab::DTab(int length)
{
  double *tablica=new double [length];
};
*/

  


int main(int argc, char *argv[])
{

  DTab tablica();
  return 0;
}


