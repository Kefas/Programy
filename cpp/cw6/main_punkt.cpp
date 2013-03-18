#include <iomanip>
#include <iostream>
#include "punkt.h"
using namespace std;


int main(void){
  Punkt p,p2(10,20);
  p.wyswietl();
  cin >> p;
  cout << p;
  p2.wyswietl();
  return 0;  

    
}


