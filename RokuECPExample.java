import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RokuECPExample {

    public static void main(String[] args) {
        // IP del dispositivo Roku y puerto ECP (8060 por defecto)
        String rokuIpAddress = "192.168.1.100";
        int ecpPort = 8060;

        // Endpoint para obtener información sobre el canal actual
        String endpoint = "query/active-app";

        // Construye la URL completa
        String url = "http://" + rokuIpAddress + ":" + ecpPort + "/" + endpoint;

        try {
            // Realiza la solicitud HTTP GET
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            // Lee la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Cierra la conexión y muestra la respuesta
            reader.close();
            connection.disconnect();

            System.out.println("Response from Roku ECP:");
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
