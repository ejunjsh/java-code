package com.sky.code.thread;


public class Single_Producer_Consumer_Lock {
    public static void main(String[] args)
    {
        KaoYaResourceByLock r = new KaoYaResourceByLock();
        ProducerByLock pro = new ProducerByLock(r);
        ConsumerByLock con = new ConsumerByLock(r);
        //生产者线程
        Thread t0 = new Thread(pro);
        //消费者线程
        Thread t2 = new Thread(con);
        //启动线程
        t0.start();
        t2.start();
    }
}

class ProducerByLock implements Runnable
{
    private KaoYaResourceByLock r;
    ProducerByLock(KaoYaResourceByLock r)
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

class ConsumerByLock implements Runnable
{
    private KaoYaResourceByLock r;
    ConsumerByLock(KaoYaResourceByLock r)
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
