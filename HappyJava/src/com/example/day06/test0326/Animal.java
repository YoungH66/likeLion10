package com.example.day06.test0326;
public class Animal {
    public void makeSound(){
        System.out.println("??");
    }

    public static void main(String[] args) {
        Animal creture = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        creture.makeSound();
        dog.makeSound();
        cat.makeSound();
    }
}
class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("야옹");
    }
}
