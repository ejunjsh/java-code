package com.sky.code.guava.optional;

import java.util.Optional;

public class Example {

    public static void main(String[] args) {
        Optional<Student> possibleNull = Optional.of(null);
        possibleNull.get();
    }
    public static class Student { }
}
