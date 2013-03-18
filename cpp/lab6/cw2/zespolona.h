#ifndef ZESPOLONA_H
#define ZESPOLONA_H
#include <iostream>
#include <cmath>
using namespace std;
class Zespolona{
	private:
		double Re, Im;
	public:
		Zespolona();
		Zespolona(double _Re, double _Im);
		~Zespolona();
		Zespolona dodaj(Zespolona skladnik);
		Zespolona odejmij(Zespolona inna);
		Zespolona pomnoz(Zespolona);
		void wypisz();
		void zmienRzeczywista(double _Re){Re=_Re;}
		void zmienUrojona(double _Im){Im=_Im;}
		double getRe(){return Re;}
		double getIm(){return Im;}
		Zespolona operator+(const Zespolona skladnik);
		Zespolona operator-(const Zespolona skladnik);
		void operator +=(const Zespolona skladnik);
		void operator -=(const Zespolona skladnik);
		Zespolona operator*(const Zespolona skladnik);
		bool operator == (const Zespolona druga);
		bool operator != (const Zespolona druga);
		Zespolona operator/(const Zespolona skladnik);
};

#endif
