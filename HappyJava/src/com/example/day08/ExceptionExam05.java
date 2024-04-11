package com.example.day08;

public class ExceptionExam05 {
    public static void errand() throws Exception{
        System.out.println("errand start");
        int i = 0;

        System.out.println(10 / i);
        System.out.println("errand end");
    }

    public static void main(String[] args) {
        try {
            errand();
        }catch (Exception e) {
            System.out.println("Suggest option");
        }
    }
}

