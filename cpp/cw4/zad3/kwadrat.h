
#ifndef KWADRAT_H
#define KWADRAT_H

#include "punkt.h"
x
class Kwadrat {
 private:
  Punkt A,B,C,D; 
 public:
  Kwadrat(double x1,double y1, double x2,double  y2,double  x3, double y3,double  x4,double  y4);
  ~Kwadrat();

  double obwod(Punkt A,Punkt B, Punkt C, Punkt D);
  double obw(){ return obwod(A,B,C,D);}
  double pole(Punkt A,Punkt B, Punkt C, Punkt D);
  double p(){return pole(A,B,C,D);}

};
#endif
