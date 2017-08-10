package com.sky.code.thread;

/**
 * Created by ejunjsh on 8/10/2017.
 */
public class TestInterrupt {

    public static void main(String[] args)
    {
        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e){
                    System.out.println("1.current interrupted flag is " +Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("2.current interrupted flag is " +Thread.currentThread().isInterrupted());
                }

                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e){
                    System.out.println("3.current interrupted flag is " +Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("4.current interrupted flag is " +Thread.currentThread().isInterrupted());
                }
            }
        });

        t.start();

        t.interrupt();

        try {
            t.join();
        } catch (InterruptedException e) {
        }

        System.out.println("5.current state is " +t.getState());
    }
}
