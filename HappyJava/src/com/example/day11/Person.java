package com.example.day11;

import java.util.*;

public class Person implements Comparable<Person>{
    private String name;

    private int age;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " : " + age;
    }

    // comparable을 위해
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);    // 이름을 기준으로 오름차순 정렬
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("John", 18));
        list.add(new Person("Jane", 17));
        list.add(new Person("Bob", 18));

        System.out.println(list);
        // 기준이 없기에 기본적으로 오류 발생
        Collections.sort(list);
        System.out.println(list);

        // 새로운 기준을 새로 선언할 수 있음
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2){
                return o1.age - o2.age;
            }
        });

        System.out.println(list);
    }
}
