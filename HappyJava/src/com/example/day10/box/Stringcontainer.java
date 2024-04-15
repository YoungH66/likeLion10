package com.example.day10.box;

public class Stringcontainer implements Container<String>{
    private String value;

    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }
}
