package com.example.day06;

public class Car {
    String name;
    int speed;

    /*public Car(){
        System.out.println("car() 생성자 호출...");
    }*/

    public Car(String name){
        this.name = name;
        System.out.println("Car(String name) 생성자 호출...");
    }

    public Car(int speed, String name){
        this.name = name;
        this.speed = speed;
        System.out.println("Car(int speed, String name) 생성자 호출...");
    }

    public Car(int speed){
        // this(speed, "");  // super를 제외하고 처음 오는 this는 this(...)와 같이 사용할 수 있다.
        this.speed = speed;
        System.out.println("Car(int speed) 생성자 호출...");
    }
}
