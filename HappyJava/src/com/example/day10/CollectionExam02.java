package com.example.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionExam02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        int num;
        int sum = 0;
        do{
            System.out.print("input number : ");
            num = sc.nextInt();
            if(num < 0 || num > 100){
                System.out.println("worng range (0 ~ 100)");
                System.out.println("0 :: exit");
                System.out.println("try again...");
            }else{
                list.add(num);
            }
        }while(num != 0);

        list.remove(Integer.valueOf(0));
        System.out.println(list);

        for(Integer i : list){
            sum += i;
        }
        double avg = (double)sum / list.size();
        System.out.println("sum : " + sum);
        System.out.printf("avg : %.2f", avg);
    }
}
