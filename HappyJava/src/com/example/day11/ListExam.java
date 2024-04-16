package com.example.day11;

import java.util.*;

public class ListExam {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("apple");
        strList.add("banana");
        strList.add("cherry");

        String first  = strList.get(0);
        System.out.println(first);

        strList.set(0, "orange");
        System.out.println(first);
        System.out.println(strList.get(0));

        System.out.println(strList);
        strList.remove(1);
        System.out.println(strList);

        Iterator<String> iterator = strList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("================");
        // 요소의 추가와 삭제가 빠르다
        // 임의 접급에 대해선 상대적으로 느리다.
        List<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");

        linkedList.remove("a");

        List<Integer> iList = new ArrayList<>();
        iList.add(1);
        iList.add(2);
        iList.add(3);
        iList.add(4);
        iList.add(5);

        System.out.println(iList);
        Collections.shuffle(iList);
        System.out.println(iList);
        Collections.sort(iList);
        System.out.println(iList);
    }
}
