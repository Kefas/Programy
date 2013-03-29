#include <iostream>
#include "ksztalt.h"

using namespace std;

int main(int argc, char *argv[])
{
  Ksztalt *figura = new Kolo(5,5,10), *figura2=new Trojkat(5);
  figura->rysuj();
  figura2->rysuj();
  delete figura;
  delete figura2;

  return 0;
}
