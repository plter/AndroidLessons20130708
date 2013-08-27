//
//  HelloWorldSceneSector.h
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#ifndef __UsingSector__HelloWorldSceneSector__
#define __UsingSector__HelloWorldSceneSector__

#include <iostream>
#include "Sector.h"
#include "Config.h"
#include "HelloWorldSceneManager.h"
#include "Function.h"
#include "Event.h"
#include "Object.h"
#include <cocos2d.h>
#include "HelloWorldScene.h"

USING_NS_CC;
using namespace plter;

class HelloWorldSceneSector:public Sector {
    
public:
    HelloWorldSceneSector(HelloWorldSceneManager* mgr);
};





#endif /* defined(__UsingSector__HelloWorldSceneSector__) */
