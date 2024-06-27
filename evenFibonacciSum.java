import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong(); // Limit N for Fibonacci sequence
            long result = evenFibonacciSum(n);
            System.out.println(result);
        }

        scanner.close();
    }

    private static long evenFibonacciSum(long n) {
        long sumEve = 0;
        long ini = 1L;
        long sec = 2;

        while (sec <= n) {
            if (sec % 2 == 0) {
                sumEve += sec;
            }
            
            long next = ini + sec;
            ini = sec;
            sec = next;
        }

        return sumEve;
    }
}
