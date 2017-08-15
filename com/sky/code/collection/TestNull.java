package com.sky.code.collection;

import java.util.*;

public class TestNull {
    public static  void main(String[] args){
        // 测试List
        List<Object> list = new ArrayList<Object>();
        list.add(null);
        list.add(null);
        System.out.println(list);

        // 测试Set
        Set<Object> set = new HashSet<Object>();
        set.add(null);
        set.add(null);
        System.out.println(set);

        // 测试HashMap与Hashtable
        Map<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put(null, null);
        hashMap.put(null, null);
        hashMap.put(1, null);
        hashMap.put(1, 12);
        System.out.println(hashMap);

        Map<Object, Object> hashtable = new Hashtable<Object, Object>();
        hashtable.put(1, "string1");
        hashtable.put(2, "string2");
        System.out.println(hashtable);
        try {
            hashtable.put(null,"null");
        }
        catch (Exception e){
            System.out.println(e);
        }
        try {
            hashtable.put(3,null);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
