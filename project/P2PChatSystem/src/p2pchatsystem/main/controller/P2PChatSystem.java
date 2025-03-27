package p2pchatsystem.main.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    try {
                        // changing view to main
                        objUDP = new UDPDiscoveryServer(12345);
                    } catch (Exception ex) {
                        Logger.getLogger(P2PChatSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    objUDP.start();
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
                    
                    
                    DefaultListModel<String> listModel = new DefaultListModel<>();
                    JList<String> ipList = ((MainV) P2PChatSystem.currentV).getUsersListJL();
                    ipList.setModel(listModel);
                    ipList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                    // Ajout des IPs
                    List<String> availableIPs = objUDP.getIPs();
                    for (String ip : availableIPs) {
                        listModel.addElement(ip);
                    }
                    

                    JTextArea messageArea = ((MainV) P2PChatSystem.currentV).getjAffichageArea();
                    new Thread(() -> TCPServer.lancerServeurPort1(messageArea)).start();
                    new Thread(() -> TCPServer.lancerServeurPort2(messageArea)).start();


                    JButton sendJB = ((MainV) P2PChatSystem.currentV).getSendJB();
                    // Action à exécuter lors de l'envoi d'un message
                    sendJB.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedUser = ipList.getSelectedValue();  // IP sélectionnée
                        System.out.println("Selected IP: " + selectedUser);
                        if (selectedUser != null) {
                            String message = ((MainV) P2PChatSystem.currentV).getUserTextJBA().getText().trim();
                            if (!message.isEmpty()) {
                                try {
                                    // Envoyer le message via le client TCP
                                    List<String> smallest = objUDP.getSmallerIPs();
                                    if(smallest.contains(selectedUser)){
                                        TCPClient.envoyerMessage(selectedUser, message, 50001);
                                    }else{
                                        TCPClient.envoyerMessage(selectedUser, message, 50000);
                                    }

                                    // Effacer le texte après l'envoi
                                    ((MainV) P2PChatSystem.currentV).getUserTextJBA().setText("");
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(currentV, "Veuillez saisir un message.", "Erreur", JOptionPane.ERROR_MESSAGE);
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
                                try {
                                    objUDP.deconnexion();
                                } catch (IOException ex) {}
                                byeButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        System.exit(0);
                                    }
                                });
                            }
                        }
                    });
                    // Mettre à jour la liste des IPs disponibles
                        new Thread(() -> {
                            while (true) {
                                try {
                                    Thread.sleep(5000);
                                    List<String> updatedIPs = objUDP.getIPs();
                                    SwingUtilities.invokeLater(() -> {
                                        // Supprimer les IPs non disponibles
                                        List<String> ipsToRemove = new ArrayList<>();
                                        for (int i = 0; i < listModel.size(); i++) {
                                            String currentIP = listModel.get(i);
                                            if (!updatedIPs.contains(currentIP)) {
                                                ipsToRemove.add(currentIP);
                                            }
                                        }

                                        // Supprimer les IPs non disponibles
                                        for (String ip : ipsToRemove) {
                                            listModel.removeElement(ip);
                                        }

                                        // Ajouter les nouvelles IPs
                                        for (String ip : updatedIPs) {
                                            if (!listModel.contains(ip)) {
                                                listModel.addElement(ip);
                                            }
                                        }
                                    });

                                } catch (InterruptedException er) {
                                    er.printStackTrace();
                                }
                            }
                        }).start();


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
