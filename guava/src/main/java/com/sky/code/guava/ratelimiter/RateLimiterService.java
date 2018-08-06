package com.sky.code.guava.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterService {


    public RateLimiterService(double num){
        rateLimiter=RateLimiter.create(num);
    }

    RateLimiter rateLimiter ;


    public boolean tryAcquire(){
        return rateLimiter.tryAcquire();
    }
}
