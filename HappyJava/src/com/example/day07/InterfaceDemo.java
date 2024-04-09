package com.example.day07;

public class InterfaceDemo {
    public static void main(String[] args) {
        // 인터페이스도 타입
        Ainter ainter = new DImpl();
        Cinter cinter = new DImpl();

        // 자기가 정의한 것만 사용가능
        ainter.aMethod();
        cinter.cMethod();

        Binter binter = new DImpl();
        Dinter dinter = new DImpl();

        binter.bMethod();
        binter.aMethod();
        binter.same();

        Ainter a = new AImpl();
        ((AImpl)a).say();   // 굳이 쓸려면 형변환 해서 사용할 수 있다. 타입이 아는것 까지만 쓸수 있기 때문
    }
}
