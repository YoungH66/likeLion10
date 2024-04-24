package com.example.day16.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exam6 {
    static Supplier<Integer> ranInt = () -> (int) (Math.random() * 10) + 1;
    static Predicate<Integer> isEven = i -> i % 2 == 0;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> oddList = new HashSet<>();

        for(int i = 0; i < ranInt.get(); i++){
            list.add(ranInt.get());
        }
        System.out.println(list);

        // .forEach는 break가 안되서 포기
        /*list.forEach(num -> {
            if(!isEven.test(num)) {
                System.out.println("짝수가 아닌 숫자가 있습니다.");
                System.out.println("짝수가 아닌 숫자 : " + num);
            }else
                System.out.println("모든 숫자가 짝수입니다.");
        });*/

        boolean hasNonEven = false;
        for(int num : list){
            if(!isEven.test(num)){
                hasNonEven = true;
                oddList.add(num);
            }
        }

        if(!hasNonEven){
            System.out.println("모든 숫자가 짝수입니다.");
        }else{
            System.out.println("짝수가 아닌 숫자가 있습니다.");
            System.out.println("짝수가 아닌 숫자 : " + oddList);
        }
    }
}
