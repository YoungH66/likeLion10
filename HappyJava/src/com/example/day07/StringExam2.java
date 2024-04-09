package com.example.day07;

import javax.sound.midi.Soundbank;

public class StringExam2 {
    public static void main(String[] args) {
        String str = "java Programming";

        System.out.println(str.charAt(3));  //charAt은 몇번째 인덱스에서 가져올건지
        System.out.println(str.substring(5));   //substring은 인덱스 몇번부터 몇번까지
        System.out.println(str.substring(5, 12));

        String str2 = "            abc            ";   // 공백이 포함된 문자열
        if("abc".equals(str2)) System.out.println("eq same");
        else System.out.println("eq different");

        if("abc".equals(str2.trim())) System.out.println("eq same");    // trim으로 앞뒤 공백 제거
        else System.out.println("eq different");

    }
}
