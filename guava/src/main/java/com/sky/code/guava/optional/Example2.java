package com.sky.code.guava.optional;

import com.google.common.base.Optional;

public class Example2 {
    public static void main(String[] args) {
        Optional<Student> possibleNull = Optional.absent();
        Student jim = possibleNull.get();
    }
    public static class Student { }
}
