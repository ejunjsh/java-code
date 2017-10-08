package com.sky.code.classloader;

public class Child extends Father
{
    static
    {
        System.out.println("Child init");
    }

    static int a;

    public Child()
    {
        System.out.println("init Child");
    }
}
