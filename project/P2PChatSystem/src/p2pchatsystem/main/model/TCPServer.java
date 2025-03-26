/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2pchatsystem.main.model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.util.ArrayList;
/**
 *
 * @author macbook
 */
public class TCPServer extends Thread {
    private Socket clientSocket;

    public TCPServer(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while (true) {
                message = reader.readLine();
                if (message.equals("Bye")) {
                    break;
                }
                System.out.println(message);
            }

            reader.close();
            writer.close();
            clientSocket.close(); 
        } catch (IOException e) {
            System.err.println("Erreur dans le thread: " + e.getMessage());
        }
    }

    public static void lancerServeur() {
        try {
            ArrayList<TCPServer> listThread = new ArrayList<>();
            ServerSocket serverSocket = new ServerSocket(8585);
            System.out.println("Serveur lancé");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection établie avec " + clientSocket.getInetAddress());

                TCPServer task = new TCPServer(clientSocket);
                listThread.add(task);
                task.start();
            }
            // serverSocket.close(); // Cette ligne a été retirée pour éviter de fermer le serveur après la première connexion
        } catch (Exception e) {
            System.err.println("ERREUR " + e.getMessage());
        }
    }
}