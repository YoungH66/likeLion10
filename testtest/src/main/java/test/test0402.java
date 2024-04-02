package test;

import java.util.Scanner;

// baekjoon 5086
// 두 수를 입력받아, 첫 번째 숫자와 두 번째 숫자와의 관계를 나타낸다.
public class test0402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;

        do{
            n = sc.nextInt();
            m = sc.nextInt();

            // n이 m보다 작으면, n은 m에 대해서 factor 혹은 neither
            if(n < m){
                if(m % n == 0)
                    System.out.println("factor");
                else System.out.println("neither");
            }
            // n이 m보다 크면, n은 m에 대해서 multiple 혹은 neither
            else if(n > m){
                if(n % m == 0)
                    System.out.println("multiple");
                else System.out.println("neither");
            }
        }while(n != 0 && m != 0);
    }
}
