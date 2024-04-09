package com.example.day07;

public class DImpl implements Dinter{
    @Override
    public void aMethod() {
        System.out.println("aMethod()");
    }

    @Override
    public void bMethod() {
        System.out.println("bMethod()");
    }

    @Override
    public void cMethod() {
        System.out.println("cMethod()");
    }

    @Override
    public void same() {
        System.out.println("same()");
    }

    @Override
    public void dMethod() {
        System.out.println("dMethod()");
    }
}
