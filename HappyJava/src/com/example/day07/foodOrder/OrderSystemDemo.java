package com.example.day07.foodOrder;

public class OrderSystemDemo {
    public static void main(String[] args) {
        Order pizza = new PizzaOrder();
        pizza.completeOrder();
        Payment card = new CreditPayment();
        card.processPayment();

        System.out.println();

        Order burger = new BurgerOrder();
        burger.completeOrder();
        Payment cash = new CashPayment();
        cash.processPayment();
    }
}
