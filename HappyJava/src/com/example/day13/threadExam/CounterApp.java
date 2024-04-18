package com.example.day13.threadExam;

class IncrementCounter implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            System.out.println("Increment: {"+ i + "}");
            try {
                Thread.sleep((long)(Math.random() * 11));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class DecrementCounter implements Runnable {
    @Override
    public void run() {
        for(int i = 100; i >= 1; i--) {
            System.out.println("Decrement: {"+ i + "}");
            try {
                Thread.sleep((long)(Math.random() * 11));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class CounterApp {
    public static void main(String[] args) {
        Thread incrementThread = new Thread(new IncrementCounter());
        Thread decrementThread = new Thread(new DecrementCounter());

        incrementThread.start();
        decrementThread.start();
    }
}
