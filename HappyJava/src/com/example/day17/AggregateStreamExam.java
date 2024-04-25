package com.example.day17;

import java.util.Arrays;
import java.util.OptionalInt;

public class AggregateStreamExam {
    public static void main(String[] args) {
        int[] intArr = {12,36,53,35,66,57};

        long count = Arrays.stream(intArr).boxed().count(); // 요소 개수
        // orElse는 비교적 최근 추가된 기능으로 null을 처리하기 위한 목적으로 제공된다.
        // or를 확인해보자. optional
        int max = Arrays.stream(intArr).boxed().max(Integer::compareTo).orElse(0);
        int min = Arrays.stream(intArr).boxed().min(Integer::compareTo).orElse(0);
        double avg = Arrays.stream(intArr).average().orElse(0.0);   // 평균 값
        int sum = Arrays.stream(intArr).sum();// 총합

        System.out.println(count);
        System.out.println(max);
        System.out.println(min);
        System.out.println(avg);
        System.out.println(sum);

        long count2 = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("배열의 요소 수:" + count2);

        long sum2 = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("배열의 합계:" + sum2);

        int min2 = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .filter(n -> n % 2 == 0)
                .min()
                .getAsInt();
        System.out.println("배열의 최소값:" + min2);

        OptionalInt minOptional = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .filter(n -> n % 2 == 0)
                .min();

        if (minOptional.isPresent()) {
            int min3 = minOptional.getAsInt();
            System.out.println("Minimum even number: " + min3);
        } else {
            System.out.println("No even numbers found.");
        }


        double avg2 = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6})
                .filter(n -> n % 2 == 0)
                .average()
//                .getAsDouble();
                .orElse(Double.NaN);
        System.out.println("배열의 평균값:" + avg2);
    }
}
