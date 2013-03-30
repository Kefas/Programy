#include <iostream>
#include "punkt.h"
using namespace std;


int main(void){
  Punkt p; 
  Punkt p2(12,34),p3(3,4);
 
  Punkt *ptrP = new Punkt(3,4), odl;
 
  p2.wyswietl();
  cout <<  ptrP->distance(p2) << endl;
  //Funkcja pobierajaca dwa punkty zwracajaca odleglosc 
  cout << "Odleglosc miedzy dwoma punktami=" << odl.distance(p2,p3) <<endl; 
  delete ptrP;
 
  return 0;
}

//Pobieranie wspolrzednych punktow jest mozliwe lecz mija sie z celem.
