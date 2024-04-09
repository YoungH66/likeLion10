package com.example.day07.foodOrder;

abstract public class Order {
    abstract public void prepareFood();
    abstract public void serveFood();
    final void completeOrder(){
        prepareFood();
        serveFood();
        System.out.println("Order Complete!");
    }

}
