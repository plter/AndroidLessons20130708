/*
 * Function.cpp
 *
 *      Author: plter
 */

#include "Function.h"

namespace plter {
    
    Function::Function(string name,Sector* sector):EventListener(name) {
        _target = sector;
        _target->retain();
    }
    
    Function::~Function() {
        _target->release();
    }
    
    Sector* Function::getSector(){
        return _target;
    }
    
} /* namespace plter */
