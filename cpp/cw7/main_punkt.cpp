#include <iomanip>
#include <iostream>
#include "punkt.h"
using namespace std;


int main(void){

  Punkt3D p1(1,2,3),p2(),p3(2,4,6);
  Punkt p(3,5);
  cout <<endl<< p1 <<endl;
  cout << endl << p.distance(p1) <<endl;
  cout <<endl<< p1.distance(p3) << endl;
  return 0;  
}


