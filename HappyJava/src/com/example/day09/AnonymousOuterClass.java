package com.example.day09;

public class AnonymousOuterClass {
    private int outerField = 12;

    public void outerMethod(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("outerField = " + outerField);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
    public static void main(String[] args) {
        AnonymousOuterClass anonymousOuterClass = new AnonymousOuterClass();
        anonymousOuterClass.outerMethod();
    }
}
