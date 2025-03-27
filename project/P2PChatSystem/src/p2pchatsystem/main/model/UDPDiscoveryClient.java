/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2pchatsystem.main.model;

/**
 *
 * @author macbook
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDiscoveryClient {
   
    public static void bonjour(String nom) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress broadcastAddress = InetAddress.getByName(UDPDiscoveryClient.getBroadcastAddress()); // Utiliser l'adresse de broadcast
        
        String message = "bonjour nom="+nom;

        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), broadcastAddress, 12345);
        socket.send(packet);
        System.out.println("Message ENVOYÉ");

        socket.close();
    }
    

    static void response(String hostAddress, String nom) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress broadcastAddress = InetAddress.getByName(hostAddress); // Utiliser l'adresse de broadcast
        
        String message = "salut nom="+nom;

        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), broadcastAddress, 12345);
        socket.send(packet);
        System.out.println("Message ENVOYÉ");

        socket.close();
    }

    static void aurevoir() throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress broadcastAddress = InetAddress.getByName(UDPDiscoveryClient.getBroadcastAddress()); // Utiliser l'adresse de broadcast
        //
        
        String message = "bye";

        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), broadcastAddress, 12345);
        socket.send(packet);
        System.out.println("Message ENVOYÉ");

        socket.close();
    }
    
    public static String getBroadcastAddress() {
        String os = System.getProperty("os.name").toLowerCase();
        
        if (os.contains("mac")) {
            return "255.255.255.255";
        } else if (os.contains("win")) {
            try {
                String monIp = InetAddress.getLocalHost().getHostAddress();
                String[] ipParts = monIp.split("\\.");
                if (ipParts.length == 4) {
                    return ipParts[0] + "." + ipParts[1] + "." + ipParts[2] + ".255";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return "Unknown";
    }
}