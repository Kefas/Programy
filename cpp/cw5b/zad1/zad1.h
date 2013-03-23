#include <iostream>
using namespace std;
#ifndef ZAD1_H
#define ZAD1_H


class Dziecko{
  string imie,nazwisko,szkola;
  int wiek;
  friend class Rodzic;
 public:
  Dziecko();
  Dziecko(string imie, string nazwisko, string szkola, int wiek);
  ~Dziecko(){};

};

class Rodzic{
  string imie,nazwisko;
  int wiek;
  Dziecko potomek;
 public:
  Rodzic();
  Rodzic(string imie, string nazwisko, int wiek);
  ~Rodzic(){};
  void dodajDziecko(string imie, int wiek,string szkola);
  void print();
  void przenies(string nowa);


};


#endif
