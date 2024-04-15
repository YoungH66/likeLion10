package com.example.day10;

import java.util.Arrays;
import java.util.List;

public class WildcardExample {
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("a", "b", "c");
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        printList(list);
        printList(strList);
        printList(doubleList);
    }
}
