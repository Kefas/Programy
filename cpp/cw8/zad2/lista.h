#include <iostream>
#include "ksztalt.h"
 
using namespace std;

#ifndef LIST_H
#define LIST_H

class Node;

class List
{
 protected:
  Node *head;
  int amount;
  friend class Node;
 public:
  List();
  ~List();
  void add();
  void print();
};

class Node
{
 protected:
  Node *next;
  Ksztalt *shape;
  friend class List;
 public:
  Node();
  ~Node();
};

#endif
