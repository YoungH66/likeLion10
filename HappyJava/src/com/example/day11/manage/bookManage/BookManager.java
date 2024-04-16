package com.example.day11.manage.bookManage;

import java.util.*;

public class BookManager {
    Set<Book> bookSet = new LinkedHashSet<>();

    void addBook(Book book) {
        if(!bookSet.contains(book)) {
            System.out.println("책을 추가했습니다.");
        }
        bookSet.add(book);
    }

    void displayBooks(){
        if(bookSet.isEmpty()){
            System.out.println("책이 비어있습니다");
            return;
        }
        for(Book book : bookSet){
            System.out.println(book);
        }
    }

    // 중복을 허용하지 않기 위해서 Set으로 선언했는데
    // 정렬이 안된다
    // set인 bookSet을 그대로 List bList로 가져와 정렬기준을 만들어 정렬하고
    // bList를 출력한다.
    // 원본에 영향이 없다는 문제 있음
    // 애초에 set으로 하지 않고 list로 선언한 후에
    // 중복을 체크하는 부분을 구현하는게 좋을수도 있음
    void sortBooksByYear(){
        List<Book> bList = new ArrayList<>(bookSet);
        Collections.sort(bList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getDate() - o2.getDate();
            }
        });
        for(Book book : bList){
            System.out.println(book);
        }
    }
}
