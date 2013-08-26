/*
 * EventListener.cpp
 *
 *      Author: plter
 */

#include "EventListener.h"

namespace plter {

EventListener::EventListener():Object() {
}

EventListener::EventListener(string name):Object(){
	_name = name;
}

bool EventListener::execute(Event* e,Object* target){
	return true;
}

string EventListener::getName(){
	return _name;
}


EventListener::~EventListener() {
	// TODO Auto-generated destructor stub
}

} /* namespace plter */
