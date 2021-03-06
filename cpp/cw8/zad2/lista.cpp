#include <iostream>
#include <stdlib.h>
#include "lista.h"
#include "ksztalt.h"

using namespace std;

List::List()
{
  this->head=NULL;
  cout << "Constructor List" <<endl;
}

List::~List()
{
  cout << "destruktor List" << endl;
  Node *current;
  while (head!=NULL)
    {
      current=head;
      head=head->next;
      delete current;
    }
}

Node::Node()
{
  cout << "Constructor Node" << endl;
  shape=NULL;
  int x=rand()%3;
  if (x==0)
    {
      Ksztalt *figura = new Kolo(rand()%10 +1);
      this->shape=figura;
    }
  else if(x==1)
    {
      Ksztalt *figura = new Trojkat(rand()%10+1);
      this->shape=figura;
    }
  else if(x==2)
    {
      Ksztalt *figura = new Kwadrat(rand()%10+1);
      this->shape=figura;
    }
}

Node::~Node()
{
  cout << "destruktor Node" << endl;
  if(shape!=NULL)  
    delete shape;
}

void List::add()
{
  Node *current = new Node();
  if (!head)
    {
      head=current;
      current->next=NULL;
    }
  else
    {
      current->next=head;
      head=current;
    }
}

void List::print()
{
  Node *current;
  current=head;
  while(current!=NULL)
    {
      current->shape->rysuj();
      current=current->next;
    }
}
