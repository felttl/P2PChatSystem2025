package p2pchatsystem.main.model;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
//

public class UDPDiscoveryServer {

    private DatagramSocket socket;
    private Map<String, String> clients; // Stocke les clients {ip}

    public UDPDiscoveryServer(int port) throws Exception {
        socket = new DatagramSocket(port);
        clients = new HashMap<>();

        broadcastHelloMessage();
    }

    private void broadcastHelloMessage() throws Exception {
        UDPDiscoveryClient.bonjour();
    }

    public void listen() {
        byte[] buffer = new byte[256];

        while (true) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                InetAddress senderAddress = packet.getAddress();
                String clientInfo = senderAddress.getHostAddress(); // Suppression de l'utilisation du port

                if (message.startsWith("bonjour")) {
                    // Si le client n'est pas déjà dans la liste
                    if (!clients.containsKey(clientInfo)) {
                        System.out.println("New client connected: " + clientInfo);
                        clients.put(clientInfo, senderAddress.getHostAddress());

                        UDPDiscoveryClient.response(senderAddress.getHostAddress());
                    }
                } else if(message.startsWith("salut")){
                        if (!clients.containsKey(clientInfo)) {
                            System.out.println("New client connected: " + clientInfo);
                            clients.put(clientInfo, senderAddress.getHostAddress());
                        }
                        
                    } else if (message.startsWith("bye")) {
                        System.out.println("Client left: " + clientInfo);
                        clients.remove(clientInfo);
                }

                // Afficher les clients connectés sans le port
                System.out.println("Clients connectés: " + clients.keySet());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void ecouteUsers() throws Exception {
        UDPDiscoveryServer server = new UDPDiscoveryServer(12345);
        System.out.println("UDP Discovery Server running on port 12345...");
        server.listen();
    }
}
