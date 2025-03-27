package p2pchatsystem.main.model;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p2pchatsystem.main.controller.P2PChatSystem;

public class UDPDiscoveryServer extends Thread{

    private DatagramSocket socket;
    private Map<String, String> clients; // Stocke les clients {ip}
    private String monIp;

    public UDPDiscoveryServer(int port) throws Exception {
        socket = new DatagramSocket(port);
        clients = Collections.synchronizedMap(new HashMap<>());
        monIp = InetAddress.getLocalHost().getHostAddress();
        
        broadcastHelloMessage();
    }

    private void broadcastHelloMessage() throws Exception {
        UDPDiscoveryClient.bonjour(P2PChatSystem.getUsername());
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

                
                if (clientInfo.equals(monIp)) {
                    System.out.println("Message ignoré de moi-même: " + clientInfo);
                    continue;
                }
                
                if (message.startsWith("bonjour")) {
                    // Si le client n'est pas déjà dans la liste
                    if (!clients.containsKey(clientInfo)) {
                        System.out.println("New client connected: " + clientInfo);
                        clients.put(clientInfo, senderAddress.getHostAddress());

                        UDPDiscoveryClient.response(senderAddress.getHostAddress(),P2PChatSystem.getUsername());
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
    
    public Map<String, String> getUsers(){
        return this.clients;
    }
    
    public void run() {
    try {
        System.out.println("UDP Discovery Server running on port 12345...");
        this.listen();
        } catch (Exception ex) {}
    }
    
    
    
    
    /*Partie pour comparer les ips pour les serveurs pour mes connexions tcp*/
    
    private int compareIp(String ip1, String ip2) {
        String[] parts1 = ip1.split("\\.");
        String[] parts2 = ip2.split("\\.");

        for (int i = 0; i < 4; i++) {
            int num1 = Integer.parseInt(parts1[i]);
            int num2 = Integer.parseInt(parts2[i]);

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;
        }
        return 0;
    }
    
    public List<String> getIPs() {
        List<String> Ips = new ArrayList<>();
        
        for (String clientIp : clients.keySet()) {
            Ips.add(clientIp);
        } 
        return Ips;
    }
    
    public List<String> getSmallerIPs() {
        List<String> smallerIPs = new ArrayList<>();

        try {
            for (String clientIp : clients.keySet()) {
                if (compareIp(clientIp, monIp) < 0) {
                    smallerIPs.add(clientIp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return smallerIPs;
    }

    public List<String> getBiggerIPs() {
        List<String> smallerIPs = new ArrayList<>();

        try {
            for (String clientIp : clients.keySet()) {
                if (compareIp(clientIp, monIp) > 0) {
                    smallerIPs.add(clientIp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return smallerIPs;
    }
    
}
