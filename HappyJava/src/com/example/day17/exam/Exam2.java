package com.example.day17.exam;

import java.util.*;

public class Exam2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> words1 = words.stream().filter(s -> s.length() >= 5).toList();
        System.out.println(words1);
    }
}
