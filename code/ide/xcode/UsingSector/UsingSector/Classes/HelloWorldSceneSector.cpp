//
//  HelloWorldSceneSector.cpp
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#include "HelloWorldSceneSector.h"

class FuncStartHelloWorldView:public Function {
    
public:
    FuncStartHelloWorldView(Sector* s):Function(START_HELLO_WORLD_VIEW,s){
    };
    
    virtual bool execute(Event* e,Object* target){
        CCScene* scene = CCScene::create();
        HelloWorld* hw = HelloWorld::create();
        scene->addChild(hw);
        hw->setManager(getSector()->getManager());
        CCDirector::sharedDirector()->runWithScene(scene);
        return true;
    };
};


class FuncShowHelloWorldView:public Function {
    
public:
    FuncShowHelloWorldView(HelloWorldSceneSector* s):Function(SHOW_HELLO_WORLD_VIEW,s){
    };
    
    virtual bool execute(Event* e,Object* data){
        CCScene* scene = CCScene::create();
        HelloWorld* hw = HelloWorld::create();
        scene->addChild(hw);
        hw->setManager(getSector()->getManager());
        CCDirector::sharedDirector()->replaceScene(scene);
        return true;
    };
};


HelloWorldSceneSector::HelloWorldSceneSector(HelloWorldSceneManager* mgr):plter::Sector(SECTOR_NAME_HELLO_WORLD_SCENE,mgr){
    
    Function * func = new FuncShowHelloWorldView(this);
    addFunction(func);
    func->release();
    
    func = new FuncStartHelloWorldView(this);
    addFunction(func);
    func->release();
}