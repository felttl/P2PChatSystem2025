package p2pchatsystem.main.views;

import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author felixmacos
 */
public class MainV extends javax.swing.JFrame {

    /**
     * Creates new form MainListGUIMade
     */
    public MainV() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser3 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersListJL = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTextJBA = new javax.swing.JTextArea();
        sendJB = new javax.swing.JButton();
        connectedNameJL = new javax.swing.JLabel();
        userNameFirstLetterJL = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        leaveBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usersListJL.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(usersListJL);

        userTextJBA.setColumns(20);
        userTextJBA.setFont(new java.awt.Font("JetBrains Mono", 0, 13)); // NOI18N
        userTextJBA.setRows(5);
        userTextJBA.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(userTextJBA);

        sendJB.setBackground(new java.awt.Color(0, 153, 0));
        sendJB.setFont(new java.awt.Font("JetBrains Mono", 0, 13)); // NOI18N
        sendJB.setForeground(new java.awt.Color(255, 255, 255));
        sendJB.setText("Send");
        sendJB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendJBActionPerformed(evt);
            }
        });

        connectedNameJL.setFont(new java.awt.Font("JetBrains Mono", 0, 13)); // NOI18N
        connectedNameJL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        connectedNameJL.setLabelFor(this);
        connectedNameJL.setText("prototypeConnectedToName");

        userNameFirstLetterJL.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        userNameFirstLetterJL.setText("userNameProto");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        leaveBtn.setForeground(new java.awt.Color(255, 51, 51));
        leaveBtn.setText("Leave ?");
        leaveBtn.setActionCommand("Leave");
        leaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leaveButton(evt);
            }
        });

        jButton2.setText("+ file");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(leaveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connectedNameJL, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userNameFirstLetterJL, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sendJB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectedNameJL, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameFirstLetterJL)
                    .addComponent(leaveBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendJB))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        leaveBtn.getAccessibleContext().setAccessibleName("Leave");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendJBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendJBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendJBActionPerformed

    private void leaveButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaveButton
        // TODO add your handling code here:
    }//GEN-LAST:event_leaveButton

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel connectedNameJL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton leaveBtn;
    private javax.swing.JButton sendJB;
    private javax.swing.JLabel userNameFirstLetterJL;
    private javax.swing.JTextArea userTextJBA;
    private javax.swing.JList<String> usersListJL;
    // End of variables declaration//GEN-END:variables

    public JButton getLeaveBtn() {
        return leaveBtn;
    }

    public void setLeaveBtn(JButton leaveBtn) {
        this.leaveBtn = leaveBtn;
    }

    public JFileChooser getjFileChooser1() {
        return jFileChooser1;
    }

    public void setjFileChooser1(JFileChooser jFileChooser1) {
        this.jFileChooser1 = jFileChooser1;
    }

    public JLabel getConnectedNameJL() {
        return connectedNameJL;
    }

    public void setConnectedNameJL(JLabel connectedNameJL) {
        this.connectedNameJL = connectedNameJL;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JFileChooser getjFileChooser3() {
        return jFileChooser3;
    }

    public void setjFileChooser3(JFileChooser jFileChooser3) {
        this.jFileChooser3 = jFileChooser3;
    }

    public JList<String> getjList1() {
        return jList1;
    }

    public void setjList1(JList<String> jList1) {
        this.jList1 = jList1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JButton getSendJB() {
        return sendJB;
    }

    public void setSendJB(JButton sendJB) {
        this.sendJB = sendJB;
    }

    public JLabel getUserNameFirstLetterJL() {
        return userNameFirstLetterJL;
    }

    public void setUserNameFirstLetterJL(JLabel userNameFirstLetterJL) {
        this.userNameFirstLetterJL = userNameFirstLetterJL;
    }

    public JTextArea getUserTextJBA() {
        return userTextJBA;
    }

    public void setUserTextJBA(JTextArea userTextJBA) {
        this.userTextJBA = userTextJBA;
    }

    public JList<String> getUsersListJL() {
        return usersListJL;
    }

    public void setUsersListJL(JList<String> usersListJL) {
        this.usersListJL = usersListJL;
    }
}
