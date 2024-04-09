package com.example.day07;

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        BeverageRecipe tea = new Tea();
        tea.prepareRecipe();

        System.out.println();

        BeverageRecipe coffee = new coffee();
        coffee.prepareRecipe();
    }
}
