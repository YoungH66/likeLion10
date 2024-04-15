package com.example.day10;

import java.util.List;

public class GenericMethodExample3 {
    // List<T> list로 해도 동작에는 문제가 없지만,
    // 아래와 같이 와일드카드를 사용한면 T타입, 혹은 그 서브타입을 리스트의 인자로 받을 수 있게된다.
    public static <T> void printFirst(List<? extends T> list) {
        if(!list.isEmpty()) {
            T item = list.get(0);   // 첫 번재 요소를 가져옴
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        // Integer 리스트
        List<Integer> integerList = List.of(1, 2, 3);
        printFirst(integerList);

        // String 리스트
        List<String> strList= List.of("Hello", "World");
        printFirst(strList);
    }
}
