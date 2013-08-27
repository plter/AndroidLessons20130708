//
//  RootSector.cpp
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#include "RootSector.h"

RootSector* RootSector::__instance = NULL;
    
RootSector::RootSector():Sector("root",NULL){
}

RootSector* RootSector::getInstacne(){
    if (__instance==NULL) {
        __instance = new RootSector();
    }
    return __instance;
}