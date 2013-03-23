#include <iostream>
#include "dtab.h"

using namespace std;

int main(int argc, char *argv[])
{
  DTab tablica1,tablica2(20);

  
  tablica1.add(12);
  tablica2.add(34.5);
  tablica1.print();
  tablica2.print();
  tablica1.set(0.1,10);
  tablica2.set(0.2,20);
  cout << "Pobralem 10 wyraz tablica1: "<< tablica1.get(10)<< endl;
  cout << "pobralem 20 wyraz tablica2: " << tablica2.get(20)<<endl;

  return 0;
}
