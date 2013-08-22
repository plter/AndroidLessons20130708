//
//  Img.h
//  HelloCC
//
//  Created by plter on 13-8-22.
//
//

#ifndef __HelloCC__Img__
#define __HelloCC__Img__

#include <iostream>
#include <cocos2d.h>

USING_NS_CC;


class Img :public CCSprite{
    
public:
    
    CREATE_FUNC(Img);
    
    virtual bool init();
};

#endif /* defined(__HelloCC__Img__) */
