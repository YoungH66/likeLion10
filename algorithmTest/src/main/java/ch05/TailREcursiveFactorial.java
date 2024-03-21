package ch05;

import java.util.Scanner;

public class TailREcursiveFactorial {
    // 꼬리 재귀를 사용한 팩토리얼 계산 메서드
    static int factorial(int n, int accumulator) {
        if (n == 1) return accumulator;
        return factorial(n - 1, n * accumulator);
    }
    // 사용자가 입력한 숫자에 대해 팩토리얼을 계산
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("팩토리얼을 계산할 정수를 입력하세요: ");
        int x = stdIn.nextInt();
// 초기 누적 변수 값으로 1을 사용
        int result = factorial(x, 1);
        System.out.println(x + "의 팩토리얼은 " + result + "입니다.");
    }

}
