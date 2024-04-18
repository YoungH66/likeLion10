package com.example.day13;

public class RunnableExample implements Runnable{
    String name;

    public RunnableExample(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("new Thread start...");
        for(int i = 0; i < 100; i++) {
            System.out.println(name + " Thread is running : " + i);
        }
        System.out.println("new Thread end...");
    }

    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t1 = new Thread(new RunnableExample("t1"));
        Thread t2 = new Thread(new RunnableExample("t2"));
        t1.start();
        t2.start();
        System.out.println("main end...");
    }
}
