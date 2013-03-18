//Definicja znajduje się w pliku punkt.cpp
#include "punkt.h"
#include <math.h>
#include <iomanip>
#include <iostream>
 
using namespace std;
 
/* Aby wskazać, ze definicja funkcji dotyczy metody danej klasy
  stosujemy tzw. operator zasięgu - "::" 
*/
 
//Specjalna inicjalizacja zmiennych. Zmienne są inicjowane
//nim zostanie wywołane ciało konstruktora

istream& operator>>(istream& input, Punkt& p){
	 input.ignore();    // Ignoruj nawias
   input >> p.x;
   input.ignore();    // Ignoruj przecinek
   input >> p.y;
   input.ignore();    // Ignowruj nawias
   return input;      // Umożliwia cin >> a >> b >> c;
}

ostream& operator<<(ostream& ekran, Punkt& p){
   ekran << "(" << p.x << ",";
   ekran << p.y << ")";
   return ekran;
}


Punkt::Punkt():x(0),y(0){
  return;
}
 
Punkt::Punkt(double _x, double _y){
  x = _x;
  y = _y;
}

Punkt::Punkt(const Punkt &punkt){
this->x = punkt.x;
this->y = punkt.y;
cout << "Konstruktor kopiujący!" << endl;
}
 
Punkt::~Punkt(){
  return;
}
 
double Punkt::distance(Punkt inny){
  return sqrt(pow(x-inny.x,2)+pow(y-inny.y,2));
}
 
void Punkt::wyswietl(){
  cout << "(" << x << ";" << y << ")";
}


