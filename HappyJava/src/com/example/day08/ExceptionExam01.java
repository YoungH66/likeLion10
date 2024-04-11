package com.example.day08;

public class ExceptionExam01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        try {
            // arr에 인덱스 3은 없다. 예외 발생
            System.out.println(arr[3]);
            // 예외가 발생한 시점부터 catch 블록으로 넘어감.
            System.out.println("do something");

            // 하나의 캐치블럭이 모든 예외를 처리할 수 있는것도 아니다.
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("!! 예외 발생 :: " + e.getMessage());
            System.out.println(arr[0]);

            // 예외가 발생한 지점을 알 수 있다.
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }

        System.out.println("todo1");
        System.out.println("todo2");
        System.out.println("todo3");
        System.out.println("todo4");
        System.out.println("done");

        ;
    }
}
