package com.example.day16.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Exam3 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> newNums = new ArrayList<>();

        // 매개변수는 없고 반환값만 있을때 사용
        Supplier<Integer> ranInt = () -> (int) (Math.random() * 100) + 1;

        for(int i = 0; i < ranInt.get(); i++) {
            nums.add(ranInt.get());
        }
        System.out.println(nums);

        // forEach로 각 요소에 접근해 10을 더한값을 새로운 배열에 저장
        nums.forEach(num -> newNums.add(num + 10));
        System.out.println(newNums);
    }
}
