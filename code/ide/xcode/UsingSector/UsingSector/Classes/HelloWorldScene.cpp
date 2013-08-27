#include "HelloWorldScene.h"
#include "SimpleAudioEngine.h"
#include "Sector.h"

using namespace cocos2d;
using namespace CocosDenshion;
using namespace plter;

CCScene* HelloWorld::scene()
{
    // 'scene' is an autorelease object
    CCScene *scene = CCScene::create();
    
    // 'layer' is an autorelease object
    HelloWorld *layer = HelloWorld::create();

    // add layer as a child to scene
    scene->addChild(layer);

    // return the scene
    return scene;
}

// on "init" you need to initialize your instance
bool HelloWorld::init()
{
    //////////////////////////////
    // 1. super init first
    if ( !CCLayer::init() )
    {
        return false;
    }

    setTouchEnabled(true);
    
    CCSize size = CCDirector::sharedDirector()->getWinSize();
    
    labelShowHelp = CCLabelTTF::create();
    labelShowHelp->setString("Show Help");
    labelShowHelp->setFontSize(48);
    labelShowHelp->setPosition(ccp(size.width/2, 100));
    addChild(labelShowHelp);
    
    labelStartGame = CCLabelTTF::create();
    labelStartGame->setString("Start Game");
    labelStartGame->setFontSize(48);
    labelStartGame->setPosition(ccp(size.width/2, 200));
    addChild(labelStartGame);
    
    return true;
}

void HelloWorld::ccTouchesBegan(cocos2d::CCSet *pTouches, cocos2d::CCEvent *pEvent){
    CCTouch* touch = (CCTouch*)pTouches->anyObject();
    Request* req;
    if (labelStartGame->boundingBox().containsPoint(touch->getLocation())) {
        req = new Request(SHOW_GAME_VIEW);
        getManager()->sendRequest(req);
        req->release();
    }else if (labelShowHelp->boundingBox().containsPoint(touch->getLocation())){
        req = new Request(SHOW_HELP_CONTENT);
        getManager()->sendRequest(req);
        req->release();
    }
}


void HelloWorld::setManager(plter::Manager *mgr){
    _manager = mgr;
}

Manager* HelloWorld::getManager(){
    return _manager;
}


void HelloWorld::menuCloseCallback(CCObject* pSender)
{
    CCDirector::sharedDirector()->end();

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS)
    exit(0);
#endif
}
