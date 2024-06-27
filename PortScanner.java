import java.net.Socket;

public class PortScanner {

    public static void main(String[] args) {
        String host = "localhost"; // Cambia esto al host que deseas escanear
        int timeout = 1000; // Tiempo de espera en milisegundos

        for (int port = 1; port <= 65535; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new java.net.InetSocketAddress(host, port), timeout);
                socket.close();
                System.out.println("Puerto " + port + " está abierto");
            } catch (Exception ex) {
                // El puerto está cerrado o hay un problema de conexión
            }
        }
    }
}
