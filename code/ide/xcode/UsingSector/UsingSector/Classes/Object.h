/*
 * Object.h
 *
 *      Author: plter
 */

#ifndef OBJECT_H_
#define OBJECT_H_

namespace plter {

class Object {
public:
	Object();
	virtual int retainCount();
	virtual void retain();
	virtual void release();
	virtual ~Object();

private:
	int _retainCount;
};

} /* namespace plter */
#endif /* OBJECT_H_ */
