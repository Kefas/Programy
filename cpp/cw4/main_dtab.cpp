#include <iostream>
#include "dtab.h"

using namespace std;

int main(int argc, char *argv[])
{
  DTab tablica1,tablica2(5);

  tablica1.add(12);
  tablica1.set(100,0);
  tablica1.print();
  //cout <<endl<< tablica1.get(10)<< "!!!!!!!"<<endl;

  return 0;
}
