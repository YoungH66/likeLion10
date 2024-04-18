package com.example.day13;

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
        t1.start();
        t2.start();
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
