#include <iostream>
#include <fstream>

using namespace std;

void odszyfruj();
void zaszyfruj();

int main(int argv, char *argc[])
{
  ifstream wejscie(argc[1]);
  ofstream wyjscie(argc[2],ios_base::in);
  if(!wejscie)
    cout << "Nie można otworzyć pliku!" << endl;
  if(!wyjscie)
    cout << "Nie można otworzyć pliku!" << endl;
  
  if (*(argc[3])==1)
    odszyfruj();

  if (*(argc[3])==0)
    zaszyfruj();  


  wejscie.close();
  wyjscie.close();
  return 0;
}

void odszyfruj()
{


}

void zaszyfruj()
{
}
