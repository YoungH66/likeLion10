package com.example.day13;

public class WaitNotifyExample2 {
    private static final Object lock = new Object();
    private static int itemAvailable = 0;   // 사용 가능 아이템 개수

    static class Producer extends Thread{
        public void run() {
            synchronized(lock) {
                System.out.println("The manufacturer is currently producing items..");
                itemAvailable += 5; // 아이템 5개 생산
                System.out.println("The manufacturer has produced " + itemAvailable + " items.");
                lock.notifyAll();      // 생산완료. 소비자에게 알림
                System.out.println("Production completed. Notification sent All.");
            }
        }
    }

    static class Consumer extends Thread{
        private int id;

        public Consumer(int id) {
            this.id = id;
        }

        public void run() {
            synchronized (lock){        //lock의 소유권을 가짐
                while(itemAvailable <= 0){  // 아이템이 하나 이상 있을때
                    try{
                        System.out.println("Consumer ID " + id + " is waiting for the item..");
                        lock.wait();    // 아이템을 기다림, wait하면 lock의 소유권을 포기함.
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    itemAvailable --;   // 아이템 소비
                    System.out.println("Consumer ID " + id + " has consumed the item");
                    System.out.println("left item: " + itemAvailable + "ea");
                }
            }
        }
    }

    public static void main(String[] args) {
        Producer p =  new Producer();
        Consumer c1 =  new Consumer(1);
        Consumer c2 =  new Consumer(2);
        Consumer c3 =  new Consumer(3);

        // 소비자 스레드 시작
        c1.start();
        c2.start();
        c3.start();

        try{
            Thread.sleep(1000); // 생산자 시작 전에 잠시 대기
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        p.start();  // 생산자 스레드 시작
    }
}
