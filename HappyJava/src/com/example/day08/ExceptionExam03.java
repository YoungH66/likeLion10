package com.example.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionExam03 {
    public static void main(String[] args) {
        // FileNotFoundException 발생. runtime이 아님.
        // FileInputStream fis = new FileInputStream("abc");

        try {
            FileInputStream fis = new FileInputStream("abc");
        }catch (FileNotFoundException e){
            e.getMessage();
        }

        // runtime, nullporinterexception 발생
        int[] arr = null;
        arr[0] = 10;
    }
}
