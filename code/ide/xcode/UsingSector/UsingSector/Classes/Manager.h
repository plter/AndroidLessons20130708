/*
 * Manager.h
 *
 *      Author: plter
 */

#ifndef MANAGER_H_
#define MANAGER_H_


#include <string>
#include "Sector.h"
#include "Object.h"
#include "Request.h"
#include "Command.h"
#include "Result.h"

using namespace std;

namespace plter {
    class Sector;
    class Request;
    class Command;
    class Result;
    
    class Manager :public Object{
        
    public:
        Manager(string name);
        virtual ~Manager();
        
        virtual string getName();
        virtual Sector* getSector();
        virtual bool sendCommand(Command* cmd);
        virtual bool sendRequest(Request* req);
        virtual bool sendResult(Result* result);
        virtual bool handleRequest(Request* req);
        virtual bool reportToSuperior(Request* req);
        virtual void internal_setSector(Sector* s);
        
    private:
        string _name;
        Sector* _sector;
        
        virtual void tryToRemoveCurrentSector();
    };
    
} /* namespace plter */
#endif /* MANAGER_H_ */
