import java.util.Scanner;

public class SubArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n >= 1 && n <= 100) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }

            // Resolver el problema
            int count = countNegativeSumSubarrays(arr);
            System.out.println(count);
        }
    }

    static int countNegativeSumSubarrays(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum < 0) {
                    ++count;
                }
            }
        }
        return count;
    }
}
