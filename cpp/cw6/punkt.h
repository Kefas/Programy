#include <iostream>

using namespace std;

// Deklaracja znajduje siew pliku punkt.h
#ifndef PUNKT_H
#define PUNKT_H
 
class Punkt{
  public:
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
};
 
#endif
