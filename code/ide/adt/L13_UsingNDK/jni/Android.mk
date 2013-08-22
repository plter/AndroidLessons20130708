LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := usingndk
LOCAL_SRC_FILES := usingndk.cpp \
Hello.cpp

include $(BUILD_SHARED_LIBRARY)
