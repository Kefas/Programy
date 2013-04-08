#include <iostream>
#include "ksztalt.h"

using namespace std;

void Kolo::rysuj()
{
  cout << "Kolo o promieniu "<< this->r<<" i wspolrzednych (" << this->x<<";"<<this->y <<")" << endl;
  cout << "  #  "<< endl << " ### " <<endl << "#####"<< endl << " ### " <<endl<< "  #  " << endl;
}

void Trojkat::rysuj()
{
  cout << "Trojkat o dlugosci boku"<< this->a<<" i wspolrzednych (" << this->x<<";"<<this->y <<")" << endl;
  cout << "  ^  " << endl << " ^^^ " << endl << "^^^^^" <<endl;
}

void Kwadrat::rysuj()
{
  cout << "Kwadrat o dlugosci boku "<<this->a<<" i wspolrzednych (" << this->x<<";"<<this->y <<")" << endl;
  cout << "###" << endl << "###"<< endl << "###" <<endl;
}
