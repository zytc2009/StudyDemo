package com.example.studyproject.jni;

public class JNITest {

    static {
        System.loadLibrary("hello");
    }

    public static native String helloInC();

}
