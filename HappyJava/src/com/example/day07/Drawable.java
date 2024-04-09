package com.example.day07;

public interface Drawable {
    default public void draw(){
        System.out.println("draw shape");
    }
}
