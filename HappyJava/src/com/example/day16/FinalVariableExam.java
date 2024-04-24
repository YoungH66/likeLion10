package com.example.day16;

public class FinalVariableExam {
    public static void main(String[] args) {
        final int x = 10;
        System.out.println("람다에서 파이널로 사용");

        Runnable l = () -> {
            System.out.println("x : " + x);
        };

        l.run();
    }
}
