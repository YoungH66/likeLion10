package com.example.day07;

public class coffee extends BeverageRecipe{
    @Override
    void brew() {
        System.out.println("필터를 통해 커피가 우러난다.");
    }

    @Override
    void addCondiments() {
        System.out.println("각설탕 2개와 우유를 살짝 더한다.");
    }
}
