#include <iostream> // zamiast <iostream.h>
using namespace std;
// wychodzi 81 z tego powodu, że zmieniają wartość wskaźnika z 3 na 9 zmieniamy równocześnie wartość liczby z 3 na 9. 

int * potega(int liczba, int potega){
  int  *wynik = &liczba;
  for(int i = 1; i < potega; i++)
    *wynik *= liczba;
   return wynik;
}
int main(void){
  cout << *(potega(3,3)) << endl;
}
