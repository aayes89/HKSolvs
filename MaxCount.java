import java.util.Arrays;
import java.util.List;

public class MaxCount {
    public static int pickingNumbers(List<Integer> a) {
        long maxCount = 0L;

        for (Integer num : a) {
            long count = a.stream().filter(n -> n == num || n == num + 1).count();
            maxCount = Math.max(maxCount, count);
        }

        return (int) maxCount;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(/* your array elements here */);
        int result = pickingNumbers(numbers);
        System.out.println(result);
    }
}
