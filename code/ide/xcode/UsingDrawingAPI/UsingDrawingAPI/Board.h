//
//  Board.h
//  UsingDrawingAPI
//
//  Created by plter on 13-8-22.
//
//

#ifndef __UsingDrawingAPI__Board__
#define __UsingDrawingAPI__Board__

#include <iostream>

#include <cocos2d.h>

USING_NS_CC;

class Board :public CCSprite{
    
public:
    CREATE_FUNC(Board);
    
    virtual bool init();
    virtual void draw();
};


#endif /* defined(__UsingDrawingAPI__Board__) */
