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
    Punkt(double _x, double _y);
    //Destruktor
    ~Punkt();
 
    double distance(Punkt inny);
    double distance(Punkt pierwszy, Punkt drugi);
    void wyswietl();
 
    // Krótkie funkcje mogą być zdefiniowane w pliku
    // nagłówkowym i będą traktowane jako funkcje inline
    double getX(){return x;}
    double getY(){return y;}
    void setX(double _x){x=_x;}
    void setY(double _y){y=_y;}
};
 
#endif
