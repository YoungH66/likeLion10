package com.example.day07.interfaceTest;

public interface Animal {
    default public void speak(){
        System.out.println("Something howling..");
    }
}
