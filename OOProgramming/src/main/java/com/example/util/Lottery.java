package com.example.util;

import java.util.Arrays;
import java.util.Scanner;

public class Lottery {
    private int max = 45;
    private int cap = 6;
    private int[] hitArr = new int[cap];
    private int[] tryArr = new int[cap];
    // 당첨 번호 생성
    public void hitArrGen(){
        int num;
        Arrays.fill(hitArr, -1);    // 초기화
        for(int i = 0; i < cap; i++){
            num = (int) (Math.random() * max + 1);
            if(!isExit(hitArr,num, i))
                hitArr[i] = num;
        }
        Arrays.sort(hitArr);
    }

    // 당첨 번호 출력
    public void popHitArr(){
        System.out.println("이번 로또 당첨 번호는 ... " + Arrays.toString(hitArr));
    }

    boolean isExit(int[] arr, int num, int idx){
        for(int i = 0; i < idx; i++)
            if(arr[i] == num)
                return true;
        return false;
    }

    // 자동
    public void tryArrGen(){
        int num;
        Arrays.fill(tryArr, -1);    // 초기화
        for(int i = 0; i < cap; i++){
            num = (int) (Math.random() * max + 1);
            if(!isExit(tryArr,num, i))
                tryArr[i] = num;
        }
        Arrays.sort(tryArr);

        compareArr();
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
