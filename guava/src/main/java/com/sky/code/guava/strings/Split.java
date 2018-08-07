package com.sky.code.guava.strings;

import com.google.common.base.Splitter;

import java.util.Map;

public class Split {
    public static void main(String[] args){
        Iterable<String> splitResults = Splitter.onPattern("[,，]{1,}")
                .trimResults()
                .omitEmptyStrings()
                .split("hello,word,,世界，水平");

        for(String item : splitResults) {
            System.out.println(item);
        }

        String toSplitString = "a=b;c=d,e=f";
        Map<String,String> kvs = Splitter.onPattern("[,;]{1,}").withKeyValueSeparator('=').split(toSplitString);
        for (Map.Entry<String,String> entry : kvs.entrySet()) {
            System.out.println(String.format("%s=%s", entry.getKey(),entry.getValue()));
        }
    }
}
