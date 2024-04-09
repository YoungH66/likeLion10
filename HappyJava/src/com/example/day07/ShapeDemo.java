package com.example.day07;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape triangle = new Triangle(10, 5);
        System.out.println("삼각형의 너비: " + triangle.calculateArea());

        Shape rectangle = new Rectangle(10, 20);
        System.out.println("사각형의 너비: " + rectangle.calculateArea());

        Shape circle = new Circle(30);
        System.out.printf("원의 너비: %.3f\n",circle.calculateArea());
    }
}