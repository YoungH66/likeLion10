package test;

import java.util.Arrays;
import java.util.Scanner;

public class test0403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrN = new int[n];

        for(int i = 0; i < arrN.length; i++) {
            arrN[i] = sc.nextInt();
        }


        int m = sc.nextInt();
        int[] arrM = new int[m];
        int[] arrT = new int[m];
        for(int i = 0; i < arrM.length; i++) {
            arrM[i] = sc.nextInt();
        }

        for(int i = 0; i < arrM.length; i++){
            for(int j = 0; j < arrN.length; j++) {
                if(arrM[i] == arrN[j]) {
                    arrT[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(arrT));
    }
}
