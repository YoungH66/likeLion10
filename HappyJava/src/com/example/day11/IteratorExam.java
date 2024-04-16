package com.example.day11;

import java.util.*;

public class IteratorExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator<String> itr = list.iterator();
        // list에 다음 요소가 있다면
        while(itr.hasNext()){
            // iterator로 다음요소를 선택
            System.out.println(itr.next());
        }
        // Set은 순서가 없다
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        Iterator<String> itr2 = set.iterator();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }

        // 물론 for-each로 접근할수도 있다.
        // java 5에서 추가
        for(String s : set){
            System.out.println(s);
        }
    }
}
