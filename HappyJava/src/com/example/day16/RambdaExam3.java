package com.example.day16;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class RambdaExam3 {
    public static void main(String[] args) {
        // Predicate
        // 조건을 테스트하는데 사용. boolean 반환
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-10));

        // Consumer
        // 입력을 받고 반환값이 없는 연산을 수행
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("Hello");

        // Function
        // 입력을 받아서 출력을 반환한다.
        Function<String, Integer> lenFunc = s -> s.length();
        System.out.println(lenFunc.apply("hello there"));

        // Supplier
        // 입력 없이 값을 반환
        Supplier<Double> ranSupplier = () -> Math.random();
        System.out.println(ranSupplier.get());

        IntSupplier intSupplier = () -> (int)(Math.random() * 6) + 1;
        System.out.println(intSupplier.getAsInt());
    }

}
