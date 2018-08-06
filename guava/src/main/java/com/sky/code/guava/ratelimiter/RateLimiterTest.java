package com.sky.code.guava.ratelimiter;

import java.util.Date;

public class RateLimiterTest {

    public static void main(String[] args) {
        RateLimiterService service = new RateLimiterService(5.0);

        while (true) {
            if(service.tryAcquire()){
                System.out.println(new Date());
            }
        }
    }
}
