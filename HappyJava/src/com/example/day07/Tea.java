package com.example.day07;

public class Tea extends BeverageRecipe{
    @Override
    void brew() {
        System.out.println("찬장에서 말린 찻잎통을 가져와 뜨거운 물에 한스쿱 넣는다.");
        System.out.println("찻잎이 뜨거운 물에 닿자, 잉크처럼 검붉은 색이 퍼져나간다.");
        System.out.println("은근한 향이 도는듯 하다.");
    }

    @Override
    void addCondiments() {
        System.out.println("말린 레몬 조각을 더한다.");
    }
}
