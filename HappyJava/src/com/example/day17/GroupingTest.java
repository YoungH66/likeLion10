package com.example.day17;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingTest {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("Kim", 20, Member.MALE),
                new Member("King", 23, Member.MALE),
                new Member("Queen", 24, Member.FEMALE),
                new Member("Jack", 19, Member.FEMALE)
        );

        // grouping
        Map<Integer, List<Member>> mapByGender = members.stream()
                .collect(Collectors.groupingBy(Member::getGender));

        System.out.println("Male..");
        mapByGender.get(Member.MALE)
                .stream().forEach(member -> System.out.println(member.getName()));

        System.out.println("Female..");
        mapByGender.get(Member.FEMALE)
                .stream().forEach(member -> System.out.println(member.getName()));
    }
}
