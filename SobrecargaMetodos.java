public class EjemploSobrecarga {

    // Método sobrecargado para sumar dos enteros
    public int sumar(int a, int b) {
        return a + b;
    }

    // Método sobrecargado para sumar tres enteros
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }

    // Método sobrecargado para sumar dos números decimales
    public double sumar(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        EjemploSobrecarga ejemplo = new EjemploSobrecarga();

        // Ejemplos de llamadas a los métodos sobrecargados
        int resultado1 = ejemplo.sumar(5, 10);
        int resultado2 = ejemplo.sumar(2, 4, 6);
        double resultado3 = ejemplo.sumar(3.5, 2.7);

        // Imprimir resultados
        System.out.println("Resultado 1: " + resultado1);
        System.out.println("Resultado 2: " + resultado2);
        System.out.println("Resultado 3: " + resultado3);
    }
}
