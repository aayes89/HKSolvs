public class Singleton {
    // La instancia única se almacena como una variable privada estática.
    private static Singleton instance;

    // El constructor es privado para evitar la creación de instancias desde fuera de la clase.
    private Singleton() {
        // Constructor privado.
    }

    // Método estático para obtener la instancia única.
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Puedes agregar métodos y atributos a la clase Singleton según tus necesidades.
}

public class Main {
    public static void main(String[] args) {
        // Obtener la instancia del Singleton.
        Singleton singleton = Singleton.getInstance();

        // Comprobar si son la misma instancia.
        if (singleton == Singleton.getInstance()) {
            System.out.println("Ambas instancias son iguales. Es un Singleton.");
        }
    }
}
