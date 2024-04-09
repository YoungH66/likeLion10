package com.example.day07;

public abstract class BeverageRecipe {

    public final void prepareRecipe() {
        boliWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();
    public void boliWater() {
        System.out.println("boling water");
    }
    public void pourInCup() {
        System.out.println("pour in the cup");
    }
}
