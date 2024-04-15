package com.example.day10;

import com.example.day09.Book;

public class GenericPairDemo {
    public static void main(String[] args) {
        // 생성되는 시점에 정해진다.
        GenericPair<String, Integer> pair = new GenericPair<>("hello", 1);

        // 형변환 필요하지 않다.
        String first = pair.getFirst();
        int second = pair.getSecond();

        GenericPair<Book, String> pair2 = new GenericPair<>(new Book("모두의 자바"), "Kim");
        Book book = pair2.getFirst();
        String name = pair2.getSecond();
    }
}
