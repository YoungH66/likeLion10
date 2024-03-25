package com.example.main;

import com.example.util.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator ca = new Calculator();
        System.out.println(ca.plus(1, 4));
        System.out.println(ca.minus(4, 1));
    }
}
