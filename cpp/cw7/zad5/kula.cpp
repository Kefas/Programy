#include <iostream>
#include "kula.h"
#include <math.h>

#define PI 3.14

using namespace std;

double Kolo::pole1()
{
  return (PI * pow(this->r,2));
}

double Kula::pole2()
{
  return (4*PI*pow(this->r,2));
}
