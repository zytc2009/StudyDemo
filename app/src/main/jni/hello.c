//
// Created by zsj的MacBook Pro on 2020-09-18.
//
#include<stdlib.h>
#include<stdio.h>
#include<jni.h>

JNIEXPORT jstring JNICALL Java_com_example_studyproject_jni_JNITest_helloInC
  (JNIEnv * env, jclass thiz){

    return (*env)->NewStringUTF(env,"hello from c !!!");


}