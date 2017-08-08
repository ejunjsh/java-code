package com.sky.code.thread;


public class Demon {
    public static void main(String[] args) {
        Thread deamon = new Thread(new DaemonRunner(),"DaemonRunner");
        //设置为守护线程
        deamon.setDaemon(true);
        deamon.start();//启动线程
    }


    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                System.out.println("这里的代码在java虚拟机退出时并不一定会执行哦！");
            }
        }
    }
}
