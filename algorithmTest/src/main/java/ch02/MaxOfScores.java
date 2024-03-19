package ch02;

import java.util.Scanner;

public class MaxOfScores {
    public static int max(int[] arr){
        int max = 0;
        for(int i : arr){
            if (max <= i)
                max = i;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 크기를 입력하세요 : ");
        int len = sc.nextInt();

        int[] arr = new int[len];
        System.out.println("배열에 들어갈 정수를 입력하세요.\n");

        int i = 0;
        do{
            System.out.printf("%d번째 인덱스에 들어갈 정수를 입력하세요 : ", i+1);
            arr[i] = sc.nextInt();
            i++;
        }while(i < arr.length);

        System.out.println("\n생성된 배열의 최대값은 " + max(arr) + " 입니다.");
    }
}
