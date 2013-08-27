//
//  GameScene.h
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#ifndef __UsingSector__GameScene__
#define __UsingSector__GameScene__

#include <iostream>

#include "cocos2d.h"
#include "Manager.h"
#include "Request.h"
#include "Config.h"

using namespace plter;

USING_NS_CC;

class GameSceneLayer :public CCLayer{
    
public:
    virtual bool init();
    
    static CCScene* scene();
    CREATE_FUNC(GameSceneLayer);
    
    virtual void ccTouchesBegan(CCSet *pTouches, CCEvent *pEvent);
    virtual void setManager(Manager* mgr);
    virtual Manager* getManager();
    
private:
    CCLabelTTF* labelBack;
    Manager* _manager;
};

#endif /* defined(__UsingSector__GameScene__) */
