/*
 * Request.cpp
 *
 *      Author: plter
 */

#include "Request.h"

namespace plter {

Request::Request(string type) :Event(type){
}

Request::Request(string type, Object* data):Event(type,data) {
}

Request::~Request() {
}

} /* namespace plter */
