import java.util.BitSet;
import java.util.Scanner;

public class BitSetOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        BitSet B1 = new BitSet(N);
        BitSet B2 = new BitSet(N);

        for (int i = 0; i < M; i++) {
            String operation = scanner.next();
            int set = scanner.nextInt();
            int index = scanner.nextInt();

            if (operation.equals("AND")) {
                if (set == 2) {
                    B2.and(B1);
                } else {
                    B1.and(B2);
                }
            } else if (operation.equals("OR")) {
                if (set == 2) {
                    B2.or(B1);
                } else {
                    B1.or(B2);
                }
            } else if (operation.equals("XOR")) {
                if (set == 2) {
                    B2.xor(B1);
                } else {
                    B1.xor(B2);
                }
            } else if (operation.equals("FLIP")) {
                if (set == 2) {
                    B2.flip(index);
                } else {
                    B1.flip(index);
                }
            } else if (operation.equals("SET")) {
                if (set == 2) {
                    B2.set(index);
                } else {
                    B1.set(index);
                }
            }

            // Imprimir el número de bits establecidos en B1 y B2
            System.out.println(B1.cardinality() + " " + B2.cardinality());
        }

        scanner.close();
    }
}
