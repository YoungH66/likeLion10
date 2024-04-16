package com.example.day11;

import java.util.*;

public class SetExam {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        System.out.println(set);

        // set은 중복허용하지 않음
        set.add("A");
        System.out.println(set);

        /*List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        System.out.println(list);*/

        if(set.contains("h"))
            System.out.println("true");

        Set<Pen> penSet = new HashSet<>();
        penSet.add(new Pen("Red"));
        penSet.add(new Pen("Green"));
        penSet.add(new Pen("Blue"));
        penSet.add(new Pen("Yellow"));
        System.out.println(penSet);
        // new를 통해 생성되어 주소값이 다르다고 판단 -> 다름
        // 같다고 판단하기 위해선 클래스 파일에서 .equals()를 수정해야 한다.
        penSet.add(new Pen("Red"));
        System.out.println(penSet);
    }
}
