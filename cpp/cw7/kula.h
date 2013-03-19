#include <iostream>

using namespace std;

#ifndef KULA_H
#define KULA_H

class Kolo{
 protected:
  double x,y,r;
 public:
  Kolo(double _x, double _y,double _r){x=_x; y=_y; r=_r;};
  ~Kolo(){cout << "destruktor kolo" << endl;};
  double pole1();
};


class Kula: public Kolo{
 protected:
  double z;
 public:
 Kula(double x,double y, double _z, double r):Kolo(x,y,r){ z=_z;};
  ~Kula(){cout<<"destruktor kula" << endl;};
  double pole2();
};

#endif
