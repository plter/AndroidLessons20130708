//
//  HelpSector.cpp
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#include "HelpSector.h"

class FuncShowHelp:public Function {
    
public:
    FuncShowHelp(Sector* s):Function(SHOW_HELP_CONTENT,s){
    };
    
    virtual bool execute(Event* e,Object* data){
        Help* h = Help::create();
        CCScene* scene = CCScene::create();
        scene->addChild(h);
        h->setManager(getSector()->getManager());
        CCDirector::sharedDirector()->replaceScene(scene);
        return true;
    };
};


HelpSector::HelpSector(Manager* mgr):plter::Sector(SHOW_HELP_CONTENT,mgr){
    FuncShowHelp* func = new FuncShowHelp(this);
    addFunction(func);
    func->release();
}