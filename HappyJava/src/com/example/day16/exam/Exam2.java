package com.example.day16.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 23, 5, 2, 341, 55,6, 32);
        // 정렬하게 되면 가장 큰 값이 첫번째 인덱스에 위치함
        Collections.sort(numbers, (Integer n1, Integer n2) -> n2.compareTo(n1));
        System.out.println(numbers.get(0));

    }
}
