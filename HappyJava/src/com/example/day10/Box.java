package com.example.day10;

public class Box <V>{
    private V value;

    public Box(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Box<String> box = new Box<String>("Hello");
        System.out.println(box.getValue());
    }
}
