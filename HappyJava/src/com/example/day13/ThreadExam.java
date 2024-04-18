package com.example.day13;

// 상속.. Thread를 상속받은 MyThread는 Thread이다.
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("\tMyThread is running");
        for(int i = 0; i < 100; i++) {
            System.out.println("\thello thread");
        }
        System.out.println("\tMyThread done");
    }
}

class SubThread extends Thread {
    @Override
    public void run() {
        System.out.println("\t\tSubThread is running");
        for(int i = 0; i < 100; i++) {
            System.out.println("\t\thello subThread");
        }
        System.out.println("\t\tSubThread done");
    }
}

public class ThreadExam {
    public static void main(String[] args) {
        System.out.println("main...");

        // Thread 생성
        MyThread t1 = new MyThread();
        // Thread 실행
        t1.start();

        SubThread t2 = new SubThread();
        t2.start();
        // start()가 아닌 run()은 그저 단일스레드로 실행되니 의미가 다르다.

        for(int i = 0; i < 100; i++) {
            System.out.println("Hello main");
        }

        System.out.println("main done");
    }
}
