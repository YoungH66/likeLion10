package com.example.day07.interfaceTest;

public class MyCalculatorExam {
    public static void main(String[] args) {
        Calculator cal = new MyCalculator();
        int value = cal.exec(5, 10);
        System.out.println(value);
    }
}
