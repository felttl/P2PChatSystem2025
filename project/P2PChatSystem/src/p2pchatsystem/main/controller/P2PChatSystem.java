package p2pchatsystem.main.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import p2pchatsystem.main.model.TCPClient;
import p2pchatsystem.main.model.TCPServer;
import p2pchatsystem.main.model.UDPDiscoveryServer;

import p2pchatsystem.main.views.EnterV;
import p2pchatsystem.main.views.MainV;
import p2pchatsystem.main.views.LeaveV;

/**
 *
 * @author felixmacos
 */

public class P2PChatSystem {

    private static JFrame currentV;
    private static String username = "";
    private static UDPDiscoveryServer objUDP;

    public static void main(String[] args) {
        // when the user comes (we change that view later)
        P2PChatSystem.currentV = EnterV.getEnterV();
        // when username is ok move on
        JButton enterJB = ((EnterV) P2PChatSystem.currentV).getEntrerJB();
        String defaultInputTxt = ((EnterV) P2PChatSystem.currentV).getNameJTF().getText();
        enterJB.addActionListener(new ActionListener() {
            /**
             * when the user clic on the button
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if input is okay
                String buttonTitle = ((EnterV) P2PChatSystem.currentV).getNameJTF().getText();
                if(buttonTitle.equals(defaultInputTxt)) {
                    JOptionPane.showMessageDialog(
                        null,
                        "you must choose a new name not default one :\""+defaultInputTxt+"\"",
                        "bad name !",
                        JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    // changing view to main
                    currentV.dispose();
                    P2PChatSystem.currentV=new MainV();
                    P2PChatSystem.currentV.setVisible(true);
                    // create a "dynamic" JList
                    //
                    // load title
                    JLabel convWithName = ((MainV) P2PChatSystem.currentV).getConnectedNameJL();
                    convWithName.setText(""); // empty
                    // load username
                    JLabel userName = ((MainV) P2PChatSystem.currentV).getUserNameFirstLetterJL();
                    userName.setText(buttonTitle);
                    P2PChatSystem.username = buttonTitle;
                    
                    
                    // Ajouter les IPs détectées dans la liste
                    List<String> availableIPs = objUDP.getIPs();
                    for (String ip : availableIPs) {
                        listModel.addElement(ip);
                    }

                    JTextArea messageArea = ((MainV) P2PChatSystem.currentV).getUserTextJBA();
                    new Thread(() -> TCPServer.lancerServeurPort1(messageArea)).start();
                    new Thread(() -> TCPServer.lancerServeurPort2(messageArea)).start();


                    JButton sendJB = ((MainV) P2PChatSystem.currentV).getSendJB();
                    JList<String> usersList = ((MainV) P2PChatSystem.currentV).getUsersListJL();
                    // Action à exécuter lors de l'envoi d'un message
                    sendJB.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String selectedUser = usersList.getSelectedValue();  // IP sélectionnée
                            if (selectedUser != null) {
                                if (message != null && !message.isEmpty()) {
                                    try {
                                        // Envoyer le message via le client TCP
                                        List<String> smallest = objUDP.getSmallerIPs();
                                        if(smallest.contains(selectedUser)){
                                            TCPClient.envoyerMessage(selectedUser, message, 50001);
                                        }else{
                                            TCPClient.envoyerMessage(selectedUser, message, 50000);
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(currentV, "Veuillez sélectionner une IP.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    

                    JButton leaveButton = ((MainV) P2PChatSystem.currentV).getLeaveBtn();
                    leaveButton.addActionListener(new ActionListener() {
                        /**
                         * if the user wants to leave
                         * @param e the event to be processed
                         */
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // warning box
                            int result = JOptionPane.showConfirmDialog(
                                null,
                                "Do you really want to leave?",
                                "Information",
                                JOptionPane.YES_NO_OPTION
                            );
                            if (result == JOptionPane.YES_OPTION) {
                                currentV.dispose();
                                P2PChatSystem.currentV = new LeaveV();
                                P2PChatSystem.currentV.setVisible(true);
                                JButton byeButton = ((LeaveV) P2PChatSystem.currentV).getBye();
                                byeButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        System.exit(0);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
        // update button with the event into the view
        ((EnterV) currentV).setEntrerJB(enterJB);
    }
    public static String getUsername(){
        return username;
    }

}
