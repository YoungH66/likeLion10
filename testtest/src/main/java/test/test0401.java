package test;

import java.util.Arrays;
import java.util.Scanner;

public class test0401 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] tgArr;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        tgArr = new int[M];
        for (int i = 0; i < tgArr.length; i++) {
            tgArr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        //Arrays.sort(tgArr);

        for(int i = 0; i < tgArr.length; i++){
            if(Arrays.binarySearch(arr, tgArr[i]) >= 0) {
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }
        }
    }
}