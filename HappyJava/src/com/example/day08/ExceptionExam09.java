package com.example.day08;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExam09 {
    // 학생의 점수를 입력받는 메소드

    public void inputScore(int score){
        if(score > 100 || score < 0){
            // throw new MyException("worng number : " + score);
            throw new MyException();
        }

        System.out.println(score);
    }

    public static void main(String[] args) {
        ExceptionExam09 ex = new ExceptionExam09();
        Scanner sc = new Scanner(System.in);

        System.out.print("input score : ");
        try {
            ex.inputScore(sc.nextInt());
        }catch (MyException e){
            System.out.println(e.getMessage());
        }

        System.out.println("main done =====");
    }
}
