package com.example.day09;

public class OuterClass {
    private int outerField = 10;
    private InnerClass innerClass;

    public void outerMethod() {
        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }

    // 내부클래스
    class InnerClass {
        public void innerMethod() {
            System.out.println("outerFiled = " + outerField);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        outer.outerMethod();
    }
}
