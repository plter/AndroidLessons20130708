/*
 * People.h
 *
 *  Created on: 2013-8-12
 *      Author: plter
 */

#ifndef PEOPLE_H_
#define PEOPLE_H_

namespace cn{
namespace eoe{

class People {
public:
	People();
	virtual void sayHello();
	virtual ~People();


private:
	int a;

protected:
	int b;
};
}
}

#endif /* PEOPLE_H_ */
