/*
 * Event.h
 *
 *      Author: plter
 */

#ifndef EVENT_H_
#define EVENT_H_

#include <string>
#include "Object.h"

using namespace std;


namespace plter {

class Event :public Object{
public:
	Event(string type);
	Event(string type,Object* data);
	Event(Object* data);
	virtual string getType();
	virtual Object* getData();
	virtual ~Event();

private:
	string _type;
	Object* _data;
	virtual void setData(Object* data);
	virtual void setType(string type);
};

} /* namespace plter */
#endif /* EVENT_H_ */
