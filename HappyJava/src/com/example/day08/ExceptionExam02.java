package com.example.day08;

public class ExceptionExam02 {
    public static void main(String[] args) {
        System.out.println("Program start...");

        // args = [0, 1, 2, 3, 4]
        int i = Integer.parseInt(args[0]);

        try {
            System.out.println(10/i);
        }catch (Exception e){
            System.out.println("err :: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Program end...");
    }
}
