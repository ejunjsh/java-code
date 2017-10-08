package com.sky.code.classloader;

public class ConstClass {
    static
    {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world";
}
