#include <iostream>

using namespace std;

#ifndef LISTA_H
#define LISTA_H

class Wezel;

class Lista {
  Wezel *head;
  int ilosc;
  friend class Wezel;  
 public:
  Lista();
  Lista(const Lista &org);
  ~Lista();

  void add(string str);
  void del(void);
  void print(void);

};

class Wezel{
  string temp;
  Wezel *next;
  friend class Lista;
 public:
  Wezel(string str="nic");
  //Wezel( Wezel &kopia);
  ~Wezel();
  
};

#endif
