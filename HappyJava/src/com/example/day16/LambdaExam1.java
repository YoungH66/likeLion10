package com.example.day16;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExam1 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "orange");

        Consumer<String> lambdaTest = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        // 아래 셋은 같은 역할을 한다.
        items.forEach(item -> System.out.println(item));

        items.forEach(lambdaTest);

        items.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 lambda start..");
            }
        }).start();

        new Thread(() -> System.out.println("Thread2 lambda start.")).start();
    }


}
