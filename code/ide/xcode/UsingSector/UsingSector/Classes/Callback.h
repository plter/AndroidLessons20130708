/*
 * Callback.h
 *
 *      Author: plter
 */

#ifndef CALLBACK_H_
#define CALLBACK_H_

#include <string>
#include "EventListener.h"

using namespace std;


namespace plter {

class Callback :public EventListener{
public:
	Callback(string name);
	virtual ~Callback();
};

} /* namespace plter */
#endif /* CALLBACK_H_ */
