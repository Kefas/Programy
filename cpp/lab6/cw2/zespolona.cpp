#include <iostream>
#include <math.h>
#include "zespolona.h"

using namespace std;

Zespolona::Zespolona(){}


Zespolona::Zespolona(double _Re, double _Im){
	Re = _Re;
	Im = _Im;
}

Zespolona::~Zespolona(){}

void Zespolona::wypisz(){
	cout << "Z = " << Re;
	if(Im>=0){ cout << "+" ;}
	cout << Im << "i" << endl;
}

Zespolona Zespolona::dodaj(Zespolona skladnik){
	Zespolona wynik;
	wynik.zmienRzeczywista(Re+skladnik.getRe());
	wynik.zmienUrojona(Im+skladnik.getIm());
	return wynik;	
}

Zespolona Zespolona::odejmij(Zespolona odjemnik){
	Zespolona wynik;
	wynik.zmienRzeczywista(Re-odjemnik.getRe());
	wynik.zmienUrojona(Im-odjemnik.getIm());
	return wynik;	
}
Zespolona Zespolona::pomnoz(Zespolona skladnik){
	Zespolona wynik;
	wynik.zmienRzeczywista(Re*skladnik.getRe()-Im*skladnik.getIm());
	wynik.zmienUrojona(Im*skladnik.getRe()+Re*skladnik.getIm());
	return wynik;
}

Zespolona Zespolona::operator+(const Zespolona skladnik){
			Zespolona wynik;
			wynik.Re = this->Re + skladnik.Re;
			wynik.Im = this->Im + skladnik.Im;
			return wynik;
}

Zespolona Zespolona::operator-(const Zespolona skladnik){
			Zespolona wynik;
			wynik.Re = this->Re - skladnik.Re;
			wynik.Im = this->Im - skladnik.Im;
			return wynik;
}

void Zespolona::operator+=(const Zespolona skladnik){
			this->Re += skladnik.Re;
			this->Im += skladnik.Im;
}

void Zespolona::operator-=(const Zespolona skladnik){
			this->Re -= skladnik.Re;
			this->Im -= skladnik.Im;
}

Zespolona Zespolona::operator*(const Zespolona skladnik){
			Zespolona wynik;
			wynik.Re = this->Re*skladnik.Re-this->Im*skladnik.Im;
			wynik.Im = this->Im*skladnik.Re+this->Re*skladnik.Im;
			return wynik;
}

bool Zespolona::operator==(const Zespolona druga)
{
			if(this->Re == druga.Re && this->Im == druga.Im) return 1;
			else return 0;
}

bool Zespolona::operator!=(const Zespolona druga)
{
			if(this->Re != druga.Re && this->Im != druga.Im) return 1;
			else return 0;
}


Zespolona Zespolona::operator/(const Zespolona skladnik)
{
  Zespolona wynik;
  Zespolona pomoc;
  Zespolona czesc1,czesc2;

  pomoc.Re = skladnik.Re;
  pomoc.Im = -(skladnik.Im);  

  czesc1.Re = this->Re*pomoc.Re-this->Im*pomoc.Im;
  czesc1.Im = this->Im*pomoc.Re+this->Re*pomoc.Im;

	czesc2.Re = skladnik.Re*pomoc.Re-skladnik.Im*pomoc.Im;
  czesc2.Im = skladnik.Re*pomoc.Re+skladnik.Im*pomoc.Im;
  
  wynik.Re = czesc1.Re / czesc2.Re;
  wynik.Im = czesc1.Im / czesc2.Im;

  return wynik;
}
