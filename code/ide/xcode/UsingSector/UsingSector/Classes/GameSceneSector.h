//
//  GameSceneSector.h
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#ifndef __UsingSector__GameSceneSector__
#define __UsingSector__GameSceneSector__

#include <iostream>

#include "Sector.h"
#include "Config.h"
#include "Function.h"
#include "Manager.h"
#include "Event.h"
#include "Object.h"
#include <cocos2d.h>
#include "GameScene.h"

using namespace plter;
USING_NS_CC;

class GameSceneSctor :public Sector{
    
public:
    GameSceneSctor(Manager* mgr);
};

#endif /* defined(__UsingSector__GameSceneSector__) */
