/**
  * \file puzzle2.cpp
  * \author Piotr Konsek
  * \date 26.10.2013
  * \version 1.01
  * \brief Puzzle 2
*/

#include "Group.hpp"
#include <fstream>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <vector>

// \brief a function which merges plots in the order of value
//
// \param &groups a reference to empty vector
void connector(vector<Group> &groups);

// \brief a function which merges conglomerate plots into a profitable groups
//
// \param groups of less profitable groups
// \param &cluster a reference to empty vector which will have a more profitable groups
// \return change return 1 if function found more profitable groups otherwise 0
bool analysis(vector<Group> groups, vector<Group> &cluster);

// \brief a function which choose the most valuable group of plots
//
// \param finals a vector which contains a groups of most profitable plots
void final(vector<Group> main_cluster);

int main(void){
  vector<Group> groups;                //< groups vector of conglomerate plots ( in the order of value )
  vector<Group> cluster;               //< cluster vector of plots which brings profits
  vector<vector<Group> > main_cluster; //< main_cluster vector of vector which contains more and more beneficial plots
  bool change = true;                  //< change a bool value which informs there was a better bundle of plots than previous


  main_cluster.push_back(cluster);

  connector(groups);							 // merge signle plots in groups which have same signs

  change = analysis(groups, main_cluster.at(0)); // merge groups of plots with the same sign into a profitable groups
  while(change){								 // this loop guarantees the best plots distribution
	  main_cluster.push_back(cluster);
	  change = analysis(main_cluster.at(main_cluster.size()-2), main_cluster.at(main_cluster.size()-1));
  }
  main_cluster.pop_back();				   		 // pop_back last group of plots where nothing has changed

  final(main_cluster.at(main_cluster.size()-1)); // choosing the most profitable plots.

  return 0;
}

void connector(vector<Group> &groups){
  
  char word[64];
  long int size=0;
  int number=0;
  int last;
  long int i=0;
  long int start=0;
  long int value=0;

  ifstream myfile("test_1.in", ios_base::out);
  if(!myfile){
    cout << "Can't open file test_1.in" << endl;
    abort();
  }
  
  myfile >> word;
  size = atoi(word);

  while(myfile >> word){
    number = atoi(word);
        
    if ( i == 0 ){
    	last = number;
    }else if( i == 1 ){ // + + --
    	if (last * number >0 || (last <= 0 && number <= 0)){
    		start = 0;
    		value = last + number;
    	}
    	else { // +- -+
    		Group temp(0,0,last);
    		groups.push_back(temp);
    		start=i;
    		value = number;
    	}
    }
    else if(i == size -1){
    	if (last*number > 0 || (last <= 0 && number <= 0)){ // ++ -- -0 0-
    		value += number;
    		Group temp(start, i, value);
    		groups.push_back(temp);
    	}
    	else{
    		Group temp1(start,i-1,value);
    		groups.push_back(temp1);
    		Group temp2(i,i,number);
    		groups.push_back(temp2);
    	}
    }else{
    	if (last*number > 0 || (last <= 0 && number <= 0)){// ++ -- -0 0-
    		value += number;
    	}
    	else{ // +- -+ 0+ +0
    		Group temp(start, i-1, value);
    		groups.push_back(temp);
    		start = i;
    		value = number;
    	}
    }
    last = number;
    i++;
  }
  myfile.close();
}

