package com.sky.code.guava.strings;

import com.google.common.base.Joiner;

import java.util.HashMap;
import java.util.Map;

public class Join {

    public static void main(String[] args){
        String joinResult = Joiner.on(" ").join(new String[]{"hello","world"});
        System.out.println(joinResult);

        Map<String,String> map = new HashMap<>();
        map.put("a", "b");
        map.put("c", "d");
        String mapJoinResult = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(mapJoinResult);
    }
}
