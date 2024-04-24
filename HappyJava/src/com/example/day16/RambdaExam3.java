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

        // UnaryOperator
        // 입력과 출력이 같은 타입의 값일 때 사용
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(6));

        // BiFunction
        // 두 개의 입력을 받고 하나의 결과를 반환
        BiFunction<Integer, Integer, Integer> addBi = (a, b) -> a + b;
        System.out.println(addBi.apply(1, 2));

        // Consumer 의 andThen 메소드
        // 입력만 받고 반환값이 없음
        Consumer<String> conA = s -> System.out.println(s + " a");
        Consumer<String> conB = s -> System.out.println(s + " b");
        conA.accept("young");
        conB.accept("young");

        Consumer<String> conAB = conA.andThen(conB);
        conAB.accept("kim");
    }

}