bool analysis(vector<Group> groups, vector<Group> &cluster){
  long int start = 0;
  long int value = 0;
  bool change = false;

  for(unsigned int i=0; i<groups.size()-1; i++){
	  if(groups.at(i).getValue() > 0){
		  if(i==0){   //case: + -
			  if ( groups.at(i).getValue() + groups.at(i+1).getValue() > 0 && groups.at(i+1).getValue() + groups.at(i+2).getValue() > 0){
				  start = 0;
				  value = groups.at(i).getValue() + groups.at(i+1).getValue();
				  change = true;
			  }
			  else{
				  Group temp1(groups.at(0).getStart(), groups.at(0).getMeta(), groups.at(i).getValue());
				  cluster.push_back(temp1);
				  Group temp2(groups.at(1).getStart(), groups.at(1).getMeta(), groups.at(i+1).getValue());
				  cluster.push_back(temp2);
				  start = i+2;
				  value = groups.at(i+2).getValue();
			  }
		  }
		  else if(i == groups.size()-3){										 // + - +
			  if(groups.at(i+1).getValue() + groups.at(i+2).getValue() > 0 && groups.at(i).getValue() + groups.at(i+1).getValue() > 0){
				  value += groups.at(i+1).getValue() + groups.at(i+2).getValue();
				  Group temp(groups.at(start).getStart(), groups.at(i+2).getMeta(), value);
				  cluster.push_back(temp);
				  change = true;
			  }
			  else{
				  Group temp(groups.at(start).getStart(), groups.at(i).getMeta(), value);
				  cluster.push_back(temp);
				  Group temp2(groups.at(i+1).getStart(), groups.at(i+1).getMeta(), groups.at(i+1).getValue());
				  cluster.push_back(temp2);
				  Group temp3(groups.at(i+2).getStart(), groups.at(i+2).getMeta(), groups.at(i+2).getValue());
				  cluster.push_back(temp3);
				  value = 0;
			  }
		  }
		  else if( i == groups.size()-2){ // + -
			  Group temp(groups.at(start).getStart(), groups.at(i).getMeta(), value); // odcinam niekorzystn¹ resztê.
			  cluster.push_back(temp);

		  }
		  else{ //+ - +
			  if (groups.at(i+1).getValue() + groups.at(i+2).getValue() > 0 && groups.at(i).getValue() + groups.at(i+1).getValue() > 0){
				  value += groups.at(i+1).getValue() + groups.at(i+2).getValue();
				  change = true;
			  }
			  else{
				  Group temp(groups.at(start).getStart(), groups.at(i).getMeta(), value);
				  cluster.push_back(temp);
				  Group temp2(groups.at(i+1).getStart(), groups.at(i+1).getMeta(), groups.at(i+1).getValue());
				  cluster.push_back(temp2);
				  start = i+2;
				  value = groups.at(i+2).getValue();;
			  }
		  }
	  }
	  else{
		  if ( i == 0){
			  start = i+1;
		  	  value = groups.at(i+1).getValue();
		  }
	  }
  }

return change;
  }

void final(vector<Group> main_cluster){

	vector<Group> finals;
	ofstream myfile("test_2out.txt", ios_base::in | ios_base::trunc);
	if(!myfile){
		cout << "File test_2out.txt can't be created" << endl;
		abort();
	}

	  int max_value = main_cluster.at(0).getValue();
	  int length = main_cluster.at(0).getLength();
	  for (unsigned int i= 0; i<main_cluster.size(); i++){
		  if ( main_cluster.at(i).getValue() > max_value){
			  finals.clear();
			  finals.push_back(main_cluster.at(i));
			  max_value = main_cluster.at(i).getValue();
			  length = main_cluster.at(i).getLength();
		  } else if(main_cluster.at(i).getValue() == max_value){
			  if( main_cluster.at(i).getLength() > length ){

				  finals.clear();
				  finals.push_back(main_cluster.at(i));
				  length = main_cluster.at(i).getLength();
			  }else if (main_cluster.at(i).getLength() == length){
				  finals.push_back(main_cluster.at(i));
			  }
		  }
	  }

	  if(finals.size() == 1){
		  myfile << finals.at(0).getStart() + 1 << " " << finals.at(0).getMeta() + 1 << " " << finals.at(0).getValue() << endl;
	  }
	  else{
		  for (unsigned int i=0; i<finals.size(); i++){
			  myfile << finals.at(i).getStart() + 1 << " " << finals.at(i).getMeta() + 1 << " " << finals.at(i).getValue();
			  if(i < finals.size()-1 )
				  myfile << ", ";
		  }
	  }


}
