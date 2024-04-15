package com.example.day10;

import com.example.day07.Ainter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CollectionExam01 {
    public static void main(String[] args) {
        // 배열과 달리 List는 가변길이 구조이다.
        ArrayList<String> strList = new ArrayList<>();

        strList.add("a");
        strList.add("b");
        strList.add("c");
        System.out.println(strList.size());

        for(String str : strList) {
            System.out.print(str + " ");
        }
        System.out.println();

        strList.add("d");
        strList.add("e");
        strList.add("f");
        strList.add("g");
        strList.add("h");
        strList.add("i");
        strList.add("j");
        strList.add("k");
        strList.add("l");
        System.out.println(strList.size());

        for(String str : strList) {
            System.out.print(str + " ");
        }
        System.out.println();

        System.out.println(strList.get(9));
        System.out.println("================================");

        // interface 타입을 쓰면 코드가 좀더 유연해 진다.
        // Vector로 생성하든 ArrayList로 생성하든 하부 내용을 수정하지 않아도 된다.
        List<String> list  = new Vector<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        for(String str : list) {
            System.out.println(str + " ");
        }

        System.out.println(list);

        // 각 인덱스에 접근하기 위해 get을 사용해야 한다.
        System.out.println(list.get(0));

        List<Integer> integerList = new ArrayList<>();
        // autoboxing으로 자동으로 변해서 들어간다.
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println(integerList);
        System.out.println(integerList.remove(0));
        System.out.println(integerList);

        // 해당 요소가 있는지 검사
        // equals 메소드가 적절하게 override 되어야 한다.
        System.out.println(integerList.contains(3));
        System.out.println(integerList.contains(4));
        System.out.println();

        // 인덱스가 아닌 오브젝트도 remove 대상이 될 수 있다.
        // 리턴값은 boolean
        System.out.println(integerList.remove(Integer.valueOf(2)));
        System.out.println(integerList);

        // 중복값 허용
        integerList.add(5);
        integerList.add(5);
        System.out.println(integerList);

        // 중복된 오브젝트가 있을경우
        // remove 오브젝트의 경우 처음 온 대상을 처리한다.
        integerList.remove(Integer.valueOf(5));
        System.out.println(integerList);
        System.out.println();

        // 내부 내용을 지운다
        // null 과는 다르다.
        integerList.clear();
        System.out.println(integerList);
    }
}
