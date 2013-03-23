#include <iostream>
#include <iomanip>

using namespace std;

// Deklaracja znajduje siew pliku punkt.h
#ifndef PUNKT_H
#define PUNKT_H
 
class Punkt{
  protected:
    double x, y;
  public:
    //Konstruktor bezparametrowy
    Punkt();
    //Konstruktor parametrowy
    Punkt(double x, double y);
    //Konstruktor kopiujący
    Punkt(Punkt &punkt);
    //Destruktor
    ~Punkt();
 
    double distance(Punkt inny);
    double distance(Punkt pierwszy, Punkt drugi);
    void wyswietl();
 
    // Krótkie funkcje mogą być zdefiniowane w pliku
    // nagłówkowym i będą traktowane jako funkcje inline
    double getX(){return x;}
    double getY(){return y;}
    Punkt & setX(double x);
    Punkt & setY(double y);
    friend istream& operator>>(istream&, Punkt&);
    friend ostream& operator<<(ostream&, Punkt&);
};

class Punkt3D : public Punkt{
 protected:
  double z;
 public:
 Punkt3D():Punkt(),z(0){cout << "konstruktor bezparametrowy 3D";};
 Punkt3D(double x, double y,double _z):Punkt(x,y){ z=_z; cout << "konstruktor parametrowy 3d";};
  ~Punkt3D(){cout<<"destruktor 3d";};
  double distance(Punkt3D inny);
};
#endif
