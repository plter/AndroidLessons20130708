/*
 * Function.h
 *
 *      Author: plter
 */

#ifndef FUNCTION_H_
#define FUNCTION_H_

#include "EventListener.h"

namespace plter {

class Function: public plter::EventListener {
public:
	Function(string name);
	virtual ~Function();
};

} /* namespace plter */
#endif /* FUNCTION_H_ */
