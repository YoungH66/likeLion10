package com.example.day17.exam;

import java.util.*;
import java.util.stream.Collectors;

class NewStudent {
    private String name;
    private int age;
    private int score;

    public NewStudent(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}
public class Exam6 {
    public static void main(String[] args) {
        List<NewStudent> students = Arrays.asList(
                new NewStudent("Alice", 14, 88),
                new NewStudent("Bob", 23, 82),
                new NewStudent("Charlie", 17, 95),
                new NewStudent("David", 21, 73)
        );

        Map<Integer, Double> avgScr = students.stream()
                .collect(Collectors.groupingBy(
                        s -> (s.getAge() / 10) * 10,
                        Collectors.averagingInt(NewStudent::getScore)
                ));

        avgScr.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
