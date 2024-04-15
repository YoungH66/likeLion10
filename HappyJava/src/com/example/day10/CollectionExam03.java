package com.example.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionExam03 {
    private static void rangeException(){
        System.out.println("worng range (0 ~ 100)");
        System.out.println("0 :: exit");
        System.out.println("try again...");
    }

    public static void readScores(Scanner sc, List<Integer> list){
        int num;
        do{
            System.out.print("input number : ");
            num = sc.nextInt();
            if(num < 0 || num > 100){
                rangeException();
            }else{
                list.add(num);
            }
        }while(num != 0);
    }

    public static void removeZero(List<Integer> list){
        list.remove(Integer.valueOf(0));
    }

    public static void printScores(List<Integer> list){
        System.out.println(list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        
        int sum = 0;

        readScores(sc, list);

        removeZero(list);

        printScores(list);

        for(Integer i : list){
            sum += i;
        }
        double avg = (double)sum / list.size();
        System.out.println("sum : " + sum);
        System.out.printf("avg : %.2f", avg);

        sc.close();
    }
}
