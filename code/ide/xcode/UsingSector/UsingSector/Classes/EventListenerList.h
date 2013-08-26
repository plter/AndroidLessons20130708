/*
 * EventListenerList.h
 *
 *      Author: plter
 */

#ifndef EVENTLISTENERLIST_H_
#define EVENTLISTENERLIST_H_

#include "EventListener.h"
#include "Event.h"
#include <vector>
#include "Object.h"

using namespace std;

namespace plter {

class EventListenerList:public Object {
public:
	EventListenerList();
	virtual EventListener* addListener(EventListener* el);
	virtual EventListener* removeListener(EventListener* el);
	virtual EventListener* removeListener(string name);
	virtual bool dispatch(Event* e);
	virtual bool dispatch(Event* e,Object* target);
	virtual ~EventListenerList();

private:
	vector<EventListener*> _els;
};

} /* namespace plter */
#endif /* EVENTLISTENERLIST_H_ */
