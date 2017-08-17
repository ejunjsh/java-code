package com.sky.code.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestNull {
    public static  void main(String[] args){
        System.out.println("测试ArrayList");
        List<Object> list = new ArrayList<Object>();
        list.add(null);
        list.add(null);
        System.out.println(list);

        System.out.println("测试LinkedList");
        List<Object> list1 = new LinkedList<Object>();
        list1.add(null);
        list1.add(null);
        System.out.println(list1);

        System.out.println("测试HashSet");
        Set<Object> set = new HashSet<Object>();
        set.add(null);
        set.add(null);
        System.out.println(set);

        System.out.println("测试TreeSet");
        Set<Object> treeSet = new TreeSet<Object>();
        try {
            treeSet.add(null);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("测试LinkedHashSet");
        Set<Object> set1 = new LinkedHashSet<Object>();
        set1.add(null);
        set1.add(null);
        System.out.println(set1);

        System.out.println("测试HashMap");
        Map<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put(null, null);
        hashMap.put(1, null);
        hashMap.put(1, 12);
        System.out.println(hashMap);

        System.out.println("测试LinkedHashMap");
        Map<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(null, null);
        linkedHashMap.put(null, null);
        linkedHashMap.put(1, null);
        linkedHashMap.put(1, 12);
        System.out.println(linkedHashMap);

        System.out.println("测试TreeMap");
        Map<Object, Object> treemap = new TreeMap<>();
        treemap.put(1, null);
        try {
            treemap.put(null, 1);
        }
        catch (Exception e){
            System.out.println(e);
        }
        treemap.put(2, 12);
        System.out.println(treemap);

        System.out.println("测试ConcurrentHashMap");
        Map<Object, Object> concurrentHashMap  = new ConcurrentHashMap<>();
        try {
            concurrentHashMap.put(null, 1);
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            concurrentHashMap.put(1, null);
        }
        catch (Exception e){
            System.out.println(e);
        }
        concurrentHashMap.put(1, 12);
        System.out.println(treemap);

        System.out.println("测试Hashtable");
        Map<Object, Object> hashtable = new Hashtable<>();
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
