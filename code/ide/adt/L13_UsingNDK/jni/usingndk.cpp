#include <jni.h>
#include "Hello.h"
#include "cn_eoe_usingndk_UsingNDK.h"

using namespace eoe;


jint JNICALL Java_cn_eoe_usingndk_UsingNDK_getNum
  (JNIEnv *, jobject){
	return Hello::getNum();
}
