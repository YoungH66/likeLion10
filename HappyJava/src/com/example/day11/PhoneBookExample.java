package com.example.day11;

import java.util.*;

public class PhoneBookExample {
    public static void main(String[] args) {
        // HashMap 생성
        Map<String, String>phonebook = new HashMap<>();

        // 전화번호 추가
        phonebook.put("김철수", "010-1234-5678");
        phonebook.put("박영희", "010-8765-4321");
        phonebook.put("이민지", "010-5566-7788");

        // 특정 키를 이용해 전화번호 검색
        String minjiNum = phonebook.get("이민지");
        System.out.println("이민지 전화번호 : " + minjiNum);

        // 전체 전화번호 목록 출력
        System.out.println("전체 전화번호 목록 ... ");
        for(Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 요소 삭제 후, 전체 전화번호 목록 출력
        phonebook.remove("이민지");
        System.out.println("전체 전화번호 목록 ... ");
        for(Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 특정 키 존재 여부 확인
        if(phonebook.containsKey("김철수")) {
            System.out.println("일치하는 결과 있음");
        }else
            System.out.println("일치하는 결과 없음");

        // 특정 값 존재 여부 확인
        if(phonebook.containsValue("010-1234-5678")) {
            System.out.println("일치하는 결과 있음");
        }else
            System.out.println("일치하는 결과 없음");

        // Map이 비었는지 확인
        System.out.println("비어있는 Map인가? " + phonebook.isEmpty());

        // Map의 크기 확인
        System.out.println("Map의 크기 : " + phonebook.size());
    }
}
