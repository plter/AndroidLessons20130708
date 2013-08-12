/*
 ============================================================================
 Name        : L12_HelloC.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

#define MATH_PI 3.141592653

struct A{

};

typedef struct {
	int age;
	char* name;
	struct A a;
} People;


int intArr[10];

int main(void) {

//	struct People p;
//	p.age=18;
//	p.name = "ZhangDao";
//
//	struct People p1 = p;
//	p1.age = 20;
//
//	printf("Age of p :%d",p.age);

	struct People * p = malloc(sizeof(struct People));
//	free(p);

//	p->age = 20;
//
//	struct People * p1 = p;
//	p1->age = 18;
//
//	printf("Age of p :%d",p->age);

//	People * p;

//	int a = MATH_PI;

//	printf("Hello World %d",10);

//	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */
	return EXIT_SUCCESS;
}
