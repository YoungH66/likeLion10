package com.example.day13;

// MyRunnable은 Thread는 아니다.
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("\tMyRunnable is running");
        for(int i = 0; i < 100; i++) {
            System.out.println("\thello Runnable");
        }
        System.out.println("\tMyRunnable done");
    }
}

class SubRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("\t\tSubRunnable is running");
        for(int i = 0; i < 100; i++) {
            System.out.println("\t\thello SubRunnable");
        }
        System.out.println("\t\tSubRunnable done");
    }
}

public class RunnableExam {
    public static void main(String[] args) {
        System.out.println("main...");

        // Thread 생성, Runnable을 인자로 가질 수 있다.
        Thread t1 = new Thread(new MyRunnable());
        // Thread 실행
        t1.start();

        Thread t2 = new Thread(new SubRunnable());
        t2.start();

        for(int i = 0; i < 100; i++) {
            System.out.println("Hello main");
        }

        System.out.println("main done");
    }
}
