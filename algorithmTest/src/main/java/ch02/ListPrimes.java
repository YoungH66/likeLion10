package ch02;

import java.util.Scanner;

public class ListPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int divCnt = 0;
        int target;

        System.out.print("탐색할 범위 : ");
        target = sc.nextInt();
        for(int i = 2; i <= target; i++) {
            boolean isPrime = true;
            for(int div = 2; div < i; div++) {
                divCnt++;
                if(i % div == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                System.out.println(i);
        }
        System.out.println("나눗셈 연산을 수행한 횟수 : " + divCnt);
    }
}
