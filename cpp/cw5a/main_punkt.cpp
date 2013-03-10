#include <iostream>
#include "punkt.cpp"

using namespace std;


int main(void){
  Punkt p,p2(10,20),p3(p2); 
  p.setX(5).setY(10).wyswietl();
  p3.wyswietl();
  p2.wyswietl();
  return 0;  

    
}


