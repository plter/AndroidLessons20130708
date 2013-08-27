//
//  Help.cpp
//  UsingSector
//
//  Created by plter on 13-8-27.
//
//

#include "Help.h"


bool Help::init(){
    
    CCLayer::init();
    
    CCSize size = CCDirector::sharedDirector()->getWinSize();
    
    setTouchEnabled(true);
    
    labelBack = CCLabelTTF::create();
    labelBack->setString("Back");
    labelBack->setFontSize(48);
    addChild(labelBack);
    labelBack->setAnchorPoint(ccp(0, 1));
    labelBack->setPosition(ccp(0, size.height));
    
    
    CCLabelTTF* labelText = CCLabelTTF::create();
    labelText->setString("This help content is empty\nit's only an example\nvisit plter.com for more info");
    labelText->setAnchorPoint(ccp(1, 1));
    labelText->setFontSize(28);
    labelText->setPosition(ccp(size.width, size.height));
    addChild(labelText);
    
    return true;
}

void Help::ccTouchesBegan(cocos2d::CCSet *pTouches, cocos2d::CCEvent *pEvent){
    CCTouch* touch = (CCTouch*)pTouches->anyObject();
    if (labelBack->boundingBox().containsPoint(touch->getLocation())) {
        Request* req = new Request(SHOW_HELLO_WORLD_VIEW);
        getManager()->sendRequest(req);
        req->release();
    }
}


void Help::setManager(plter::Manager *mgr){
    _manager=mgr;
}


Manager* Help::getManager(){
    return _manager;
}