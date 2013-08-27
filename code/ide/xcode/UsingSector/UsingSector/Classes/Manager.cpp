/*
 * Manager.cpp
 *
 *      Author: plter
 */

#include "Manager.h"

namespace plter {
    
    Manager::Manager(string name):Object() {
        _name = name;
        
        _sector=NULL;
        internal_setSector(NULL);
    }
    
    Manager::~Manager() {
        tryToRemoveCurrentSector();
    }
    
    string Manager::getName(){
        return _name;
    }
    
    bool Manager::sendRequest(plter::Request *req){
        if (_sector!=NULL) {
            return _sector->sendRequest(req);
        }else{
            return false;
        }
    }
    
    bool Manager::sendCommand(plter::Command *cmd){
        if (getSector()!=NULL) {
            return getSector()->sendCommand(cmd);
        }else{
            return false;
        }
    }
    
    bool Manager::sendResult(plter::Result *result){
        if (getSector()!=NULL) {
            return getSector()->sendResult(result);
        }
        
        return false;
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
