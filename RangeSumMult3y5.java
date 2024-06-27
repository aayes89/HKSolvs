import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            resolve(n);
        }
    }

    private static void resolve(int n) {
        n -= 1; // Ajuste para incluir números menores a n
        long countMultiples3 = n / 3;
        long countMultiples5 = n / 5;
        long countMultiples15 = n / 15;

        long sumT = (3 * countMultiples3 * (countMultiples3 + 1) / 2) +
                    (5 * countMultiples5 * (countMultiples5 + 1) / 2) -
                    (15 * countMultiples15 * (countMultiples15 + 1) / 2);

        System.out.println(sumT);
    }
}
