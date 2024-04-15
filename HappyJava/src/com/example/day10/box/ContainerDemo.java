package com.example.day10.box;

public class ContainerDemo {
    public static void main(String[] args) {
        Container<String> strContainer = new Stringcontainer();
        strContainer.set("Hello, Generics");
        System.out.println("String Container : " + strContainer.get() );

        Container<Integer> intContainer = new IntegerContainer();
        intContainer.set(10);
        System.out.println("Integer Container : " + intContainer.get() );
    }
}
