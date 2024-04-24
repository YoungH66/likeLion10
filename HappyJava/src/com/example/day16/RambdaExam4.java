package com.example.day16;

import java.util.function.*;
import java.util.*;

public class RambdaExam4 {
    public static void main(String[] args) {
        // 메소드 참조 ::
        // 1. 정적 메소드 참조
//        BiFunction<Integer, Integer, Integer> maxFunc = (a, b) -> Math.max(a, b);
        BiFunction<Integer, Integer, Integer> maxFunc = Math::max;
        System.out.println(maxFunc.apply(1, 2));

        // 2. 인스턴스 메소드 참조
        String str = "Hello world!";
        Supplier<Integer> lenFunc = str::length;
        System.out.println(lenFunc.get());

        // 3. 임의 객체의 인스턴 메소드 참조
        List<String> words = Arrays.asList("Hello", "world", "java", "YoungH");
        List<Integer> lens = new ArrayList<>();
        Function<String, Integer> lenFunc2 = String::length;

        for(String word : words){
            lens.add(lenFunc2.apply(word));
        }
        System.out.println(lens);

        // 4. 생성자 참조
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> list = listSupplier.get();
        list.add("heelo");
        list.add("hahaha");
        list.add("yh");
        System.out.println(list);
    }
}
