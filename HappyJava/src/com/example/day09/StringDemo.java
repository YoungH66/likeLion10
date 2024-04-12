package com.example.day09;

public class StringDemo {
    public static void main(String[] args) {
        String greeting = "Hello, World";
        System.out.println("String length : " + greeting.length());
        System.out.println("5th of the Sting : " + greeting.charAt(4));
        System.out.println("substring 7, 12 : " + greeting.substring(7, 12));

        String str1 = "Java";
        String str2 = "JAVA";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
    }
}
