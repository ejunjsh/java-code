package com.sky.code.thread;


public class Mutil_Producer_Consumer {
    public static void main(String[] args)
    {
        KaoYaResourceByMulti r = new KaoYaResourceByMulti();
        Mutil_Producer pro = new Mutil_Producer(r);
        Mutil_Consumer con = new Mutil_Consumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        //启动线程
        t0.start();
        t1.start();
        t2.start();
        t3.start();
    }
}

class Mutil_Producer implements Runnable
{
    private KaoYaResourceByMulti r;
    Mutil_Producer(KaoYaResourceByMulti r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.product("北京烤鸭");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Mutil_Consumer implements Runnable
{
    private KaoYaResourceByMulti r;
    Mutil_Consumer(KaoYaResourceByMulti r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.consume();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
