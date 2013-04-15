#include <iostream>
#include "kwadrat.h"
#include "punkt.h"

using namespace std;

int main(int argc, char *argv[])
{
  Kwadrat kwadrat(10,10,0,10,10,0,0,0);

  cout << "Pole Kwadratu to: " << kwadrat.p() << " a jego obwod to " << kwadrat.obw() << endl;

  return 0;
}
