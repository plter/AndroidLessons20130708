/*
 * EventListener.h
 *
 *      Author: plter
 */

#ifndef EVENTLISTENER_H_
#define EVENTLISTENER_H_

#include "Event.h"
#include <string>
#include "Object.h"

using namespace std;


namespace plter {

class EventListener :public Object{
public:
	EventListener();
	EventListener(string name);
	virtual string getName();
	virtual bool execute(Event* e,Object* target);
	virtual ~EventListener();

private:
	string _name;
};

} /* namespace plter */
#endif /* EVENTLISTENER_H_ */
