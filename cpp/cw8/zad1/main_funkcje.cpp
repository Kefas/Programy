#include <iostream>
#include "funkcje.h"

using namespace std;

int main(int argc,char *argv[]){
  Umowa* umowa = new UmowaPraca(10000), *umowa2 = new UmowaDzielo(10000);
  Pracownik pierwszy("Piotr","Konsek","93013007458", umowa),drugi("Krystyna","Nowak","91021308580",umowa2);
  cout << pierwszy; 
  cout <<drugi;
  // zostanie wywołany destruktor klasy UmowaPraca
  delete umowa;
  delete umowa2;
  return 0;
}
