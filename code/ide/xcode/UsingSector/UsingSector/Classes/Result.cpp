/*
 * Result.cpp
 *
 *      Author: plter
 */

#include "Result.h"

namespace plter {

Result::Result(string type):Event(type) {
}

Result::Result(string type, Object* data):Event(type,data) {
}

Result::~Result() {
	// TODO Auto-generated destructor stub
}

} /* namespace plter */
