#ifndef KWADRAT_H
#define KWADRAT_H
#include "punkt.h"


class Kwadrat{
  private:
    Punkt w1, w2, w3, w4;
  public:

    Kwadrat();  
    void ustal();   

    double obwod();
    double pole();

};

#endif
