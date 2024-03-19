package ch02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfWeightsRand {
    static int maxOf(int[] starr){
        int max = 0;
        for(int i : starr){
            if (max < i)
                max = i;
        }
        return max;
    }
    public static void main(String[] args) {
        // Math.random(); // double 반환, 0.0 ~ 1.0 반환
        Random ran = new Random(); // 0 ~
        Scanner sc = new Scanner(System.in);

        System.out.print("학생의 수를 입력하세요 : ");
        int[] starr = new int[sc.nextInt()];
        System.out.println("학생의 몸무게가 무작위로 설정됩니다.");
        for(int i = 0; i < starr.length; i++){
            starr[i] = ran.nextInt(40,100);
        }

        System.out.println("몸무게는 다음과 같습니다.");
        for(int i : starr)
            System.out.println(i);

        System.out.println("\n최대값은 " + maxOf(starr) + " 입니다.");
    }
}
