package com.example.day13.robot;

public class Robot {
    public synchronized void leftLegActive(){
        System.out.println("took a left step..");
        for(int i = 1; i <= 5; i++){
            System.out.println("..left leg activated..");
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("step on..");
    }

    public synchronized void rightLegActive(){
        System.out.println("took a right step..");
        for(int i = 1; i <= 5; i++){
            System.out.println("..right leg activated..");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("step on..");
    }

    public void scannerActive() {
        for(int i = 1; i <= 5; i++){
            System.out.println("\t\tscanner activated..");
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
