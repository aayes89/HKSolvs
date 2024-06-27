public class MiClase{
  public void imprimirNombres(String... nombres) {
      for (String nombre : nombres) {
          System.out.println(nombre);
      }
  }
}

public static void main(String[] args) {
    MiClase instancia = new MiClase();
    instancia.imprimirNombres("Alice", "Bob", "Charlie");
    instancia.imprimirNombres("David", "Eve");
}
