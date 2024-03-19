package ch01;

import java.util.Scanner;

public class TriangleLB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        System.out.println("이등변 삼각형을 그립니다.");

        do{
            System.out.print("그리고자하는 삼각형의 단 수를 입력하세요 : ");
            n = sc.nextInt();
            if(n < 1)
                System.out.println("입력 범위를 벗어났습니다. 1 이상의 정수를 입력하세요.");
        }while(n < 1);

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= i; j++)
                System.out.print('*');
            System.out.println();
        }

    }
}
