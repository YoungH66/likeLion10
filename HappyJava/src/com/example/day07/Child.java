package com.example.day07;

public class Child extends Parent{
    // 상속받을때 자동으로 default 생성자가 생성되는데, 지금 부모는 default 생성자가 없기 때문에 오류가 발생한다.
    //      기본 생성자.
    //    public Child(){
    //        super();
    //    }

    // 부모의 생성자 기반으로 생성자 선언
    public Child(){
        super("no name", 0);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getName() {
        System.out.println("호출된 메소드는 자식클래스에서 구현한 getName()입니다.");
        return super.getName();
    }
}
