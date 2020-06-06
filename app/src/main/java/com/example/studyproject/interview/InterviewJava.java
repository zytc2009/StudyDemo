package com.example.studyproject.interview;

public class InterviewJava {

    public static void main(String[] args) {
        char test = '汉';
        System.out.println(Integer.toHexString(test));

        String string = "哈ha";
        System.out.println(string.length());

        byte[] bytes = new byte[Integer.MAX_VALUE];
        new String(bytes);
        System.out.println();

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };

}
