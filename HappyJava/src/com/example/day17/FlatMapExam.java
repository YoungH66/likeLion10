package com.example.day17;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlatMapExam {
    public static void main(String[] args) {
        List<List<String>>  nestedList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("cherry", "Date")
        );
        // .flatMap(Collection::stream) 은 리스트를 평탄화 한다.
        List<String> flatList = nestedList.stream().flatMap(Collection::stream).toList();
        System.out.println(flatList);
    }
}
