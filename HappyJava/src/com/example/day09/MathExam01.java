package com.example.day09;

public class MathExam01 {
    public static void main(String[] args) {
        int maxNum = Math.max(10, 20);
        int minNum = Math.min(10, 20);
        double sqrtNum = Math.sqrt(16);
        double powNum = Math.pow(2, 3);

        System.out.println("maxNum = " + maxNum);
        System.out.println("minNum = " + minNum);
        System.out.println("sqrtNum (16) = " + sqrtNum);
        System.out.println("powNum (2, 3) = " + powNum);

        double randomNum = Math.random(); // 0.0 ~ 1.0
        System.out.println("randomNum = " + randomNum);
        randomNum = Math.random() * 100 + 1; // 1.0 ~ 100.0
        System.out.println("randomNum = " + randomNum);
        System.out.println("randomNum = " + (int) randomNum);
    }
}
