package com.example.day07;

abstract public class Shape implements Drawable{
    abstract public double calculateArea();
}

class Triangle extends Shape implements Drawable{
    private double x;
    private double y;
    public Triangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calculateArea() {
        double area = (x * y) /2;
        return area;
    }
}

class Rectangle extends Shape implements Drawable{
    private double x;
    private double y;
    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calculateArea() {
        double area = (x * y);
        return area;
    }

    public void draw() {
        System.out.println("this shape is Rectangle");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
