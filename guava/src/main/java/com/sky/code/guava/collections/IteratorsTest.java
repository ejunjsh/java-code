package com.sky.code.guava.collections;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class IteratorsTest {
    public static void main(String[] args){
        List<String> list = Lists.newArrayList("Apple","Pear","Peach","Banana");

        boolean allIsStartsWithP = Iterators.all(list.iterator(), input -> input.startsWith("P"));
        System.out.println("all result == " + allIsStartsWithP);

        Iterator<String> startPElements = Iterators.filter(list.iterator(), input -> input.startsWith("P"));


        while (startPElements.hasNext()){
            System.out.print(startPElements.next());
            System.out.print(" ");
        }
        System.out.println();

        String length5Element = Iterators.find(list.iterator(), input -> input.length() == 5);

        System.out.println(length5Element);

        Iterator<Integer> countIterator = Iterators.transform(list.iterator(), input -> input.length());

        while (countIterator.hasNext()){
            System.out.print(countIterator.next());
        }
        System.out.println();
    }
}
