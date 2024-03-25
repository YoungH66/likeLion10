package com.example.util;

import java.util.Arrays;
import java.util.Scanner;

public class Lottery {
    // 당첨 번호가 중복되지 않은 무작위 정수를 받아야 하도록 수정 필요
    private int max = 45;
    private int cap = 6;
    int[] hitArr = new int[6];
    int[] tryArr = new int[6];

    // 당첨 번호 생성
    public void hitArrGen(){
        for(int i = 0; i < cap; i++)
            hitArr[i] = (int) (Math.random() * 45 + 1);
        Arrays.sort(hitArr);
    }

    // 자동
    public void tryArrGen(){
        for(int i = 0; i < cap; i++)
            tryArr[i] = (int) (Math.random() * 45 + 1);
        Arrays.sort(tryArr);

        compareArr();
    }

    // 당첨 번호 출력
    public void popHitArr(){
        System.out.println("이번 로또 당첨 번호는 ... " + Arrays.toString(hitArr));
    }

    // 수동 입력
    public void selectNum(){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("로또 번호를 직접 입력.");
        System.out.println("원하는 번호를 6개 입력하세요.");
        for(int i = 0; i < cap; i++){
            do{
                System.out.print((i+ 1) + "번째 숫자 : ");
                n = sc.nextInt();
                if(n <= max && n > 0)
                    tryArr[i] = n;
                else
                    System.out.println("범위를 초과했습니다.(1 ~ 45) 다시 입력하세요.");
            }while(!(n <= max));

        }
        Arrays.sort(tryArr);

        compareArr();
    }

    // 맞춰보기
    protected void compareArr(){
        int hit = 0;
        for(int i = 0; i < cap; i++) {
            if(Arrays.binarySearch(hitArr, tryArr[i]) >= 0)
                hit++;
        }
        System.out.println("총 " + hit + "개 맞았습니다.");
    }
}
