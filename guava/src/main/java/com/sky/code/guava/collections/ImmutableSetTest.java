package com.sky.code.guava.collections;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class ImmutableSetTest {
    public static void main(String[] args) {
        Set<String> immutableNamedColors = ImmutableSet.<String>builder()
                .add("red", "green","black","white","grey")
                .build();
        //immutableNamedColors.add("abc");
        for (String color : immutableNamedColors) {
            System.out.println(color);
        }
    }
}
