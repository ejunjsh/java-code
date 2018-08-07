package com.sky.code.guava.strings;

import com.google.common.base.Strings;

public class Padding {
    public static void main(String[] args){
         int minLength = 4;
         String padEndResult = Strings.padEnd("123", minLength, '0');
         System.out.println("padEndResult is " + padEndResult);
         String padStartResult = Strings.padStart("1", 2, '0');
         System.out.println("padStartResult is " + padStartResult);
    }
}
