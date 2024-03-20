package ch02;

public class OptimizedPrimeFinder {
    public static void main(String[] args) {
        int operationcount = 0;
        int primeCount = 0;
        int[] primes = new int[500];

        primes[primeCount++] = 2;
        primes[primeCount++] = 3;

        for(int num = 5; num <= 1000; num += 2) {
            boolean isPrime = true;
            for(int i = 1; primes[i] * primes[i] <= num; i++){
                operationcount += 2;
                if(num % primes[i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primes[primeCount++] = num;
                operationcount++;
            }
        }

        for(int i = 0; i < primeCount; i++)
            System.out.println(primes[i]);

        System.out.println("연산 횟수 (곱셈, 나눗셈) : " + operationcount);
    }
}
