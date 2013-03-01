#include <iostream>

using namespace std;

void referencja(int &x); 
void wskaznik(int *x);
void zmienna(int x);

int main(int argv, char *argc[])
{
  int a=5,b=5,c=5;
  cout << "ref=" << a <<"wsk="<<b <<"zmienna="<<c<< endl;
  referencja(a);  
  wskaznik(&b);
  zmienna(c);

  cout << "ref=" << a <<"wsk="<<b <<"zmienna="<<c<< endl;
    
  return 0;
}

void referencja(int &x)
{
  int i=x,flaga=0;
  cout << "w referencji1=" << x <<endl;
  x--;
  while (x>2)
    {
      if (i % x == 0) flaga=1;
      x--;
    }
  if (flaga==1) cout << "Liczba zlozona" << endl;
  else cout << "liczba pierwsza" << endl;
cout << "w referencji2=" << x <<endl;
}

void wskaznik(int *x)
{
  int i=*x,flaga=0;
  cout << "we wskaznikowej=" << *x<< endl;
  (*x)--;
  while (*x>2)
    {
      if (i % *x == 0) flaga=1;
      (*x)--;
    }
  if (flaga==1) cout << "Liczba zlozona" << endl;
  else cout << "liczba pierwsza" << endl;
}
void zmienna(int x)
{
  int i=x,flaga=0;
  cout << "w ZMIENNEJ=" << x <<endl;;
  x--;
  while (x>2)
    {
      if (i % x == 0) flaga=1;
      x--;
    }
  if (flaga==1) cout << "Liczba zlozona" << endl;
  else cout << "liczba pierwsza" << endl;
  cout << "w ZMIENNEJ2=" << x <<endl;
}
