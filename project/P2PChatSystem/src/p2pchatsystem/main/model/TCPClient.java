/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2pchatsystem.main.model;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
/**
 *
 * @author macbook
 */
public class TCPClient extends Thread {
    private Socket clientSocket;
    private PrintWriter writer;
    private static ArrayList<TCPClient> listThread = new ArrayList<>();
    

    public TCPClient(Socket socket) {
        this.clientSocket = socket;
        try {
            this.writer = new PrintWriter(clientSocket.getOutputStream(), true);  // Initialisation correcte
        } catch (IOException e) {
            System.err.println("Erreur lors de l'initialisation du PrintWriter: " + e.getMessage());
        }
    }

    public static void envoyerMessage(String id, String message, int port) throws IOException {
        Socket clientSocket = new Socket(id, port);
        System.out.println("CONNEXION EN TANT QUE CLIENT TCP");

        TCPClient task = new TCPClient(clientSocket);
        listThread.add(task);
        task.start();

        // Assurez-vous que le writer est correctement initialisé avant d'envoyer un message
        if (task.writer != null) {
            task.writer.println(message);  // Envoi du message
        } else {
            System.err.println("Erreur: Le writer n'a pas été initialisé correctement !");
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message;
            while ((message = reader.readLine()) != null) {
                if (message.equals("Bye")) {
                    break;
                }
                System.out.println(message);  // Affichage du message reçu
            }

            reader.close();
            writer.close();
            clientSocket.close();
        } catch (Exception e) {
            System.err.println("ERREUR " + e.getMessage());
        }
    }

    public static ArrayList<TCPClient> getLesThreads() {
        return listThread;
    }
}
