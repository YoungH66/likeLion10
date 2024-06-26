package com.example.day10.box;

public class Box <T>{
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Box\tcontaining : " + content;
    }

    public static void main(String[] args) {
        Box<String> box = new Box<String>("pen");
        System.out.println(box.getContent());
        System.out.println(box);
    }
}
