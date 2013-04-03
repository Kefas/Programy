#include <iostream>
#include "funkcje.h"

using namespace std;

double UmowaDzielo::pobierzNetto()
{
  cout << "Pobieram netto z UmowaDzielo" << endl;
  return (0.95 * wynagrodzenieBrutto);
}

double UmowaPraca::pobierzNetto()
{
  cout<< " Pobieram netto z UmowaPraca" <<endl;
  return (0.7 * wynagrodzenieBrutto);
}

double Umowa::pobierzBrutto()
{
  return wynagrodzenieBrutto;
}

double Pracownik::pobierzPensje()
{
  return umowa->pobierzNetto();
}

ostream& operator<<(ostream& output,Pracownik& pracownik)
{
  cout << pracownik.imie << " " << pracownik.nazwisko << " " << pracownik.pesel << " Netto: " << pracownik.umowa->pobierzNetto() <<"zł, Brutto: "<<pracownik.umowa->pobierzBrutto() << "zł" << endl;
} 
