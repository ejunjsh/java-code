package com.sky.code.thread;

/**
 * Created by zhouff on 08/08/2017.
 */
public class StartThread {
    public static void main(String[] args){

        NewThread t1=new NewThread();
        t1.start();

        NewRunnable r=new NewRunnable();
        Thread t2=new Thread(r);
        t2.start();
    }
}
