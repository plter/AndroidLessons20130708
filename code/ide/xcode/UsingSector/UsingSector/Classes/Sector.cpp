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

	_superior=NULL;
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

void Sector::addSector(Sector* s){
	_children.push_back(s);
	s->setSuperior(this);
	s->retain();
}

Sector* Sector::getSector(string name){
	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		if (((Sector*)(*it))->getName().compare(name)==0) {
			return *it;
		}
	}
	return NULL;
}

void Sector::removeSector(Sector* s){

	Sector* tmp;

	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		tmp = *it;
		if (tmp == s) {
			_children.erase(it);
			tmp->setSuperior(NULL);
			tmp->release();
			break;
		}
	}

	tmp = NULL;
}

void Sector::removeSector(string sectorName){
	Sector* tmp;

	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		tmp = *it;

		if (tmp->getName().compare(sectorName)==0) {
			_children.erase(it);
			tmp->setSuperior(NULL);
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

	if (_superior!=NULL) {
		_superior->release();
		_superior=NULL;
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

	if (_manager!=NULL) {
		_manager->release();
	}
}

Function* Sector::removeFunction(Function* f) {
	return (Function*)_commandAdapter->removeListener((EventListener*)f);
}

Function* Sector::removeFunction(string name) {
	return (Function*)_commandAdapter->removeListener(name);
}


void Sector::setSuperior(Sector* p) {
	if (_superior!=NULL) {
		_superior->release();
		_superior=NULL;
	}

	_superior = p;
	if (_superior!=NULL) {
		_superior->retain();
	}
}


bool Sector::sendRequest(Request* req) {
	return _handleRequestExceptCommandListener(req,this);
}

bool Sector::sendCommand(Command* cmd) {
	return _sendCommandExcept(cmd,NULL);
}

bool Sector::sendResult(Result* result) {
	return _sendResultExcept(result,NULL);
}

Sector* Sector::getSuperior() {
	return _superior;
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


bool Sector::_sendCommandExcept(Command* cmd, Sector* except) {
	bool suc = true;

	if (!_commandAdapter->dispatch((Event*)cmd)) {
		suc = false;
	}

	Sector* tmp;
	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		tmp = *it;
		if (tmp!=except) {
			if (!tmp->sendCommand(cmd)) {
				suc = false;
			}
		}
	}
	tmp=NULL;

	return suc;
}

bool Sector::_sendResultExcept(Result* result, Sector* except) {
	bool suc = true;

	Sector* tmp;
	for(vector<Sector*>::iterator it = _children.begin();it!=_children.end();++it){
		tmp = *it;
		if (tmp!=except) {
			if (!tmp->sendResult(result)) {
				suc = false;
			}
		}
	}
	tmp=NULL;

	if (!_resultAdapter->dispatch((Event*)result)) {
		suc = false;
	}

	if (_superior!=NULL) {
		if (!_superior->_sendResultExcept(result,this)) {
			suc = false;
		}
	}

	return suc;
}

bool Sector::_handleRequestExceptCommandListener(Request* req,Sector* except) {
	bool suc = true;
	if (getManager()==NULL||getManager()->handleRequest(req)) {
		Command* cmd = new Command(req->getType(),req->getData());
		if(!_sendCommandExcept(cmd,except)){
			suc=false;
		}
		cmd->release();
	}
	if (getManager()==NULL||getManager()->reportToSuperior(req)) {
		if (getSuperior()!=NULL) {
			if(!getSuperior()->_handleRequestExceptCommandListener(req,this)){
				suc=false;
			}
		}
	}
	return suc;
}

} /* namespace plter */
