package com.example.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CollectionExam01 {
    public static void main(String[] args) {
        // 배열과 달리 List는 가변길이 구조이다.
        ArrayList<String> strList = new ArrayList<>();

        strList.add("a");
        strList.add("b");
        strList.add("c");
        System.out.println(strList.size());

        for(String str : strList) {
            System.out.print(str + " ");
        }
        System.out.println();

        strList.add("d");
        strList.add("e");
        strList.add("f");
        strList.add("g");
        strList.add("h");
        strList.add("i");
        strList.add("j");
        strList.add("k");
        strList.add("l");
        System.out.println(strList.size());

        for(String str : strList) {
            System.out.print(str + " ");
        }
        System.out.println();

        System.out.println(strList.get(9));
        System.out.println("================================");

        // interface 타입을 쓰면 코드가 좀더 유연해 진다.
        // Vector로 생성하든 ArrayList로 생성하든 하부 내용을 수정하지 않아도 된다.
        List<String> list  = new Vector<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        for(String str : list) {
            System.out.print(str + " ");
        }
    }
}
