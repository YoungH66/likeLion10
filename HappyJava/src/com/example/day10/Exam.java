package com.example.day10;

import com.example.day02.Book;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    public static void main(String[] args) {
        //list는 object를 받는다.
        List li  = new ArrayList();
        li.add("test");
        li.add(10);
        li.add(new Book());

        System.out.println(li);
    }
}
