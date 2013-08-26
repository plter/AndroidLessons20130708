/*
 * EventListenerList.cpp
 *
 *      Author: plter
 */

#include "EventListenerList.h"

namespace plter {

EventListenerList::EventListenerList():Object() {
}


EventListener* EventListenerList::addListener(EventListener* el){
	_els.push_back(el);
	el->retain();
	return el;
}

EventListener* EventListenerList::removeListener(string name) {

	EventListener* tmp;
	for(vector<EventListener*>::iterator it = _els.begin();it!=_els.end();++it){
		tmp = *it;
		if (tmp->getName().compare(name)==0) {
			_els.erase(it);
			tmp->release();
			return *it;
		}
	}
	tmp=NULL;
	return NULL;
}

EventListener* EventListenerList::removeListener(EventListener* el){
	for(vector<EventListener*>::iterator it = _els.begin();it!=_els.end();++it){
		if (el==*it) {
			_els.erase(it);
			el->release();
			return el;
		}
	}
	return NULL;
}

bool EventListenerList::dispatch(Event* e,Object* target){
	bool suc = true;
	EventListener* tmp;
	for(vector<EventListener*>::iterator it = _els.begin();it!=_els.end();++it){
		tmp = *it;
		if (tmp->getName().compare("")==0||
				tmp->getName().compare(e->getType())==0){

			if (!tmp->execute(e,target)) {
				suc = false;
			}
		}
	}
	tmp=NULL;
	return suc;
}

bool EventListenerList::dispatch(Event* e){
	return dispatch(e,NULL);
}


EventListenerList::~EventListenerList() {
	EventListener* tmp;
	for(vector<EventListener*>::iterator it = _els.begin();it!=_els.end();++it){
		tmp = *it;
		tmp->release();
	}
	tmp=NULL;


	_els.clear();
}

} /* namespace plter */
