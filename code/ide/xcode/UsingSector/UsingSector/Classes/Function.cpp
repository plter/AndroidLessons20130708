/*
 * Function.cpp
 *
 *      Author: plter
 */

#include "Function.h"

namespace plter {
    
    Function::Function(string name,Sector* sector):EventListener(name) {
        _sector = sector;
        _sector->retain();
    }
    
    Function::~Function() {
        _sector->release();
    }
    
    Sector* Function::getSector(){
        return _sector;
    }
    
} /* namespace plter */
