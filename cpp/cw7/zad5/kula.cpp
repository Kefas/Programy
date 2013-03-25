#include <iostream>
#include "kula.h"
#include <math.h>

#define PI 3.14

using namespace std;

double Kolo::pole()
{
  return (PI * pow(this->r,2));
}

double Kula::pole()
{
  return (4*PI*pow(this->r,2));
}

