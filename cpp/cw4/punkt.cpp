//Definicja znajduje się w pliku punkt.cpp
#include "punkt.h"
#include <math.h>
#include <iostream>
 
using namespace std;
 
/* Aby wskazać, ze definicja funkcji dotyczy metody danej klasy
  stosujemy tzw. operator zasięgu - "::" 
*/
 
//Specjalna inicjalizacja zmiennych. Zmienne są inicjowane
//nim zostanie wywołane ciało konstruktora
Punkt::Punkt():x(0),y(0){
  cout << "Konstruktor bezparametrowy" << endl;
}
 
Punkt::Punkt(double _x, double _y){
  cout << "Konstruktor parametrowy" << endl;
  x = _x;
  y = _y;
}
 
Punkt::~Punkt(){
  cout << "Destruktor! Nic nie robie, bo nie musze zwalniać pamięci!";
  cout << endl;
}
 
double Punkt::distance(Punkt inny){
  return sqrt(pow(x-inny.x,2)+pow(y-inny.y,2));
}


 
void Punkt::wyswietl(){
  cout << "(" << x << ";" << y << ")";
}

double Punkt::distance(Punkt pierwszy, Punkt drugi){
  return sqrt(pow(pierwszy.x-drugi.x,2)+pow(pierwszy.y-drugi.y,2));
};

