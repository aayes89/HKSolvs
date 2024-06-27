import java.util.regex.*;

public class RegexExample {
    public static void main(String[] args) {
        // Define la expresión regular.
        String regex = "([A-Z])(.+)";

        // Compila la expresión regular en un objeto Pattern.
        Pattern pattern = Pattern.compile(regex);

        // Crea un texto de ejemplo que contiene una coincidencia.
        String text = "Esta es una Coincidencia de Ejemplo.";

        // Crea un objeto Matcher para buscar la expresión regular en el texto.
        Matcher matcher = pattern.matcher(text);

        // Encuentra todas las coincidencias en el texto.
        while (matcher.find()) {
            // Imprime las partes de la coincidencia.
            System.out.println("Coincidencia encontrada:");
            System.out.println("Grupo 1 (letra mayúscula): " + matcher.group(1));
            System.out.println("Grupo 2 (resto del texto): " + matcher.group(2));
        }
    }
}
