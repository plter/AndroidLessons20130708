#include "HelloWorldScene.h"
#include "SimpleAudioEngine.h"
#include "Img.h"

using namespace cocos2d;
using namespace CocosDenshion;

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

//    Img * img = Img::create();
//    img->init();
    
    s = CCSprite::create("img.jpg");
    s->setAnchorPoint(ccp(0, 0));
    addChild(s);
    
    
    return true;
}

void HelloWorld::ccTouchesBegan(cocos2d::CCSet *pTouches, cocos2d::CCEvent *pEvent){
    
//    CCSetIterator it;
//    CCTouch * touch;
//    
//    for (it = pTouches->begin(); it!=pTouches->end(); it++) {
//        touch = (CCTouch*)(*it);
//        
//        
//    }
    
    CCTouch* touch = (CCTouch*) pTouches->anyObject();
    
    if(s->boundingBox().containsPoint(touch->getLocation())){
        CCMessageBox("Clicked", "title");
    }
    
    
//    CCLog("Touch Begin");
}


void HelloWorld::menuCloseCallback(CCObject* pSender)
{
    CCDirector::sharedDirector()->end();

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS)
    exit(0);
#endif
}
