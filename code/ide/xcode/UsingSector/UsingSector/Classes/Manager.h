/*
 * Manager.h
 *
 *      Author: plter
 */

#ifndef MANAGER_H_
#define MANAGER_H_


#include <string>
#include "Sector.h"
#include "Object.h"

using namespace std;

namespace plter {
class Sector;
class Request;

class Manager :public Object{

public:
	Manager(string name,void* target);
	virtual ~Manager();

	virtual string getName();
	virtual void* getTarget();
	virtual Sector* getSector();
	virtual bool handleRequest(Request* req);
	virtual void internal_setSector(Sector* s);

private:
	void* _target;
	string _name;
	Sector* _sector;

	virtual void tryToRemoveCurrentSector();
};

} /* namespace plter */
#endif /* MANAGER_H_ */
