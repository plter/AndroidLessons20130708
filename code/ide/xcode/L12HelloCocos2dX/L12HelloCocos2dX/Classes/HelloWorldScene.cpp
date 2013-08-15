#include "HelloWorldScene.h"
#include "SimpleAudioEngine.h"
#include "Hello.h"

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

//    Hello * h = Hello::create();
    
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
    
    this->setTouchEnabled(true);

    img = CCSprite::create("www.png");
//    img = new CCSprite();
//    img->initWithFile("img.jpg");
    
    this->addChild(img);
    img->setPosition(ccp(200, 200));
    
    CCLog("%f",img->getContentSize().width);
    
    return true;
}


void HelloWorld::ccTouchesBegan(cocos2d::CCSet *pTouches, cocos2d::CCEvent *pEvent){
    CCTouch * t = (CCTouch*) pTouches->anyObject();
    
    if(img->boundingBox().containsPoint(t->getLocation())){
//        CCLog("onTouch");
        CCMessageBox("Hello World", "Title");
    }
}


void HelloWorld::menuCloseCallback(CCObject* pSender)
{
    CCDirector::sharedDirector()->end();

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS)
    exit(0);
#endif
}
