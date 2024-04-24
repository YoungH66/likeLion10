package com.example.day16.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Exam5 {
    static Supplier<Integer> ranInt = () -> (int) (Math.random() * 100) + 1;
    static UnaryOperator<Integer> sqr = x -> x * x;

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        List<Integer> sqrList = new ArrayList<>();

        for(int i = 0; i < ranInt.get(); i++){
            numList.add(ranInt.get());
        }

        // 람다식 이용
        numList.forEach(num -> sqrList.add(sqr.apply(num)));
        System.out.println(numList);
        System.out.println(sqrList);
    }
}
