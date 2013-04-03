#include <iostream>
#include <list>

#ifndef FUNKCJE_H
#define FUNKCJE_H
 
using namespace std;
 
class Umowa{
  protected:
    double wynagrodzenieBrutto;
  public:
    Umowa(double pensja):wynagrodzenieBrutto(pensja){};
    virtual ~Umowa(){cout << "Destruktor umowa"<< endl;};
    virtual double pobierzNetto()=0;
    double pobierzBrutto();
};
 
class UmowaDzielo: public Umowa{
  public:
    UmowaDzielo(double pensja):Umowa(pensja){};
    virtual ~UmowaDzielo(){cout << "Destruktor UmowaDzielo" << endl;};
    virtual double pobierzNetto();
};
 
class UmowaPraca: public Umowa{
  public:
    UmowaPraca(double pensja):Umowa(pensja){};
    virtual ~UmowaPraca(){cout << "Destruktor UmowaPraca" << endl;};
    virtual double pobierzNetto();
};

class Pracownik{
  private:
    string imie,nazwisko,pesel;
    Umowa* umowa;
  public:
    Pracownik(string i,string n,string p,Umowa* u)
      :imie(i),nazwisko(n),pesel(p),umowa(u){};
    Pracownik(const Pracownik&);
    ~Pracownik(){cout <<"Destruktor pracownik"<<endl;};
    double pobierzPensje();
    friend ostream& operator<<(ostream&,Pracownik&);
};

#endif
