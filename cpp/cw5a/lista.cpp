#include <iostream>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

using namespace std;
Lista::Lista()
{
  this->head=NULL;
  ilosc=0;  
}

Lista::~Lista()
{
  Wezel *current;
  while (head!=NULL)
    { 
      current=head;
      head=head->next;
      delete current;
    }

}

Wezel::Wezel(int y)
{ 
  x=y; 
  next=NULL;
}

Wezel::~Wezel()
{
  //
}

Wezel::Wezel(Wezel &kopia)
{
  x=kopia.x;
}


void Lista::add(int y)
{
  Wezel *current = new Wezel;

  if (head==NULL)
    {
      head=current;
      current->next=NULL;
    }      
  else
    {
      current->next=head;
      head=current; 
    }
  ilosc++;
}

void Lista::del(void)
{
  if (head!=NULL)
    {
      Wezel *current;
      current=head;
      head=current->next;
      delete current;
      ilosc--;
    }
}
