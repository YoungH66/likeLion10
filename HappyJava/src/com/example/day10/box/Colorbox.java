package com.example.day10.box;

public class Colorbox<T, C> extends Box<T> {
    private C color;

    public Colorbox(T content, C color) {
        super(content);
        this.color = color;
    }

    public C getColor() {
        return color;
    }

    public void setColor(C color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Colored box with color " + color + " containing : " + getContent();
    }

    public static void main(String[] args) {
        SpecialBox<String> specialBox = new SpecialBox<>("Hello World");
        specialBox.printContent(); // 출력: Special box contains: Hello World
        Colorbox<String, String> coloredBox = new Colorbox<>("Hello World", "Red");
        System.out.println(coloredBox); // 출력: Colored box with color Red containing: Hello World
    }
}
