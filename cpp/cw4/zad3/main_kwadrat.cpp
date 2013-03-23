#include <iostream>
#include "kwadrat.h"
#include "punkt.h"

using namespace std;

int main(int argc, char *argv[])
{
  Kwadrat edek(10,10,0,10,10,0,0,0);

  cout << "Pole Edka to: " << edek.p() << " a jego obwod to " << edek.obw() << endl;

  return 0;
}
