/*
 * Function.h
 *
 *      Author: plter
 */

#ifndef FUNCTION_H_
#define FUNCTION_H_

#include "EventListener.h"
#include "Sector.h"

namespace plter {
    class Sector;
    
    class Function: public plter::EventListener {
    public:
        Function(string name,Sector* sector);
        virtual ~Function();
        
        virtual Sector* getSector();
        
    private:
        Sector* _target;
    };
    
} /* namespace plter */
#endif /* FUNCTION_H_ */
