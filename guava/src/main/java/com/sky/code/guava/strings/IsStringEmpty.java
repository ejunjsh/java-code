package com.sky.code.guava.strings;

import com.google.common.base.Strings;

public class IsStringEmpty {
    public static void main(String[] args){
        String input = "";
        boolean isNullOrEmpty = Strings.isNullOrEmpty(input);
        System.out.println("input " + (isNullOrEmpty?"is":"is not") + " null or empty.");
    }
}
