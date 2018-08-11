package com.sky.code.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    static AtomicInteger atomicInteger=new AtomicInteger(0);

    static void plus(){
        for(int i=0;i<10000;i++){
            atomicInteger.getAndIncrement();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(() -> plus());
        Thread thread2=new Thread(() -> plus());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.printf("the result is %d \n",atomicInteger.get());
    }
}
