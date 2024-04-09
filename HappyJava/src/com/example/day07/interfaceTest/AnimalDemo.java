package com.example.day07.interfaceTest;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.speak();
        cat.speak();
    }
}
