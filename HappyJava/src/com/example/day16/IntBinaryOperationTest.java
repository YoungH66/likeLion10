package com.example.day16;

import java.util.function.IntBinaryOperator;


class sum implements IntBinaryOperation {
    @Override
    public int apply(int a, int b){
        return a+b;
    }
}

public class IntBinaryOperationTest {
    public static void main(String[] args) {
        IntBinaryOperation test = new IntBinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return 0;
            }
        };

        IntBinaryOperation test2 = (a, b) -> 0;

        IntBinaryOperation add = (a, b) -> a + b;

        IntBinaryOperation sub = (a, b) -> a - b;
        IntBinaryOperation mul = (a, b) -> a * b;
        IntBinaryOperation div = (a, b) -> a / b;
        IntBinaryOperation mod = (a, b) -> a % b;
        IntBinaryOperation max = (a, b) -> a > b ? a : b;
        IntBinaryOperation min = (a, b) -> a < b ? a : b;

        System.out.println(test.apply(1, 2));
        System.out.println(test2.apply(1, 2));
        System.out.println(add.apply(1, 2));
        System.out.println(sub.apply(1, 2));
        System.out.println(mul.apply(1, 2));
        System.out.println(div.apply(1, 2));
        System.out.println(max.apply(1, 2));
        System.out.println(min.apply(1, 2));
        System.out.println(mod.apply(1, 2));

    }
}
