package com.sky.code.classloader;

public class Test
{
    static
    {
        i=0;
//      System.out.println(i); Cannot reference a field before it is defined（非法向前引用）
    }
    static int i=1;
    public static void main(String args[])
    {
        System.out.println(i);
    }
}
