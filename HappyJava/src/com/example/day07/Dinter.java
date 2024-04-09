package com.example.day07;
// 자바는 단일상속이지만, 인터페이스 간에는 다중 상속이 가능하다.
public interface Dinter extends Cinter, Binter{
    public void dMethod();
}
