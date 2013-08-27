//
//  HelpSector.h
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#ifndef __UsingSector__HelpSector__
#define __UsingSector__HelpSector__

#include <iostream>
#include "Sector.h"
#include "Manager.h"
#include "Config.h"
#include "Function.h"
#include "Event.h"
#include "Object.h"
#include "Help.h"
#include <cocos2d.h>

using namespace plter;
USING_NS_CC;


class HelpSector :public Sector{
    
public:
    HelpSector(Manager* mgr);
    
};

#endif /* defined(__UsingSector__HelpSector__) */
