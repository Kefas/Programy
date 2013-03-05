#ifndef ZESPOLONA_H
#define ZESPOLONA_H

class Zespolona{
  
  double re;
  double im;
 
 public:
 
  Zespolona(double x, double y){re=x; im=y;};
  Zespolona(){re=0; im=0;};
  ~Zespolona(){/*dekonstruktor*/};
  double getRe(){return re;};
  double getIm(){return im;};
  void setRe(double x){re=x;};//ważne! typ void!
  void setIm(double y){im=y;};

  Zespolona add(Zespolona A, Zespolona B);
  Zespolona sub(Zespolona A, Zespolona B);
  Zespolona div(Zespolona A, Zespolona B);
  Zespolona mul(Zespolona A, Zespolona B);


};

#endif


