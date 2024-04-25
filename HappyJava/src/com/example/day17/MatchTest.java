package com.example.day17;

import java.util.Arrays;

public class MatchTest {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6, 8};

        boolean result = false;

        result = Arrays.stream(intArr).allMatch(x -> x % 3 == 0);
        System.out.println("are they all multiples of 3? " + result);

        result = Arrays.stream(intArr).anyMatch(x -> x % 3 == 0);
        System.out.println("one or more of them is a multiple of 3? " + result);

        result = Arrays.stream(intArr).noneMatch(x -> x % 3 == 0);
        System.out.println("are non of them multiple of 3? " + result);
    }
}
