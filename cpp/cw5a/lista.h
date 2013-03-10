#include <iostream>

using namespace std;

#ifndef LISTA_H
#define LISTA_H

class Lista {
  Wezel *head;  
  
class Wezel{
    string temp;
    Lista *next;
    Lista *head;  
  };

 public:
  Lista(string temp);
  //Lista(Lista &lista);
  ~Lista();

  //string getData(){return temp;};  
  void appendFirst(string temp);
  void appendLast(string temp);
  void insert(string temp);
  void remove(void);
  void removeFirst(void);
  void removeLast(void);
  Lista *getNext(void);
  void setNext(Lista *next);
  void setHead(wezel 

};

#endif
