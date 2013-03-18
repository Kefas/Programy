// Deklaracja znajduje siew pliku punkt.h
#ifndef PUNKT_H
#define PUNKT_H
#include <iomanip>
#include <iostream>

using namespace std;
 
class Punkt{
  private:
    double x, y;
  public:

		friend istream& operator>>(istream&, Punkt&); 
	  friend ostream& operator<<(ostream&, Punkt&); 
    //Konstruktor bezparametrowy
    Punkt();
    //Konstruktor parametrowy
    Punkt(double _x, double _y);
    //Kontruktor kopiujacy
    Punkt(const Punkt&);
    //Destruktor
    ~Punkt();
 
    double distance(Punkt inny);
    void wyswietl();

    friend double odleglosc(Punkt , Punkt);
 
    // Krótkie funkcje mogą być zdefiniowane w pliku
    // nagłówkowym i będą traktowane jako funkcje inline
    double getX(){return x;}
    double getY(){return y;}
    void setX(double _x){x=_x;}
    void setY(double _y){y=_y;}
};
 
#endif


