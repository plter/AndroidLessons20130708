/*
 * Man.h
 *
 *  Created on: 2013-8-12
 *      Author: plter
 */

#ifndef MAN_H_
#define MAN_H_

#include "People.h"

namespace cn{
namespace eoe{

class Man: public People {
public:
	Man();
	virtual void sayHello();
	virtual ~Man();
};

}
}

#endif /* MAN_H_ */
