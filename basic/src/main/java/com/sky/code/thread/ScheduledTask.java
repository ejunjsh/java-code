package com.sky.code.thread;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledTask {
    public ScheduledThreadPoolExecutor se = new ScheduledThreadPoolExecutor(5);
    public static void main(String[] args) {
        new ScheduledTask();
    }
    public void fixedPeriodSchedule() {
        // ?????????runnable,?????0????????????5?
        for(int i=0;i<5;i++){
            se.scheduleAtFixedRate(new FixedSchedule(), 0, 5, TimeUnit.SECONDS);
        }
    }
    public ScheduledTask() {
        fixedPeriodSchedule();
    }
    class FixedSchedule implements Runnable {
        public void run() {
            System.out.println("?????"+Thread.currentThread().getName()+"  ?????"+new Date(System.currentTimeMillis()));
        }
    }
}
