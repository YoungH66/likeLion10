package com.example.day11;

import java.util.*;

public class ComparableExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("king");
        list.add("queen");
        list.add("jack");
        list.add("jocker");

        System.out.println(list);

        // Collection에서 제공하는 sort
        // 이 경우 알파벳으로 정렬
        Collections.sort(list);

        System.out.println(list);

    }
}
