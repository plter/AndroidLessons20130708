//
//  RootSector.h
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#ifndef __UsingSector__RootSector__
#define __UsingSector__RootSector__

#include <iostream>
#include "Sector.h"
#include <string>

using namespace std;
using namespace plter;

class RootSector :public Sector{
    
public:
    RootSector();
    
    static RootSector* getInstacne();
    
private:
    static RootSector* __instance;
};

#endif /* defined(__UsingSector__RootSector__) */
