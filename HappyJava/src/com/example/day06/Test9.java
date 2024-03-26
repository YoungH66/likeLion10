package com.example.day06;
class Book{
    String title;
    public String info(){
        return "이 책의 제목은 [" + title + "]입니다.";
    }

    @Override
    public String toString(){
        return "이 책의 제목은 [" + title + "]입니다.";
    }
}
public class Test9 {
    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println(p.toString());   // 결과 : com.example.day06.Parent@2f4d3709

        Book book = new Book();
        book.title = "모두의 자바";
        System.out.println(book.info());

        System.out.println(book.toString());

        System.out.println(book);   // book을 호출하면 자동으로 toString을 호출

        String str = "check";
        System.out.println(str);
        System.out.println(str.toString());     // 같은 내용이다.
    }
}
