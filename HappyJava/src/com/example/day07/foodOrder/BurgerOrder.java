package com.example.day07.foodOrder;

public class BurgerOrder extends Order{
    @Override
    public void prepareFood() {
        System.out.println("Burger ready");
    }

    @Override
    public void serveFood() {
        System.out.println("serve the burger");
    }
}
