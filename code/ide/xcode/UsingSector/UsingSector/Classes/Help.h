//
//  Help.h
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#ifndef __UsingSector__Help__
#define __UsingSector__Help__

#include <iostream>

#include <cocos2d.h>
#include "Manager.h"
#include "Request.h"
#include "Config.h"

USING_NS_CC;
using namespace plter;


class Help:public CCLayer {
    
public:
    CREATE_FUNC(Help);
    
    virtual bool init();
    virtual void ccTouchesBegan(CCSet *pTouches, CCEvent *pEvent);
    
    virtual void setManager(Manager* mgr);
    virtual Manager* getManager();
    
private:
    CCLabelTTF* labelBack;
    Manager* _manager;
};

#endif /* defined(__UsingSector__Help__) */
