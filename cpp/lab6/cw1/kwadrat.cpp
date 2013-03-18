#include "punkt.h"
#include "kwadrat.h"
#include <iostream>
#include <math.h>

using namespace std;

Kwadrat::Kwadrat()
{
  w1.setX(0); w1.setY(0);
  w2.setX(0); w2.setY(8);
  w3.setX(8); w3.setY(0);
  w4.setX(8); w4.setY(8);
}

void Kwadrat::ustal()
{
  double x1,x2,x3,x4,y1,y2,y3,y4;
  int i=0;
  
  do
  {
    if (i) cout << "\nNiestety, podane wierzcholki nie tworza kwadratu. Sprobuj jeszcze raz..." << endl;
    cout << "Podaj wspolrzedne pierwszego wierzcholka kwadratu (x,y): ";
    cin >> x1 >> y1;
    cout << "\nPodaj wspolrzedne drugiego wierzcholka kwadratu (x,y): ";
    cin >> x2 >> y2;
    cout << "\nPodaj wspolrzedne trzeciego wierzcholka kwadratu (x,y): ";
    cin >> x3 >> y3;
    cout << "\nPodaj wspolrzedne czwartego wierzcholka kwadratu (x,y): ";
    cin >> x4 >> y4;
    i++;
  }while( (sqrt(pow(x1-x2,2)+(y1-y2,2)) == sqrt(pow(x2-x3,2)+(y2-y3,2))) && (sqrt(pow(x1-x4,2)+(y1-y4,2)) == sqrt(pow(x4-x3,2)+(y4-y3,2))));

  w1.setX(x1); w1.setY(y1);
  w2.setX(x2); w2.setY(y1);
  w3.setX(x3); w3.setY(y1);
  w4.setX(x4); w4.setY(y1);

}

double Kwadrat::obwod()
{
  return 4*sqrt(pow(w1.getX()-w2.getX(),2)+pow(w1.getY()-w2.getY(),2));
}

double Kwadrat::pole()
{
  return pow(sqrt(pow(w1.getX()-w2.getX(),2)+pow(w1.getY()-w2.getY(),2)),2);
}
