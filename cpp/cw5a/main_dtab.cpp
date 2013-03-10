#include <iostream>
#include "dtab.h"

using namespace std;

int main(int argc, char *argv[])
{
  DTab tablica1,tablica2(20),tablica3;

  
  tablica1.add(12);
  tablica2.add(34.5);
  tablica1.print();
  tablica2.print();
  tablica1.set(0.1,10);
  tablica2.set(0.2,20);
  cout << "Pobralem 10 wyraz tablica1: "<< tablica1.get(10)<< endl;
  cout << "pobralem 20 wyraz tablica2: " << tablica2.get(20)<<endl;
  tablica1.wypelniona(3);
  tablica1.print();
  //tablica3=tablica1;
  //tablica3.print();
  //tablica1.wypelniona(1);
  //tablica3.wypelniona(5);
  //tablica1.print();
  //tablica3.print();
 
  //jeżeli przypisać w sposób 'tradycyjny' tablicy3 tablicę1 to okazuje się, że tablica 3 będzie używała tego samego adresu tablicy co tablica1, przez to pracuje sie na jednej i tej samej tablicy ktorej uzywaja dwie klasy, rowniez pojawia sie blad przy zwalnianiu pamieci w destruktorze.

  DTab tablica4(tablica1);
  tablica4.print();
  tablica1.wypelniona(0);
  tablica4.wypelniona(9);
  tablica1.print();
  tablica4.print();

  return 0;
}


