#include <iostream>
#include "dtab.h"

using namespace std;

void DTab::resize(int newSize)
{
  if (length>newSize) cout << "Rozmiar jest mniejszy od tablicy "<<length<<" "<< newSize << endl;
  if (length<newSize)
    {
      double *nowa=new double [newSize];
      if (length>0 && length < newSize)
	{ 
	  for(int i=0;i<length;i++)
	    nowa[i]=tab[i];
	  tab=nowa;
	  
	} 
    }
}

void DTab::add(double element)
{
  resize(length+1);
  tab[length]=element;
  length++;
  //cout << tab[length] << "!!!!!!!!!" << endl;
}

double DTab::get(int index)
{
  if (length>index) return tab[index];
}

void DTab::set(double element, int index)
{
  if (length>index) tab[index]=element;
}

void DTab::print()
{
  cout << length;
  for(int i=0;i<length;i++)
    cout <<" "<< tab[i] << " ";
  cout << endl;
}


DTab::DTab():length(0),last(0),tab(0)
{
  cout << "Tworze tablice 10"<< endl;
  resize(10);
  length=10;
}


DTab::DTab(int length):last(0)
{
  cout << "Tworze tablice o rozmiarze " << length << endl;
  resize(length);
}

DTab::~DTab()
{
  cout << "destruktor" <<endl;
  if(!tab) delete []tab;
}


  


