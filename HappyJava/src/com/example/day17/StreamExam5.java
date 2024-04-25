package com.example.day17;

import java.util.*;

public class StreamExam5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        // forEach
        numbers.stream().forEach(n -> System.out.println("Number : " + n));
        System.out.println(numbers);
        // peek
        List<Integer> numbers2 = numbers.stream()
                .peek(n -> System.out.println("Processing 1 : " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Processing 2 : " + n))
                .toList();
        System.out.println(numbers2);
    }
}
