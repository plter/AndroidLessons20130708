/*
 * Sector.h
 *
 *      Author: plter
 */

#ifndef SECTOR_H_
#define SECTOR_H_


#include <string>
#include <vector>

#include "EventListenerList.h"
#include "Manager.h"
#include "Object.h"
#include "Function.h"
#include "Request.h"
#include "Command.h"
#include "Result.h"
#include "Callback.h"


using namespace std;

namespace plter {
class Manager;
class Function;
class Request;
class Result;
class Command;


class Sector :public Object{
public:
	Sector(string name,Manager* manager);
	virtual ~Sector();

	virtual string getName();
	virtual void addSector(Sector* s);
	virtual void removeSector(Sector* s);
	virtual void removeSector(string sectorName);
	virtual Sector* getSector(string name);
	virtual Sector* getParent();
	virtual void setManager(Manager* manager);
	virtual bool sendRequest(Request* req);
	virtual bool sendCommand(Command* cmd);
	virtual bool sendResult(Result* result);
	virtual Manager* getManager();
	virtual void addFunction(Function* f);
	virtual Function* removeFunction(Function* f);
	virtual Function* removeFunction(string name);
	virtual void addCallback(Callback* cb);
	virtual Callback* removeCallback(Callback* cb);
	virtual Callback* removeCallback(string name);

private:
	string _name;
	Manager* _manager;
	vector<Sector*> _children;
	Sector* _parent;
	EventListenerList* _commandAdapter;
	EventListenerList* _resultAdapter;

	virtual void tryToRemoveCurrentManager();
	virtual void setParent(Sector* p);
	virtual bool _sendRequest(Request* req);
};

} /* namespace plter */
#endif /* SECTOR_H_ */
