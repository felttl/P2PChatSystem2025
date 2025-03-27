/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2pchatsystem.main.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author macbook
 */
public class TCPServer extends Thread {
    private Socket clientSocket;
    private static JTextArea messageArea;  // Référence vers la zone de texte dans l'interface graphique
    private String ip;
    private int port;

    public TCPServer(Socket socket, JTextArea messageArea, int port) {
        this.clientSocket = socket;
        this.messageArea = messageArea;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            String message;
            while ((message = reader.readLine()) != null) {
                if (message.equals("Bye")) {
                    break;
                }
                // Affichage du message dans la fenêtre
                final String finalMessage = message;
                SwingUtilities.invokeLater(() -> messageArea.append("Message reçu: " + finalMessage + "\n"));
            }

            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Erreur dans le thread serveur : " + e.getMessage());
        }
    }

    public static void lancerServeurPort1(JTextArea messageArea) {
        try {
            ServerSocket serverSocket = new ServerSocket(50000);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection établie avec " + clientSocket.getInetAddress());

                TCPServer task = new TCPServer(clientSocket, messageArea, 50000);
                task.start();
            }
        } catch (IOException e) {
            System.err.println("Erreur dans le serveur : " + e.getMessage());
        }
    }
    
    public static void lancerServeurPort2(JTextArea messageArea) {
        try {
            ServerSocket serverSocket = new ServerSocket(50001);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection établie avec " + clientSocket.getInetAddress());

                TCPServer task = new TCPServer(clientSocket, messageArea, 50001);
                task.start();
            }
        } catch (IOException e) {
            System.err.println("Erreur dans le serveur : " + e.getMessage());
        }
    }
}