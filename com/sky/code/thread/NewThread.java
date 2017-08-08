package com.sky.code.thread;

/**
 * Created by zhouff on 08/08/2017.
 */
public class NewThread extends Thread {

    @Override
    public void run(){
        System.out.println("I'm a thread that extends Thread!");
    }
}

