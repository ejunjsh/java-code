package com.sky.code.thread;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args){

        FutureTask<String> f=new FutureTask<>(() -> {
            int i=0;
            for (int j=0;j<100000;j++){
                i++;
            }
            Thread.sleep(5000);
            return i+"";
        });
        Thread thread=new Thread(f);
        thread.start();
        System.out.println("主线程在执行其他任务");
        try {
            System.out.println("future task result : "+f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
