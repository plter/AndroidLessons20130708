//
//  GameScene.cpp
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#include "GameScene.h"

CCScene* GameSceneLayer::scene(){
    CCScene* scene = CCScene::create();
    GameSceneLayer* layer = GameSceneLayer::create();
    scene->addChild(layer);
    return scene;
}

bool GameSceneLayer::init(){
    
    CCSize size = CCDirector::sharedDirector()->getWinSize();
    
    CCLayer::init();
    CCSprite* s = CCSprite::create("game.jpg");
    addChild(s);
    
    s->setPosition(ccp(size.width/2, size.height/2));
    
    labelBack = CCLabelTTF::create();
    labelBack->setString("Back");
    labelBack->setFontSize(48);
    addChild(labelBack);
    labelBack->setAnchorPoint(ccp(0, 1));
    labelBack->setPosition(ccp(0, size.height));
    
    setTouchEnabled(true);
    
    return true;
}


void GameSceneLayer::ccTouchesBegan(cocos2d::CCSet *pTouches, cocos2d::CCEvent *pEvent){
    CCTouch* t = (CCTouch*)pTouches->anyObject();
    if (labelBack->boundingBox().containsPoint(t->getLocation())) {
        Request* req = new Request(SHOW_HELLO_WORLD_VIEW);
        getManager()->sendRequest(req);
        req->release();
    }
}


void GameSceneLayer::setManager(plter::Manager *mgr){
    _manager = mgr;
}

Manager* GameSceneLayer::getManager(){
    return _manager;
}
