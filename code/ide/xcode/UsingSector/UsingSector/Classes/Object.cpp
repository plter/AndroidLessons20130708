/*
 * Object.cpp
 *
 *      Author: plter
 */

#include "Object.h"

namespace plter {

Object::Object() {
	_retainCount = 1;
}

int Object::retainCount() {
	return _retainCount;
}

void Object::retain() {
	_retainCount++;
}

void Object::release() {
	_retainCount--;
	if (_retainCount<=0) {
		delete this;
	}
}

Object::~Object() {
	// TODO Auto-generated destructor stub
}

} /* namespace plter */
