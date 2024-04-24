package com.example.day16.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exam1 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("drain", "ali", "cyon", "bria", "eiv");
        Collections.sort(strList, (o1, o2) -> o1.compareTo(o2));
        strList.forEach(System.out::println);
    }
}
