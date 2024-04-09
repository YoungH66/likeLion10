package com.example.day07.interfaceTest;

public class MyCalculator implements Calculator{
    @Override
    public int plus(int i, int j) {
        return i + j;
    }

    @Override
    public int multiple(int i, int j) {
        return i * j;
    }
}
