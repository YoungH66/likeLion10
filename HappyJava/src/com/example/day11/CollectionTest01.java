package com.example.day11;

import java.util.*;

public class CollectionTest01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // 숫자 추가
        int[] nums = {1, 2, 3, 5, 2, 4, 5};
        for(int num : nums) {
            list.add(num);
            set.add(num);
        }

        System.out.println("list : " + list);
        System.out.println("set : " + set);
    }
}
