package com.sky.code.guava.object;

import com.google.common.base.Objects;

public class EqualTest {
    public static void main(String[] args){
        Object a = null;
        Object b = new Object();
        boolean aEqualsB = Objects.equal(a, b);

        if(aEqualsB){
            System.out.println("a is equal to b");
        }
    }
}
