package com.example.day08;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionExam07 {
    public static void main(String[] args) {
        try {
            // "example.txt" 파일을 읽기 위한 FileReader 객체 생성
            FileReader reader = new FileReader("example.txt");
            // 파일 읽기 작업 수행 (이 예제에서는 구체적인 읽기 작업은 생략)
            // ...
            // FileReader 객체 닫기
            reader.close();
        } catch (FileNotFoundException e) {
            // 파일이 존재하지 않을 경우 예외 처리
            System.out.println("파일을 찾을 수 없습니다: " + e.getMessage());
        } catch (Exception e) {
            // 기타 예외 처리
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

}
