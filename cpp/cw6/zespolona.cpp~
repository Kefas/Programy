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

