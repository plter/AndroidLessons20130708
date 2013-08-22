//
//  Ball.cpp
//  Balls
//
//  Created by plter on 13-8-22.
//
//

#include "Ball.h"


Ball* Ball::create(float r){
    Ball* b = new Ball();
    b->initWithR(r);
    b->autorelease();
    return b;
}

bool Ball::initWithR(float r){
    init();
    this->r = r;
    speedX = 5;
    speedY = 5;
    setBoundingSize(480, 320);
    
    return true;
}

void Ball::move(){
    setPositionX(getPositionX()+speedX);
    setPositionY(getPositionY()+speedY);
    
    if (getPositionX()<r) {
        speedX = MABS(speedX);
    }
    if (getPositionY()<r) {
        speedY = MABS(speedY);
    }
    if (getPositionX()>boundWidth-r) {
        speedX = -MABS(speedX);
    }
    if (getPositionY()>boundHeight-r) {
        speedY = -MABS(speedY);
    }
}



void Ball::draw(){
    ccDrawCircle(CCPointZero, r, 360, 3, true);
    
    setRotation(getRotation()+10);
}


