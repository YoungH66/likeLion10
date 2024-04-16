package com.example.day11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(111, "King");
        map.put(222, "Queen");
        map.put(333, "Jack");

        System.out.println(map);

        System.out.println(map.get(111));

        // get이 원본에 영향을 미치지 않음
        System.out.println(map);

        // map의 key를 set에 저장
        Set<Integer> keyset = map.keySet();
        // key가 저장된 set에 대한 iterator
        Iterator<Integer> iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println("key : " + key + "\tvalue : "+map.get(key));
        }

        System.out.println("===============");
        // iterator while 문법을 for-each 문법으로 대체할 수 있다.
        for(Integer key : keyset) {
            System.out.println("key : " + key + "\tvalue : "+map.get(key));
        }
    }
}
