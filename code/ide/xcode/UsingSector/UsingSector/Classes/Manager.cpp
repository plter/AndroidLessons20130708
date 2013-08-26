/*
 * Manager.cpp
 *
 *      Author: plter
 */

#include "Manager.h"

namespace plter {

Manager::Manager(string name,void* target):Object() {
	_target = target;
	_name = name;
	internal_setSector(NULL);
}

Manager::~Manager() {
	tryToRemoveCurrentSector();
}

void* Manager::getTarget(){
	return _target;
}

string Manager::getName(){
	return _name;
}

void Manager::internal_setSector(Sector* s){
	tryToRemoveCurrentSector();

	_sector = s;
	if (_sector!=NULL) {
		_sector->retain();
	}
}

Sector* Manager::getSector(){
	return _sector;
}

bool Manager::handleRequest(Request* req) {
	return true;
}

void Manager::tryToRemoveCurrentSector() {
	if (_sector!=NULL) {
		_sector->release();
		_sector=NULL;
	}
}

} /* namespace plter */
