package ch02;

import java.util.Arrays;
import java.util.Scanner;

public class InvertArray {
    static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    static void reverse(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++){
            swap(arr, i, arr.length - i - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("SELECT LENGTH : ");
        int[] num = new int[sc.nextInt()];

        for(int i = 0; i < num.length; i++) {
            System.out.print("INPUT NUMBER : ");
            num[i] = sc.nextInt();
        }

        reverse(num);

        System.out.println("RESULT : " + Arrays.toString(num));

    }
}
