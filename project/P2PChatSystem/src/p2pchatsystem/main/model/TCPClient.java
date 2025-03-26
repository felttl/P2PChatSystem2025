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
import java.util.Scanner;
/**
 *
 * @author macbook
 */
public class TCPClient {
    public static void envoyerMessage() throws IOException{
        boolean envoie = true;
        String message;
        Scanner scanner = new Scanner( System.in );
        
        Socket clientSocket = new Socket("10.8.27.88",8585);
        //"192.168.1.18",8585
        //"192.168.1.29",12345
        //10.8.27.88
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        
        while(envoie == true){
            System.out.println("\n");
            message = scanner.nextLine();
            if(message.contentEquals("stop")){
               envoie = false;
               message = "Bye";
            }
            writer.println(message);
        }
        
        reader.close();
        writer.close();
            
        //Fin connection client
        clientSocket.close();
        
    }
}
