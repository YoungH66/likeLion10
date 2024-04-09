package com.example.day07.foodOrder;

public class CashPayment implements Payment{
    @Override
    public void processPayment() {
        System.out.println("Pay by... Cash");
        System.out.println("Process All done");
        System.out.println("Thank You");
    }
}
