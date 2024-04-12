package com.example.day09;

import java.util.Arrays;

public class SystemExam01 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int count = 1;
        do{
            System.out.println("count: " + count);
            count++;
        }while(count <= 1000);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));

        String pathVariable = System.getenv("PATH");
        System.out.println("Path: " + pathVariable);

        int[] sourceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] destArray = new int[sourceArray.length];
        System.arraycopy(sourceArray, 0, destArray, 0, sourceArray.length);
        System.out.println("destArray: " + Arrays.toString(destArray));
    }
}
