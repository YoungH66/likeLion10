package ch05;

import java.util.Scanner;
import java.util.Stack;

public class IterativeExploration {
    // n을 이용해서 재귀 패턴을 반복문으로 구현
    static void displayPatternIteratively(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        while(!stack.isEmpty()){
            int current = stack.pop();

            if(current > 0){
                stack.push(current - 1);
                System.out.println("NUMBER : " + current);

                if(current - 2 > 0) {
                    stack.push(current - 2);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("INPUT NUMBER : ");
        int x = sc.nextInt();

        displayPatternIteratively(x);
    }
}
