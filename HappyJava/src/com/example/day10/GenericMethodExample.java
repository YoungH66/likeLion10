package com.example.day10;

public class GenericMethodExample {
    public static <T> void printArrayElement(T[] array) {
        for (T el : array){
            System.out.print(el+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3,4,5};
        printArrayElement(intArray);

        String[] stringArray = {"one","two","three","four","five"};
        printArrayElement(stringArray);
    }
}
