#include <iostream>
#include "punkt.h"
#include "kwadrat.h"
#include <math.h>
 
using namespace std;

double odleglosc(Punkt jeden, Punkt dwa)
{
  return sqrt(pow(jeden.x-dwa.x,2)+pow(jeden.y-dwa.y,2));
} 
 
int main(void){
  Punkt p; 
  Punkt p2(12,34);
  Punkt p3(17,21);
  Punkt p4(5,5);
  Punkt p5(p4);
  Punkt p6=p2;
  double x,y;


	cin >> p2;
	cout << p2;


/*
  cout << "\np5="; p5.wyswietl();
  cout << "  p4="; p4.wyswietl();
  cout << "\np6="; p6.wyswietl();
  cout << "  p2="; p2.wyswietl();
  Punkt p7;
  p7=p2;
  cout << "\np7="; p7.wyswietl();
  Punkt *ptrP = new Punkt(3,4);
 
  cout << "\np2="; p2.wyswietl();
  cout << endl << "Odleglosc wynosi: " << ptrP->distance(p2) << endl;

  cout << "Dystans miedzy p i p4 wynosi: " << odleglosc(p,p4) << endl;

  x=p3.getX();  cout << "x=" << x << " ";
  y=p3.getY();  cout << "y=" << y << endl;
 
  delete ptrP;


*/

  /*Kwadrat kw;
  
  cout << "\nObwod kwadratu wynosi:" << kw.obwod() << "cm" << endl;
  cout << "\nPole kwadratu wynosi:" << kw.pole() << "cm^2" << endl;

  kw.ustal();

  cout << "\nObwod kwadratu wynosi:" << kw.obwod() << "cm" << endl;
  cout << "\nPole kwadratu wynosi:" << kw.pole() << "cm^2" << endl;*/
 
}
