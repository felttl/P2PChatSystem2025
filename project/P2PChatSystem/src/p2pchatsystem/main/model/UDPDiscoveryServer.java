package p2pchatsystem.main.model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p2pchatsystem.main.controller.P2PChatSystem;
import p2pchatsystem.main.model.business.User;

public class UDPDiscoveryServer extends Thread {

    private DatagramSocket socket;
    private Map<String, User> clients; // Store clients with IP as key
    private String monIp;

    public UDPDiscoveryServer(int port) throws Exception {
        socket = new DatagramSocket(port);
        clients = new ConcurrentHashMap<>();
        monIp = InetAddress.getLocalHost().getHostAddress();
        
        broadcastHelloMessage();
    }

    private void broadcastHelloMessage() throws Exception {
        UDPDiscoveryClient.bonjour(P2PChatSystem.getUsername());
    }

    public void listen() {
        byte[] buffer = new byte[256];

        while (!Thread.currentThread().isInterrupted()) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength()).trim();
                InetAddress senderAddress = packet.getAddress();
                String clientInfo = senderAddress.getHostAddress();

                if (clientInfo.equals(monIp)) {
                    continue;
                }
                
                String username = extractUsername(message);
                
                if (message.startsWith("bonjour") || message.startsWith("salut")) {
                    if (!clients.containsKey(clientInfo)) {
                        clients.put(clientInfo, new User(username, clientInfo));
                    }
                    
                    if (message.startsWith("bonjour")) {
                        UDPDiscoveryClient.response(clientInfo, P2PChatSystem.getUsername());
                    }
                } else if (message.startsWith("bye")) {
                    clients.remove(clientInfo);
                }
                
                System.out.println("Clients connectés: " + clients.keySet());
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private String extractUsername(String message) {
        try {
            String[] parts = message.split("\\s+");
            for (String part : parts) {
                if (part.startsWith("nom=")) {
                    return part.substring(4);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to extract username from: " + message);
        }
        
        return "Unknown";
    }
    
    public Map<String, User> getUsers() {
        return new HashMap<>(clients);
    }
    
    public void run() {
        try {
            System.out.println("UDP Discovery Server running on port 12345...");
            this.listen();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deconnexion() throws IOException {
        UDPDiscoveryClient.aurevoir();
        socket.close();
    }
    
    public String getIpByUsername(String username) {
        for (Map.Entry<String, User> entry : clients.entrySet()) {
            if (entry.getValue().getName().equals(username)) {
                return entry.getKey();
            }
        }
        return null;
    }
    
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
        return new ArrayList<>(clients.keySet());
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
        List<String> biggerIPs = new ArrayList<>();

        try {
            for (String clientIp : clients.keySet()) {
                if (compareIp(clientIp, monIp) > 0) {
                    biggerIPs.add(clientIp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return biggerIPs;
    }
}