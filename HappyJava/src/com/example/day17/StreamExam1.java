package com.example.day17;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamExam1 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("asdf", "bes", "cbx", "aaserd", "esdfa", "fear", "gfz", "asdfh");

        // .collect(Collectors.toList()) -> .toList()
        List<String> fileredList = myList.stream().filter(s -> s.startsWith("a")).toList();
        System.out.println(fileredList);
        // 스트림을 쓰지 않았을 경우
        List<String> nonStreamList = new ArrayList<>();
        for(String s : myList){
            if(s.startsWith("a"))
                nonStreamList.add(s);
        }
        System.out.println(nonStreamList);

        System.out.println("====================");

        // 스트림을 쓰지 않을 경우
        String[] names = {"kang", "kim", "hong", "lee", "son", "park"};
        for(String name : names){
            System.out.println(name);
        }
        System.out.println();
        // 스트림 사용
        Arrays.stream(names).forEach(System.out::println);
        // 아래와 같다.
        // Arrays.stream(names).forEach(name -> System.out.println(name));
        /*Arrays.stream(names).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/

        int[] iarr = {1, 2, 3, 4, 5, 6, 7, 8};
        // 짝수만 출력
        Arrays.stream(iarr).filter(n -> n % 2 == 0).forEach(System.out::println);
        // 스트림 없이
        /*List<Integer> nonSteamiarr = new ArrayList<>();
        for(int n : iarr){
            if(n % 2 == 0)
                nonSteamiarr.add(n);
        }
        System.out.println(nonSteamiarr);*/

    }
}
