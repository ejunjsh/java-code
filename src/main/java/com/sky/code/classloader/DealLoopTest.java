package com.sky.code.classloader;

import java.util.concurrent.TimeUnit;

public class DealLoopTest
{
    static class DeadLoopClass
    {
        static
        {
            if(true)
            {
                System.out.println(Thread.currentThread()+"init DeadLoopClass");
                while(true)
                {
                }
            }
        }
//        static
//        {
//            System.out.println(Thread.currentThread() + "init DeadLoopClass");
//            try
//            {
//                TimeUnit.SECONDS.sleep(10);
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args)
    {
        Runnable script = () -> {
            System.out.println(Thread.currentThread()+" start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread()+" run over");
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}