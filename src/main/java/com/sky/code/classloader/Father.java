package com.sky.code.classloader;

public class Father extends Grandfather
{
    static
    {
        System.out.println("Father init!");
    }

    public static int value = 123;

    public Father()
    {
        System.out.println("init Father");
    }
}
