package com.sky.code.thread;


public class TicketSeller implements Runnable {
    private  int num = 100;
    public void run()
    {
        while(true)
        {
            if(num>0)
            {
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //输出卖票信息
                System.out.println(Thread.currentThread().getName()+".....sale...."+num--);
            }
            else {
                break;
            }
        }
    }
}
