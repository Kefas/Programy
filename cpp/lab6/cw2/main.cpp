#include <iostream>
#include "zespolona.h"
using namespace std;

int main() {
	Zespolona Z1(2,-5);
	Zespolona Z2(4,3);
	Zespolona Z3 = Z1+Z2;
	
	Z3.wypisz();
	Z3+=Z1;
	Z3.wypisz();
	(Z3*Z2).wypisz();
	Z3= Z1/Z2;
	Z3.wypisz();
	
	
	return 0;
}
