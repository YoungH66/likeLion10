package com.example.day07.foodOrder;

public class CreditPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("Pay by... Credit Card");
        System.out.println("Process All done");
        System.out.println("Thank You");
    }
}
