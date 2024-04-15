package com.example.day10;

import com.example.day02.Book;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    public static void main(String[] args) {
        //list는 object를 받는다.
        List li  = new ArrayList();
        li.add("test");
        li.add(10);
        li.add(new Book());

        System.out.println(li);
        //제네릭이 없었을 때는 매번 형변환이 필요했다.
        String strValue = (String) li.get(0);
        Integer iValue = (Integer) li.get(1);
        System.out.println(iValue);
        int i = (Integer) li.get(1);

        List<String> strList = new ArrayList<>();
        strList.add("test");
        // String이 아닌것은 에러
        // strList.add(10);
        // strList.add(new Book());

        // Type을 String으로 정했기 때문에 형변환이 필요 없다
        String sValue = strList.get(0);
    }
}
