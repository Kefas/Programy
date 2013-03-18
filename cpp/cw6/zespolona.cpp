#include <iostream>
#include "zespolona.h"
#include <math.h>

using namespace std;

Zespolona Zespolona::add(Zespolona A, Zespolona B)
{
  Zespolona C(A.getRe()+B.getRe(),A.getIm()+B.getIm());
  return C;
}

Zespolona Zespolona::div(Zespolona A, Zespolona B)
{
  Zespolona C(  ( (A.getRe()*B.getRe() ) + (A.getIm()*B.getIm() ) )/( pow(B.getRe(),2) + pow(A.getIm(),2)) , ( (A.getIm()*B.getRe() )-(A.getRe()*B.getIm())) / ( pow(B.getRe(),2) + pow(A.getIm(),2) ) );
  return C;
}

Zespolona Zespolona::mul(Zespolona A, Zespolona B)
{

  Zespolona C( (A.getRe()*B.getRe()) - (A.getIm()*B.getIm()), (A.getIm()*B.getRe()) + (A.getRe()*B.getIm()) );
  return C;
}

Zespolona Zespolona::sub(Zespolona A, Zespolona B)
{

  Zespolona C( A.getRe()-B.getRe(), A.getIm()-B.getIm());
  return C;
}

Zespolona Zespolona::operator+(const Zespolona A)
{
  Zespolona C;
  C.re=this->re+A.re;
  C.im=this->im-A.im;
  return C;
}

Zespolona Zespolona::operator-(const Zespolona A)
{
  Zespolona C(this->re-A.re, this->im-A.im);
  return C;
}

Zespolona operator/(const Zespolona A,const Zespolona B)
{
  Zespolona C;
  C.re=((A.re*B.re - A.im*B.im)/(pow(B.re,2) + pow(B.im,2)));
  C.im=((A.im*B.re - A.re*B.im)/(pow(B.re,2) + pow(B.im,2)));
  return C;
}

Zespolona operator*(const Zespolona A,const Zespolona B)
{
  Zespolona C;
  C.re=(A.re*B.re - A.im*B.im);
  C.im=(A.im*B.im + A.re*B.re);
  return C;
}

void Zespolona::operator+=(const Zespolona A)
{
  this->re+=A.re;
  this->im+=A.im;
}

void Zespolona::operator-=(const Zespolona A)
{
  this->re-=A.re;
  this->im-=A.im;
}

bool Zespolona::operator==(const Zespolona A)
{
  if (this->re == A.re && this->im==A.im) return true;
  else return false;
}

bool Zespolona::operator!=(const Zespolona A)
{
  if (this->re == A.re || this->im==A.im) return false;
  else return true;
}
