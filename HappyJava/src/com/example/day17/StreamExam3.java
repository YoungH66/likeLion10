package com.example.day17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExam3 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");
        // 글자수가 5 이상인 것만 추출, 중복은 제거해서 새로운 리스트로 저장
        List<String> bigWords = words.stream().filter(s -> s.length() >= 5).distinct().toList();
        System.out.println(bigWords);
        // 스트림 없이
        /*Set<String> tmp = Set.copyOf(words);
        List<String> resutl = new ArrayList<>();
        for(String s : tmp){
            if(s.length() >= 5)
                resutl.add(s);
        }
        System.out.println(resutl);*/

        // word -> word.toUpperCase() 를 String::toUpperCase
        words.stream().map(String::toUpperCase).forEach(System.out::println);

        // 각 요소에 3을 곱해서 출력
        int[] intArr = {3, 6, 3, 76, 4, 2};
        Arrays.stream(intArr).map(n -> n * 3).forEach(System.out::println);
    }
}
