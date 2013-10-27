/**
 * \file puzzle1.cpp
 * \author Piotr Konsek
 * \date 06.10.13
 * \version 1.0
 * \brief Puzzle 1
 */

#include <iostream>
#include <stdio.h>
#include <string.h>

using namespace std;

/// \brief Function which allocate memory and prepare letters on keybord
///
/// \param **keyboard two dimensional array
/// \return complete keyboard array
char** make_keyboard(char **keyboard);

/// \brief Function which recursively checking the phone number and assembling complete words
///
/// \param **keyboard two dimensional array with keyboard letters
/// \param *phone one dimensional array with phone number
/// \param *tab one dimensional array with complete words
void recursion(char **keyboard, char *phone, char *tab, int level);

int main(void){ 
  char **keyboard; //< **keyboard Array with keyboard letters
  char *phone;     //< *phone Array with phone number
  char *tab;       //< *tab Array with complete word
  char buffor[64]; //< buffor[64] Input buffor
  
  // memory allocation
  keyboard = make_keyboard(keyboard);
  phone = new char[9];
  tab = new char[9];

  // input 
  cout << "Enter the phone number: ";
  cin >> buffor;
 
  // input validation
  if (strlen(buffor) == 9){
    strcpy(phone, buffor);
    for(char i=0; i<9; i++){
      if (!isdigit(phone[i]) ){
	cout << "ERROR" << endl;
	return 1;
      }
    }
  }
  else{
    cout << "ERROR" << endl;
    return 1;
  }
   
  recursion(keyboard, phone, tab, 0);
   
  return 0;
}

void recursion(char **keyboard, char *phone, char *tab, int level){
  
  if(level < 9){   
    if( phone[level] == '0' || phone[level] == '1' ){
      tab[level] = phone[level];
      recursion(keyboard, phone, tab, ++level);
    }
    else{
      level++;
      for(char i=0; i<3; i++){
	tab[level-1] =  keyboard[phone[level-1] - 48][i];
	recursion(keyboard, phone, tab, level);
      }
    }
  }
  else{
    for(char i=0; i<9 ;i++)
      cout << tab[i];
    cout << endl;
  }
  
}

char** make_keyboard(char **keyboard){
  
  int alphabet = 65;

  keyboard = new char*[10];
  for(char i=2; i<10; i++){
    keyboard[i] = new char[3];
    for(char j=0; j<3; j++){
      keyboard[i][j] = alphabet;
      alphabet++;
      if(alphabet == 81)
	alphabet++;
    }
  }
  return keyboard;
}

    
