#include <iostream>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

using namespace std;

Lista::Lista(string temp)
{
  Wezel current;
  current->temp=temp;
  current->next=0;
  this->head=current;
}


