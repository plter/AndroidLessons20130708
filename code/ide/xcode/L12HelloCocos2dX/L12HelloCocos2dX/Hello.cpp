//
//  Hello.cpp
//  L12HelloCocos2dX
//
//  Created by plter on 13-8-14.
//
//

#include "Hello.h"


bool Hello::init(){
    
    
    return true;
}

bool Hello::initWithString(){
    return true;
}

Hello * Hello::createWithString(){
    Hello * h = new Hello();
    h->autorelease();
    if (h->initWithString()) {
        return h;
    }
    return NULL;
}