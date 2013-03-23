#include <iostream>
#include "zad1.h"

using namespace std;

Dziecko::Dziecko()
{
  imie="Jan";
  nazwisko="Kowalski";
  wiek=10;
}

Dziecko::Dziecko(string imie, string nazwisko, string szkola, int wiek)
{
  this->imie=imie;
  this->nazwisko=nazwisko;
  this->szkola=szkola;
  this->wiek=wiek;
}

Rodzic::Rodzic()
{
  imie="Jan";
  nazwisko="Kowalski";
  wiek=40;
}

Rodzic::Rodzic(string imie, string nazwisko, int wiek)
{
  this->imie=imie;
  this->nazwisko=nazwisko;
  this->wiek=wiek;
}

void Rodzic::dodajDziecko(string imie, int wiek,string szkola)
{
  potomek.imie=imie;
  potomek.nazwisko=this->nazwisko;
  potomek.szkola=szkola;
  potomek.wiek=wiek;
}

void Rodzic::print()
{
  cout << imie << " " << nazwisko << " " << wiek << "-" << potomek.imie<< " " << potomek.nazwisko << " " << potomek.wiek << " " << potomek.szkola << endl;
}

void Rodzic::przenies(string nowa)
{
  potomek.szkola=nowa;
}
