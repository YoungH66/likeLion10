package com.example.day07.foodOrder;

public class PizzaOrder extends Order{
    @Override
    public void serveFood() {
        System.out.println("serve the Pizza");
    }

    @Override
    public void prepareFood() {
        System.out.println("Pizza ready");
    }
}
