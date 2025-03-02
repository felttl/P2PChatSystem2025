package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import views.EnterV;
import views.MainV;

/**
 *
 * @author felixmacos
 */

public class P2PChatSystem {

    private static JFrame currentV;

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
                System.out.println(buttonTitle);
                if(buttonTitle.equals(defaultInputTxt)) {
                    JOptionPane.showMessageDialog(
                        null,
                        "you must choose a new name not default one :\""+defaultInputTxt+"\"",
                        "bad name !",
                        JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    currentV.dispose();
                    P2PChatSystem.currentV=new MainV();
                    P2PChatSystem.currentV.setVisible(true);
                }
            }
        });
        // update button with the event into the view
        ((EnterV) currentV).setEntrerJB(enterJB);
    }

}
