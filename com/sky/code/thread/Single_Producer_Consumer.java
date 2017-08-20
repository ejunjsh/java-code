package com.sky.code.thread;


public class Single_Producer_Consumer {

    public static void main(String[] args)
    {
        KaoYaResource r = new KaoYaResource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        //启动线程
        t0.start();
        t2.start();
    }
}

class Producer implements Runnable
{
    private KaoYaResource r;
    Producer(KaoYaResource r)
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

class Consumer implements Runnable
{
    private KaoYaResource r;
    Consumer(KaoYaResource r)
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
