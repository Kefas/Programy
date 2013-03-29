#include <iostream>
using namespace std;

#ifndef KSZTALT_H
#define KSZTALT_H

class Ksztalt{
 protected:
  float x,y;
 public:
 Ksztalt():x(0),y(0){};
  Ksztalt(float _x, float _y){x=_x; y=_y;};
  virtual void rysuj()=0;
  virtual ~Ksztalt(){cout << "Destruktor kształt" << endl;};
};

class Kolo: public Ksztalt
{
 protected:
  float r;
 public:
 Kolo(float _x,float _y,float _r):Ksztalt(_x,_y){ r=_r;};
 Kolo(float _r):Ksztalt(){r=_r;};
  virtual void rysuj();
  virtual ~Kolo(){cout << "Destruktor kolo" << endl;};
};

class Trojkat: public Ksztalt
{
 protected:
  float a;
 public:
 Trojkat(float _x, float _y, float _a):Ksztalt(_x,_y){a=_a;};
 Trojkat(float _a):Ksztalt(){a=_a;};
  virtual void rysuj();
  virtual ~Trojkat(){cout<<"Destruktor trojkat"<<endl;};
};

class Kwadrat: public Ksztalt
{
 protected:
  float a;
 public:
 Kwadrat(float _x, float _y, float _a):Ksztalt(_x,_y){a=_a;};
 Kwadrat(float _a):Ksztalt(){a=_a;};\
  virtual void rysuj();
  virtual ~Kwadrat(){cout<<"Destruktor kwadrata"<<endl;}
};

#endif
