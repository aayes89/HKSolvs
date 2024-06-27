interface PerformOperation {
    boolean check(int a);
}

class MyOperations {
    PerformOperation isOdd() {
        return (a) -> (a % 2 == 1);
    }

    PerformOperation isPrime() {
        return (a) -> {
            if (a <= 1 || (a % 2 == 0 && a != 2)) {
                return false;
            }
            if (a <= 3) {
                return true;
            }
            for (int i = 3; i * i <= a; i += 2) {
                if (a % i == 0) {
                    return false;
                }
            }
            return true;
        };
    }

    PerformOperation isPalindrome() {
        return (a) -> {
            String numStr = String.valueOf(a);
            int len = numStr.length();
            for (int i = 0; i < len / 2; i++) {
                if (numStr.charAt(i) != numStr.charAt(len - i - 1)) {
                    return false;
                }
            }
            return true;
        };
    }
}
