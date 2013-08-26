/*
 * Request.h
 *
 *      Author: plter
 */

#ifndef REQUEST_H_
#define REQUEST_H_

#include "Event.h"

namespace plter {

class Request: public plter::Event {
public:
	Request(string type);
	Request(string type,Object* data);
	virtual ~Request();
};

} /* namespace plter */
#endif /* REQUEST_H_ */
