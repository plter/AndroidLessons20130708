//============================================================================
// Name        : L12_HelloCPP.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "People.h"
#include "Man.h"

using namespace std;
using namespace cn::eoe;


int main() {
//	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!

	People * p = new People();
	p->sayHello();

	People * m = new Man();
	m->sayHello();

//	delete p;
	return 0;
}
