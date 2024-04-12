package com.example.day09;

public class StringExam3 {
    //문자열을 입력받아서 역순의 문자열로 바꾸어서 문자열을 리턴하는 메소드 ex) abc - > cda
    public static String reverseChange(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseChange("abc")); //cba

        StringBuilder builder = new StringBuilder("Hello");

        builder.append(" World"); // 문자열 추가
        builder.insert(6, "Java "); // 특정 위치에 문자열 삽입
        System.out.println(builder); // 출력: Hello Java World

        builder.delete(6, 11); // 특정 부분 삭제
        System.out.println(builder); // 출력: Hello World

        builder.reverse(); // 문자열 뒤집기
        System.out.println(builder); // 출력: dlroW olleH
    }
}
