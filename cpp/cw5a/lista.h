#include <iostream>

using namespace std;

#ifndef LISTA_H
#define LISTA_H

class Wezel;

class Lista {
  Wezel *head;
  int ilosc;  
 public:
  Lista();
  ~Lista();

  void add(int y);
  void del(void);

};

class Wezel{
  int x;
 public:
  Wezel *next;
  Wezel(int y=0);
  Wezel(Wezel &kopia);
  ~Wezel();
  
};

#endif
