/*
 * Sector.cpp
 *
 *      Author: plter
 */

#include "Sector.h"

namespace plter {

Sector::Sector(string name,Manager* manager):Object() {
	_name = name;
	_resultAdapter = new EventListenerList();
	_commandAdapter = new EventListenerList();
    
    _manager = NULL;
	setManager(manager);
}

void Sector::tryToRemoveCurrentManager(){
	if (_manager!=NULL) {
		_manager->internal_setSector(NULL);
		_manager->release();
		_manager=NULL;
	}
}

Manager* Sector::getManager(){
	return _manager;
}

void Sector::setManager(Manager* manager){
	tryToRemoveCurrentManager();

	_manager = manager;

	if (_manager!=NULL) {
		_manager->retain();
		_manager->internal_setSector(this);
	}
}

string Sector::getName(){
	return _name;
}

void Sector::addChild(Sector* s){
	_children.push_back(s);
	s->setParent(this);
	s->retain();
}

Sector* Sector::getChild(string name){
	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		if (((Sector*)(*it))->getName().compare(name)==0) {
			return *it;
		}
	}
	return NULL;
}

void Sector::removeChild(Sector* s){

	Sector* tmp;

	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		tmp = *it;
		if (tmp == s) {
			_children.erase(it);
			tmp->setParent(NULL);
			tmp->release();
			break;
		}
	}

	tmp = NULL;
}

void Sector::removeChild(string sectorName){
	Sector* tmp;

	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		tmp = *it;

		if (tmp->getName().compare(sectorName)==0) {
			_children.erase(it);
			tmp->setParent(NULL);
			tmp->release();
			break;
		}
	}

	tmp=NULL;
}

void Sector::addFunction(Function* f){
	_commandAdapter->addListener((EventListener*)f);
}

Sector::~Sector() {
	tryToRemoveCurrentManager();

	if (_parent!=NULL) {
		_parent->release();
		_parent=NULL;
	}

	Sector* tmp;
	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		tmp = *it;
		tmp->release();
	}
	_children.clear();
	tmp=NULL;

	_resultAdapter->release();
	_commandAdapter->release();
}

Function* Sector::removeFunction(Function* f) {
	return (Function*)_commandAdapter->removeListener((EventListener*)f);
}

Function* Sector::removeFunction(string name) {
	return (Function*)_commandAdapter->removeListener(name);
}


void Sector::setParent(Sector* p) {
	if (_parent!=NULL) {
		_parent->release();
		_parent=NULL;
	}

	_parent = p;
	if (_parent!=NULL) {
		_parent->retain();
	}
}


bool Sector::sendRequest(Request* req) {
	if (_manager!=NULL) {
		if (_manager->handleRequest(req)) {
			return _sendRequest(req);
		}
	}
	return _sendRequest(req);
}

bool Sector::sendCommand(Command* cmd) {
	bool suc = true;

	if (!_commandAdapter->dispatch((Event*)cmd)) {
		suc = false;
	}

	Sector* tmp;
	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		tmp = *it;
		if (!tmp->sendCommand(cmd)) {
			suc = false;
		}
	}
	tmp=NULL;

	return suc;
}

bool Sector::sendResult(Result* result) {
	bool suc = true;

	if (!_resultAdapter->dispatch((Event*)result)) {
		suc = false;
	}

	if (_parent!=NULL) {
		if (!_parent->sendResult(result)) {
			suc = false;
		}
	}

	return suc;
}


bool Sector::_sendRequest(Request* req) {
	bool suc = true;

	if (_parent!=NULL) {
		_parent->sendRequest(req);

		Command* cmd = new Command(req->getType(),req->getData());
		_commandAdapter->dispatch(cmd);
		cmd->release();
	}

	return suc;
}


Sector* Sector::getParent() {
	return _parent;
}


void Sector::addCallback(Callback* cb) {
	_resultAdapter->addListener((EventListener*)cb);
}

Callback* Sector::removeCallback(Callback* cb) {
	return (Callback*)_resultAdapter->removeListener((EventListener*)cb);
}

Callback* Sector::removeCallback(string name) {
	return (Callback*)_resultAdapter->removeListener(name);
}

} /* namespace plter */
