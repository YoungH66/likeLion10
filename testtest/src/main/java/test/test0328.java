package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test0328 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            max = Math.max(max, A[i]);
            sum += A[i];
        }

        int start = max;
        int end = sum;

        while (start <= end) {
            int middle = (start + end) / 2;
            int count = 1;
            int currentSum = 0;

            for (int i = 0; i < N; i++) {
                if (currentSum + A[i] > middle) {
                    count++;
                    currentSum = 0;
                }
                currentSum += A[i];
            }

            if (count > M)
                start = middle + 1;
            else
                end = middle - 1;
        }

        System.out.println(start);
    }
}
