/*
 * Man.cpp
 *
 *  Created on: 2013-8-12
 *      Author: plter
 */

#include "Man.h"

#include <stdio.h>

using namespace cn::eoe;


Man::Man() {
	// TODO Auto-generated constructor stub
}

void Man::sayHello(){
	People::sayHello();

	printf("Man SayHello\n");
}


Man::~Man() {
	// TODO Auto-generated destructor stub
}

