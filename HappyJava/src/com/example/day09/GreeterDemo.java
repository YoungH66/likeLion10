package com.example.day09;

public class GreeterDemo {
    public static void main(String[] args) {
        Greeter morningGreeter = new Greeter() {
            @Override
            public void greet() {
                System.out.println("Good Morning");
            }
        };

        Greeter eveningGreeter = new Greeter() {
            @Override
            public void greet() {
                System.out.println("Good Evening");
            }
        };

        morningGreeter.greet();
        eveningGreeter.greet();
    }
}
