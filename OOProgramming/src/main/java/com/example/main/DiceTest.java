package com.example.main;

import com.example.util.Dice;

import java.util.Scanner;

public class DiceTest {
    public static void main(String[] args) {
        Dice dice = new Dice();
        Scanner sc = new Scanner(System.in);

        System.out.print("굴릴 주사위의 눈을 입력 : ");
        int n = sc.nextInt();
        dice.setFace(n);

        System.out.println("주사위 결과 ... " + dice.roll());
    }
}
