//
//  Ball.h
//  Balls
//
//  Created by plter on 13-8-22.
//
//

#ifndef __Balls__Ball__
#define __Balls__Ball__

#include <iostream>
#include <cocos2d.h>

USING_NS_CC;

#define MABS(x) x>0?x:-x

class Ball:public CCSprite {
    
    
public:
    
    static Ball* create(float r);
    
    virtual bool initWithR(float r);
    virtual void draw();
    virtual void move();
    
    virtual void setBoundingSize(float w,float h){
        this->boundWidth = w;
        this->boundHeight = h;
    };
    
private:
    float r,speedX,speedY;
    float boundWidth,boundHeight;
};


#endif /* defined(__Balls__Ball__) */
