/*
 * Command.h
 *
 *      Author: plter
 */

#ifndef COMMAND_H_
#define COMMAND_H_

#include "Event.h"
#include <string>
#include "Object.h"

using namespace std;


namespace plter {

class Command: public plter::Event {
public:
	Command(string type);
	Command(string type,Object* data);
	virtual ~Command();
};

} /* namespace plter */
#endif /* COMMAND_H_ */
