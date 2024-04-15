package com.example.day10;

public class NonGenericPairDemo {
    public static void main(String[] args) {
        NonGenericPair pair = new NonGenericPair("Hello", 5);
        String first  = (String) pair.getFirst();       // object, 형변환 필요
        Integer second = (Integer) pair.getSecond();    // object, 형변환 필요

        NonGenericPair pair2 = new NonGenericPair(1.2f, "hello");
        float firstFloat = (float) pair.getFirst();
    }
}
