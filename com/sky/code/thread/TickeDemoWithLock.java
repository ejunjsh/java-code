package com.sky.code.thread;


public class TickeDemoWithLock {
    public static void main(String[] args)
    {
        TicketSellerWithLock t = new TicketSellerWithLock();//创建一个线程任务对象。

        //创建4个线程同时卖票
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
