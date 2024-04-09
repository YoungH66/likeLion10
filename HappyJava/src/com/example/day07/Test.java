package com.example.day07;

public class Test {
    public static void main(String[] args) {
        Child c = new Child();
        //c.getName();
        System.out.println(c);
        System.out.println(c.toString());   // toString은 기본적으로 object가 가지고 있다. 하지만 object는 child에 뭐가 있는지 모른다.

        String str = "test";    // String 클래스 자체로 toString을 오버라이딩 하여 사용하겠다는 의미.
        System.out.println(str);
        System.out.println(str.toString());

        Product pen = new Product("monami", 1000);
//        pen.getTitle();
//        pen.getPrice();
        // 클래스의 모든 요소를 반환하도록 toString을 override
        // 단, toStirng을 통해 각 객체에 직접 접근할 수는 없다.
        System.out.println(pen);

        // pen과 같은 title, price를 가지는 pen2를 선언
        Product pen2 = new Product("monami", 1000);
        if(pen == pen2){
            System.out.println("same");
        }else System.out.println("different");  // pen과 pen2는 주소값이 다르기에 == 연산에서는 다르게 판단한다.

        if(pen.equals(pen2)){
            System.out.println("equals same");  // 해당 클래스에서 override 필요
        }else System.out.println("equals different");   // 기본적인 equals는 object에 있으며, == 연산과 동일하게 동작한다.

        System.out.println(pen.getClass());
        System.out.println(pen2.getClass());
    }
}
