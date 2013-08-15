//
//  Hello.h
//  L12HelloCocos2dX
//
//  Created by plter on 13-8-14.
//
//

#ifndef __L12HelloCocos2dX__Hello__
#define __L12HelloCocos2dX__Hello__

#include <iostream>
#include "cocos2d.h"

USING_NS_CC;

class Hello:CCObject{
    
public:
    bool initWithString();
    bool init();
    
    static Hello * createWithString();
    
    CREATE_FUNC(Hello);
};

#endif /* defined(__L12HelloCocos2dX__Hello__) */
