#include <iostream>
#include "zad1.h"
using namespace std;

int main(int argc, char *argv[])
{
  Rodzic pierwszy("JAN", "KOWALSKI", 60);
  
  pierwszy.dodajDziecko("Abelard",30,"Mechan");
  pierwszy.print();
  pierwszy.przenies("hana");
  pierwszy.print();
  return 0;
}
