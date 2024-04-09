package com.example.day07;

abstract public class Shape {
    abstract public double calculateArea();
}

class Triangle extends Shape {
    private double x;
    private double y;
    public Triangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calculateArea() {
        double area = (x * y);
        return area;
    }
}

class Rectangle extends Shape {
    private double x;
    private double y;
    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double calculateArea() {
        double area = (x * y) / 2;
        return area;
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
