import java.util.Scanner;

public class EscaladaGusano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de datos
        int N = scanner.nextInt(); // Profundidad del pozo en pulgadas
        int U = scanner.nextInt(); // Distancia que sube el gusano en un minuto
        int D = scanner.nextInt(); // Distancia que resbala el gusano en un minuto de descanso

        // Cálculo del tiempo de escalada
        int minutosTotales = calcularTiempoEscalada(N, U, D);

        // Salida de resultados
        System.out.println(minutosTotales);

        scanner.close();
    }

    // Función para calcular el tiempo de escalada del gusano
    private static int calcularTiempoEscalada(int N, int U, int D) {
        int minutosTotales = 0;
        int distanciaActual = 0;

        while (distanciaActual < N) {
            // Cuenta el tiempo de subida
            minutosTotales++;

            // Verifica si ha alcanzado la cima
            if (distanciaActual + U >= N) {
                break;
            }

            // Cuenta el tiempo de descanso
            minutosTotales++;

            // Desciende durante el descanso
            distanciaActual += D;
        }

        return minutosTotales;
    }
}
