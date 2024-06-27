public class DecentNumber {

    public static void decentNumber(int n) {
        for (int i = n; i >= 0; i--) {
            if (i % 3 == 0 && (n - i) % 5 == 0) {
                System.out.println("5".repeat(i) + "3".repeat(n - i));
                return;
            }
        }
        System.out.println("-1");
    }

    public static void main(String[] args) {
        // Prueba la función con un valor específico de n
        decentNumber(15);
    }
}
