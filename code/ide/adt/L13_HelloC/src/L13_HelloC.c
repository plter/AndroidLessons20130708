/*
 ============================================================================
 Name        : L13_HelloC.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>


typedef struct{
	int age;
	char* name;
}People;



int main(void) {

	People * p;
	p->age=18;
	p->name="Pengyi";

	People * p1 = p;
	p1->name = "ZhangDao";


	puts(p->name); /* prints !!!Hello World!!! */
	return EXIT_SUCCESS;
}
