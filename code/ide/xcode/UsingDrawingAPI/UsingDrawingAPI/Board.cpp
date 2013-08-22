//
//  Board.cpp
//  UsingDrawingAPI
//
//  Created by plter on 13-8-22.
//
//

#include "Board.h"

bool Board::init(){
    
    setAnchorPoint(ccp(0.5, 0.5));
    setContentSize(CCSizeMake(200, 200));
    
    setPosition(ccp(150, 150));
    
    return true;
}


void Board::draw(){
    
    ccDrawCircle(ccp(100, 100), 100, 360, 50, true);
    
    setRotation(getRotation()+10);
}