#include <iostream>
#include <fstream>

using namespace std;

void odszyfruj(std::wejscie,std::wyjscie);
void zaszyfruj(std::wejscie,std::wyjscie);

int main(int argv, char *argc[])
{
  ifstream wejscie(argc[1]);
  ofstream wyjscie(argc[2],ios_base::in);
  if(!wejscie)
    cout << "Nie można otworzyć pliku!" << endl;
  if(!wyjscie)
    cout << "Nie można otworzyć pliku!" << endl;
  
  if (*(argc[3])==1)
    odszyfruj(wejscie, wyjscie);

  if (*(argc[3])==0)
    zaszyfruj(wejscie, wyjscie);  


  wejscie.close();
  wyjscie.close();
  return 0;
}

void odszyfruj(std::wejscie, std::wyjscie)
{
  char c;
  while(wejscie >> c)
    cout << c;


}

void zaszyfruj(std::wejscie,std::wyjscie)
{
}
