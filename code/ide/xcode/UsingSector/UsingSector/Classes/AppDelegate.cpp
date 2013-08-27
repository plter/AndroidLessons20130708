//
//  UsingSectorAppDelegate.cpp
//  UsingSector
//
//  Created by plter on 13-8-26.
//  Copyright __MyCompanyName__ 2013年. All rights reserved.
//

#include "AppDelegate.h"

#include "cocos2d.h"
#include "SimpleAudioEngine.h"
#include "HelloWorldScene.h"
#include "RootSector.h"
#include "HelloWorldSceneSector.h"
#include "HelloWorldSceneManager.h"
#include "Command.h"
#include "GameSceneSector.h"
#include "GameSceneManager.h"
#include "HelpManager.h"
#include "HelpSector.h"

using namespace plter;

USING_NS_CC;
using namespace CocosDenshion;

AppDelegate::AppDelegate()
{

}

AppDelegate::~AppDelegate()
{
}

bool AppDelegate::applicationDidFinishLaunching()
{
    
    // initialize director
    CCDirector *pDirector = CCDirector::sharedDirector();
    pDirector->setOpenGLView(CCEGLView::sharedOpenGLView());
    
    // turn on display FPS
    pDirector->setDisplayStats(true);
    
    // set FPS. the default value is 1.0/60 if you don't call this
    pDirector->setAnimationInterval(1.0 / 60);
    
    
    
    //init sector framework
    RootSector* root = RootSector::getInstacne();
    
    HelloWorldSceneManager* helloWorldSceneMgr = new HelloWorldSceneManager();
    root->addSector(new HelloWorldSceneSector(helloWorldSceneMgr));
    helloWorldSceneMgr->release();
    
    Manager* mgr = new GameSceneManager();
    root->addSector(new GameSceneSctor(mgr));
    mgr->release();
    
    mgr = new HelpManager();
    root->addSector(new HelpSector(mgr));
    mgr->release();
    
    
    //start app
    Command* cmd = new Command(START_HELLO_WORLD_VIEW);
    root->sendCommand(cmd);
    cmd->release();

    return true;
}

// This function will be called when the app is inactive. When comes a phone call,it's be invoked too
void AppDelegate::applicationDidEnterBackground()
{
    CCDirector::sharedDirector()->stopAnimation();
    SimpleAudioEngine::sharedEngine()->pauseBackgroundMusic();
    SimpleAudioEngine::sharedEngine()->pauseAllEffects();
}

// this function will be called when the app is active again
void AppDelegate::applicationWillEnterForeground()
{
    CCDirector::sharedDirector()->startAnimation();
    SimpleAudioEngine::sharedEngine()->resumeBackgroundMusic();
    SimpleAudioEngine::sharedEngine()->resumeAllEffects();
}
