public class EjemploEnum {

    // Declaración de un enum llamado DiaSemana
    public enum DiaSemana {
        LUNES, MARTES, MIÉRCOLES, JUEVES, VIERNES, SÁBADO, DOMINGO
    }

    public static void main(String[] args) {
        // Acceder a los valores del enum
        DiaSemana dia = DiaSemana.MIÉRCOLES;

        // Ejemplo de uso en una estructura de control
        switch (dia) {
            case LUNES:
            case MARTES:
            case MIÉRCOLES:
            case JUEVES:
            case VIERNES:
                System.out.println("Es un día laboral.");
                break;
            case SÁBADO:
            case DOMINGO:
                System.out.println("Es fin de semana.");
                break;
            default:
                System.out.println("Día no válido.");
        }
    }
}
