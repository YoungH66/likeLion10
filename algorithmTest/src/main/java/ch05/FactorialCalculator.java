package ch05;

import java.util.Scanner;

public class FactorialCalculator {
    static int computeFactorial(int n){
        if(n > 0)
            return n * computeFactorial(n - 1);
        else
            return 1;
    }

    static int factorial(int n){
        int fact = 1;
        while (n > 1){
            fact = fact * n--;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("INPUT NUMBER : ");
        int n = sc.nextInt();

        System.out.println(n + " Factorial is..." + computeFactorial(n));
        System.out.println(n + " Factorial is..." + factorial(n) + " (method)");
    }
}
