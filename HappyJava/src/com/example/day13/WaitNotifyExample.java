package com.example.day13;

public class WaitNotifyExample {
    private static final Object lock = new Object();
    private static boolean itemAvailable = false;

    static class Producer extends Thread{
        public void run() {
            synchronized(lock) {
                System.out.println("The manufacturer is currently producing items..");
                itemAvailable = true;
                lock.notify();      // 생산완료. 소비자에게 알림
                System.out.println("Production completed. Notification sent.");
            }
        }
    }

    static class Consumer extends Thread{
        public void run() {
            synchronized (lock){        //lock의 소유권을 가짐
                while(!itemAvailable){
                    try{
                        System.out.println("The consumer is waiting for an item..");
                        lock.wait();    // 아이템을 기다림, wait하면 lock의 소유권을 포기함.
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("The consumer has consumed the item.");
                    itemAvailable = false;  // 아이템 소비 후 상태 업데이트
                }
            }
        }
    }

    public static void main(String[] args) {
        Producer p =  new Producer();
        Consumer c =  new Consumer();

        c.start();  // 소비자 스레드 시작
        try{
            Thread.sleep(1000); // 생산자 시작 전에 잠시 대기
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        p.start();  // 생산자 스레드 시작
    }
}
