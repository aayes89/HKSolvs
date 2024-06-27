import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {

    public static String convertTime(String inputTime) {
        DateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
        DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");

        try {
            Date date = inputFormat.parse(inputTime);
            return outputFormat.format(date);
        } catch (ParseException e) {
            // Manejar la excepción en caso de un formato de entrada incorrecto
            e.printStackTrace();
            return "Formato de hora incorrecto";
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String inputTime = "07:05:45PM";
        String convertedTime = convertTime(inputTime);
        System.out.println("Resultado: " + convertedTime);
    }
}
