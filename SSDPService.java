import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SSDPService {

    public static void main(String[] args) {
        startSSDPServer();
    }

    public static void startSSDPServer() {
        try {
            MulticastSocket socket = new MulticastSocket(1900);
            InetAddress group = InetAddress.getByName("239.255.255.250");
            socket.joinGroup(group);

            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);

                String data = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received SSDP packet:\n" + data);

                // Process SSDP packet here
                // You can extract information from the packet and respond accordingly

                // For example, sending a response
                sendSSDPResponse(packet.getAddress(), packet.getPort());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendSSDPResponse(InetAddress address, int port) {
        try {
            DatagramSocket responseSocket = new DatagramSocket();
            String responseMessage = "HTTP/1.1 200 OK\r\n" +
                    "ST: urn:schemas-upnp-org:service:serviceType:v\r\n" +
                    "Location: http://" + address.getHostAddress() + ":" + port + "/description.xml\r\n\r\n";
            byte[] responseData = responseMessage.getBytes();

            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, address, port);
            responseSocket.send(responsePacket);

            responseSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
