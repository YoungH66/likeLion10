package com.example.day08;

import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionExam11 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("abc");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 리소스를 괄호 안에 쓰기
        // 자동 리소스 닫기
        try(FileInputStream fis2 = new FileInputStream("abs")){
            // 처리할 로직..
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
