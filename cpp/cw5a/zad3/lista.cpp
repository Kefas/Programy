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

Lista::Lista(const Lista &org)
{
  Wezel *currentOrg=org.head,*previousOrg,*previousK;
  this->head=NULL;
  this->ilosc=org.ilosc;
  
  for(int i=0;i<org.ilosc;i++)
    {
      Wezel *currentK = new Wezel (currentOrg->temp);
      if(this->head==NULL)
	{
	  currentK->next=NULL;
	}
      else
	currentK->next=previousK;
      
      previousOrg=currentOrg;
      previousK=currentK;
      head=currentK;
    }
  

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

Wezel::Wezel(string str)
{ 
  temp=str;
  next=NULL;
}

Wezel::~Wezel()
{
  
}




void Lista::add(string str)
{
  Wezel *current = new Wezel (str);
  
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

void Lista::print(void)
{
  int i=0;
  Wezel *current;
  current=head;
  while(current!=NULL)
    {
      cout <<i<<". element: " << current->temp  << "suma el:" << this->ilosc << endl;
      i++;
      current=current->next;
    }
}
