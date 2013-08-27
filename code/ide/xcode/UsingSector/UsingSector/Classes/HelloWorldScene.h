#ifndef __HELLOWORLD_SCENE_H__
#define __HELLOWORLD_SCENE_H__

#include "cocos2d.h"
#include "Manager.h"
#include "RootSector.h"
#include "Request.h"
#include "Config.h"

using namespace plter;
USING_NS_CC;

class HelloWorld : public cocos2d::CCLayer
{
public:
    // Method 'init' in cocos2d-x returns bool, instead of 'id' in cocos2d-iphone (an object pointer)
    virtual bool init();

    // there's no 'id' in cpp, so we recommend to return the class instance pointer
    static cocos2d::CCScene* scene();
    
    // a selector callback
    void menuCloseCallback(CCObject* pSender);
    
    virtual void ccTouchesBegan(CCSet *pTouches, CCEvent *pEvent);

    virtual void setManager(Manager* mgr);
    virtual Manager* getManager();
    // preprocessor macro for "static create()" constructor ( node() deprecated )
    CREATE_FUNC(HelloWorld);
    
private:
    CCLabelTTF* labelStartGame;
    CCLabelTTF* labelShowHelp;
    Manager* _manager;
};

#endif // __HELLOWORLD_SCENE_H__
