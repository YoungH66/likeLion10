package com.example.day08;

public class MyException extends RuntimeException{
    public MyException() {
        super("score range :: 0 ~ 100");
    }

    public MyException(String message) {
        super(message);
    }
}
