#include <iostream>
#include "kula.h"
using namespace std;

int main(int argc, char *argv[])
{
  Kula k(0,0,0,10);
  cout<< k.pole()<< " " << k.Kolo::pole() << endl;
  return 0;
}
