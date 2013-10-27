#ifndef GROUP_HPP
#define GROUP_HPP

#include <iostream>
using namespace std;

class Group{
private:
  long int sind; //< sind start index
  long int mind; //< mind meta index
  long int value; //< value complete value
  long int length; //< length length of plots

public: 
  Group( int x, int y, int z){
  sind = x;
  mind = y;
  value = z;
  length = mind - sind;
}
  void setSind(int x){
    sind = x;
  }
  void setMind(int x){
    mind = x;
  }
  long int getValue(){
    return value;
  }
  long int getStart(){
	  return sind;
  }
  long int getMeta(){
	  return mind;
  }
  long int getLength(){
	  return length;
  }
 

  friend ostream& operator<<(ostream & display, Group& obj){
    display << obj.sind << " " << obj.mind << " " << obj.value;
    return display;
  }
};


#endif
