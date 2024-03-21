package ch05;

import java.util.Scanner;

public class GCDCalculator {
    // 두 정수 x, y의 최대공약수를 재귀적으로 계산한다.
    static int calculateGCD(int x, int y){
        if(y == 0)  // 기저 조건: y가 0이면 x가 최대공약수
            return x;
        else
            return calculateGCD(y, x % y);  // 유클리드 호제법을 사용한 재귀 호출
    }

    static int gcd(int x, int y){
        while(y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("두 수의 최대 공약수를 계산한다.");
        System.out.print("첫번째 정수를 입력하세요 : ");
        int x = sc.nextInt();
        System.out.print("두번째 정수를 입력하세요 : ");
        int y = sc.nextInt();

        System.out.println("두 수의 최대 공약수는 ... " + calculateGCD(x, y));
        System.out.println("두 수의 최대 공약수는 ... " + gcd(x, y) + " (method)");
    }
}
