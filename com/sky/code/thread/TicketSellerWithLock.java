package com.sky.code.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketSellerWithLock implements Runnable {

    //创建锁对象
    private Lock ticketLock = new ReentrantLock();

    //创建锁对象(公平锁)
    //private Lock ticketLock = new ReentrantLock(true);

    private  int num = 100;
    public void run()
    {
        while(true)
        {
            ticketLock.lock();//获取锁
            if(num>0)
            {
                try{
                    Thread.sleep(10);
                    //输出卖票信息
                    System.out.println(Thread.currentThread().getName()+".....sale...."+num--);
                }catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();//继续中断异常
                }finally {
                    ticketLock.unlock();//释放锁
                }

            }
            else {
                ticketLock.unlock();//释放锁
                break;
            }
        }
    }
}
