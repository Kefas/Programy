#include <iostream>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

using namespace std;

int main(int argc, char *argv[])
{
  Lista lista;
  lista.add("dajmy cos");
  lista.add("dalem drugie");
  lista.add("dalem trzecie i zaraz usune");
  lista.print();
  lista.del();
  cout<<endl;
  lista.print();

  Lista lista2(lista);
  cout<<endl;
  lista2.print();
  cout << endl;
  lista.print();

  return 0;
}
