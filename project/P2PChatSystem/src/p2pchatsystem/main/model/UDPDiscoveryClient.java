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
   
    public static void bonjour() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress broadcastAddress = InetAddress.getByName("255.255.255.255"); // Utiliser l'adresse de broadcast
        //
        
        String message = "bonjour";

        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), broadcastAddress, 12345);
        socket.send(packet);
        System.out.println("Message ENVOYÉ");

        socket.close();
    }
    

    static void response(String hostAddress) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress broadcastAddress = InetAddress.getByName(hostAddress); // Utiliser l'adresse de broadcast
        
        String message = "salut";

        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), broadcastAddress, 12345);
        socket.send(packet);
        System.out.println("Message ENVOYÉ");

        socket.close();
    }
}