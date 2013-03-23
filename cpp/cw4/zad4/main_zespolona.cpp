#include <iostream>
#include "zespolona.h"

using namespace std;

int main(int argc, char *argv[])
{
  Zespolona pierwsza(6,2),druga(4,4),wynik_add,wynik_div,wynik_mul,wynik_sub;
  wynik_add=pierwsza.add(pierwsza,druga);
  wynik_div=pierwsza.div(pierwsza,druga);
  wynik_mul=pierwsza.mul(pierwsza,druga);
  wynik_sub=pierwsza.sub(pierwsza,druga);

  //cout << "Ich suma to :" << pierwsza.add(pierwsza,druga) << endl;
  cout << "Wynik dodawania " <<  wynik_add.getRe() << " a dzielenia: " << wynik_div.getRe() << " mnozenia: " <<wynik_mul.getRe()<<" odejmowanie: " << wynik_sub.getRe() << endl;

  return 0;
}
