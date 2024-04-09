package com.example.day07;

public abstract class 새 {
    // 부모 클래스 새 에 sing이라는 메소드는 직접 역할을 하지 않을텐데 굳이 선언해야 할까?
    // 자식의 부모되는 클래스는 표준이 잡혀있어야 한다. 따라서 쓰이지 않을 메소드도 표준을 위한것이면 정해주는것이 바람직하다.
    /*public void sing() {
        System.out.println(".. it's humming..");
    }*/
    // 직접 기능을 구현하지 않아도 abstract을 통해 선언할 수 있다.
    // abstract이 붙은것은 반드시 구현해야 한다.
    abstract public void sing();
}

class pigeon extends 새 {
    @Override
    public void sing(){
        System.out.println("999999999");
    }
}

class sparrow extends 새 {
    @Override
    public void sing(){
        System.out.println("짹짹");
    }
}

class crow extends 새
{
    @Override
    public void sing() {
        System.out.println("까악");
    }
}

// 자식도 추상클래스로 선언할 수 있다.
abstract class 앵무새 extends 새 {
    abstract public void 말하다();
}

class 코뉴어 extends 앵무새 {
    @Override
    public void sing() {

    }

    @Override
    public void 말하다() {

    }
}