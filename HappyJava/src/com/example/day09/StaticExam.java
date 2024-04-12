package com.example.day09;

public class StaticExam {
    int i = 10;
    static int j = 20;

    public void m1(){
        System.out.println(i);
        System.out.println(j);
        m2();
    }
    public static void m2(){
        // System.out.println(i); 불가능
        System.out.println(j);
        // m1(); 불가능
    }
}
