//============================================================================
// Name        : L13_HelloCPP.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "People.h"

using namespace std;
using namespace eoe;


int main() {
//	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!

	People * p = new People();
	p->sayHi();

	return 0;
}
