package com.example.day08;

public class ExceptionExam04 {
    public static void errand() {
        System.out.println("errand start");

        int i = 0;
        try {
            System.out.println(10 / i);
        } catch (Exception e){
            System.out.println("looking for other option...");
            System.out.println(e);
        }

        System.out.println("errand end");
    }

    public static void main(String[] args) {
        errand();
    }
}

