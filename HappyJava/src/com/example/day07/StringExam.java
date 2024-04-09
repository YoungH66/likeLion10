package com.example.day07;

public class StringExam {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello");

        if(str1 == str2) System.out.println("same");
        else System.out.println("different");

        if(str1 == str3) System.out.println("same");
        else System.out.println("different");

        // String은 equals를 override를 한다.
        if(str1.equals(str4)) System.out.println("eq same");
        else System.out.println("eq different");

        System.out.println(str1.concat(" etc String.."));
        System.out.println(str1);   // concat은 원본이 수정되는것이 아니다. String저장공간에 새로운 문자열이 저장되고 기본적으로 가르킬 뿐이다.
        System.out.println(str1 = str1.concat(" etc String.."));    // 어사인해주면 수정 가능
        System.out.println(str1);
    }
}
