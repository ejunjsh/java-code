package com.sky.code.oom;


import java.util.ArrayList;
import java.util.List;

/**
 * JDK 1.6 VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * JDK 1.7 VM Args: -Xms10m -Xmx10m 
 */
public class RuntimeConstantPoolOOM{
    public static void main(String[] args){
        List<String> list=new ArrayList<String>();

        int i=0;

        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }

//    public static void main(String[] args){
//        String str1=new StringBuilder("hello").append(" world").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2=new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
//    }
}