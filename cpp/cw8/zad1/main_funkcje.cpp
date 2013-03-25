#include <iostream>
#include "funkcje.h"

using namespace std;

int main(){
  Umowa* umowa = new UmowaPraca(10000);
 
  // zostanie wywołany destruktor klasy UmowaPraca
  delete umowa;
}
