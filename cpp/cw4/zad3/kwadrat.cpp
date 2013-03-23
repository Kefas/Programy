#include <iostream>
#include "kwadrat.h"
#include "punkt.h"
#include <math.h>

using namespace std;

double Kwadrat::obwod(Punkt A, Punkt B, Punkt C, Punkt D)
{
  double x,y,z,wynik;

  x=sqrt(pow(A.getX()-B.getX(),2)+pow(A.getY()-B.getY(),2));
  wynik=x;
  y=sqrt(pow(A.getX()-C.getX(),2)+pow(A.getY()-C.getY(),2));
  if (y<x) wynik=y;
  z=sqrt(pow(A.getX()-D.getX(),2)+pow(A.getY()-D.getY(),2));
  if (z<x || z<y) wynik=z;
  

  return 4*wynik;
}

double Kwadrat::pole(Punkt A, Punkt B, Punkt C, Punkt D)
{
  double x,y,z,wynik;
 
  x=sqrt(pow(A.getX()-B.getX(),2)+pow(A.getY()-B.getY(),2));
  wynik=x;
  y=sqrt(pow(A.getX()-C.getX(),2)+pow(A.getY()-C.getY(),2));
  if (y<x) wynik=y;
  z=sqrt(pow(A.getX()-D.getX(),2)+pow(A.getY()-D.getY(),2));
  if (z<x || z<y) wynik=z;

  return pow(wynik,2);
}
Kwadrat::Kwadrat(double x1,double y1, double x2,double  y2,double  x3, double y3,double  x4,double  y4)
    {
      Punkt Aq(x1,y1), Bq(x2,y2),Cq(x3,y3),Dq(x4,y4);
      
      A=Aq;
      B=Bq;
      C=Cq;
      D=Dq;
    }

Kwadrat::~Kwadrat()
{
  cout <<"destruktor" << endl;
}
