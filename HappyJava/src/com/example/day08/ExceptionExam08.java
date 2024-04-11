package com.example.day08;

import java.io.FileReader;
import java.io.IOException;

public class ExceptionExam08 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("nonexistentfile.txt");
            // 파일 읽기 로직
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
