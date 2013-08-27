//
//  GameSceneSector.cpp
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#include "GameSceneSector.h"

class FuncShowGameView :public Function{
    
public:
    FuncShowGameView(Sector* target):Function(SHOW_GAME_VIEW,target){
    }
    
    
    virtual bool execute(Event* e,Object* data){
        GameSceneLayer* layer = GameSceneLayer::create();
        CCScene* scene = CCScene::create();
        scene->addChild(layer);
        layer->setManager(getSector()->getManager());
        CCDirector::sharedDirector()->replaceScene(scene);
        return true;
    };
};


GameSceneSctor::GameSceneSctor(Manager* mgr):plter::Sector(SECTOR_GAME_SCENE,mgr){
    FuncShowGameView * func = new FuncShowGameView(this);
    addFunction(func);
    func->release();
}