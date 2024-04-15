package com.example.day10;

public class Pair <KEY, VALUE>{
    private KEY key;
    private VALUE value;

    public Pair(KEY key, VALUE value) {
        this.key = key;
        this.value = value;
    }

    public KEY getKey() {
        return key;
    }

    public void setKey(KEY key) {
        this.key = key;
    }

    public VALUE getValue() {
        return value;
    }

    public void setValue(VALUE value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String, Integer>("key", 20);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}
