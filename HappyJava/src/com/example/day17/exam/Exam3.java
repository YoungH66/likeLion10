package com.example.day17.exam;

import java.util.*;

class Student {
    public static final int MALE = 0;
    public static final int FEMALE = 1;

    private String name;
    private int age;
    private int score;
    private int gender;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}
public class Exam3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        List<String> list80 = students.stream() // students stream 사용
                .filter(s -> s.getScore() >= 80)    // filter score가 80 이상일때
                .map(Student::getName)  // map을 사용하여 각 요소를 함수에 따라 변환. 이 경우 80 이상일때 이름을 가져옴
                .sorted()   // 정렬
                .toList();  // list로 저장. 최종연산
        System.out.println(list80);
    }
}
