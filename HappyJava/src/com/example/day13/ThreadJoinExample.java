package com.example.day13;

class DemonThread extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println("Now playing Background music...");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadJoinExample {
    static class TaskThread extends Thread {
        private String taskName;

        public TaskThread(String taskName) {
            this.taskName = taskName;
        }

        public void run() {
            System.out.println(taskName + " is running");
            try {
                Thread.sleep(2000); // 2초간 정지
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(taskName + " is finished");
        }
    }
    public static void main(String[] args) {
        TaskThread t1 = new TaskThread("t1");
        TaskThread t2 = new TaskThread("t2");

        DemonThread dt = new DemonThread();

        t1.start();
        t2.start();

        // 데몬스레드로 사용한다고 함
        // 원래는 스레드가 종료되지 않지만, 데몬스레드로 사용하면 주 스레드가 끝남에 따라 종료됨.
        dt.setDaemon(true);
        dt.start();
        try{
            System.out.println("Waiting for task to finish");
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("All tasks finished");
    }
}
