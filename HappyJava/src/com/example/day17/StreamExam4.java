package com.example.day17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamExam4 {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Banana", "Apple", "Orange", "Cherry");
        List<String> sortedFruits = fruits.stream().sorted().toList();
        System.out.println(sortedFruits);
        // 내림차순 정렬
        // Comparator.reverseOrder() 사용
        List<String> revSortedFruits = fruits.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(revSortedFruits);

        System.out.println("\n===============================\n");

        int[] iarr = {5,3,27,9,5,9,0,4,34};
        // 위 배열을 오름차순으로 정렬
        List<Integer> sortedIarr = Arrays.stream(iarr).sorted().boxed().toList();
        System.out.println(sortedIarr);
        // 위 배열을 내림차순으로 정렬
        // Comparator.reverseOrder()를 쓰고싶지만, 대상이 되는 배열이 기본배열이기 때문에 기본 사용 불가능
        // 대상을 map을 통해 Integer로 변경하거나, 대상이 Array로 받던가, boxed()로 감싸서 기본 데이터 타입을 객체로 바꾼다.
        // 오토박싱이 이뤄져서 Comparator 사용 가능해짐
        List<Integer> revSortedIarr = Arrays.stream(iarr).boxed().sorted(Comparator.reverseOrder()).toList();
        System.out.println(revSortedIarr);

        System.out.println("\n===============================\n");

        int i = 10;
        Integer ii = i; // auto boxing

        int j = ii;  // auto unboxing
    }
}
