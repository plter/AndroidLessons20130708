/*
 * Command.cpp
 *
 *      Author: plter
 */

#include "Command.h"

namespace plter {

Command::Command(string type):Event(type) {
}

Command::Command(string type, Object* data):Event(type,data) {
}

Command::~Command() {
}

} /* namespace plter */
