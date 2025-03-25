package p2pchatsystem.main.views;

import java.util.concurrent.CountDownLatch;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author felixmacos
 */
public class EnterV extends javax.swing.JFrame {

    private static EnterV enterV = null;
    /**
     * Creates new form P2PChatSysGUIMade
     */
    public EnterV() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regeneratsed by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameJTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        enterJB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("P2PChatSystem");
        setBackground(new java.awt.Color(153, 204, 255));
        setPreferredSize(new java.awt.Dimension(510, 400));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        nameJTF.setFont(new java.awt.Font("JetBrains Mono", 0, 13)); // NOI18N
        nameJTF.setForeground(new java.awt.Color(0, 51, 204));
        nameJTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nameJTF.setText("Enter your name");
        nameJTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTFActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 63, 65));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html> you cannot change<br> your name, be sure </html> ");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        enterJB.setBackground(new java.awt.Color(0, 153, 0));
        enterJB.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        enterJB.setForeground(new java.awt.Color(255, 255, 255));
        enterJB.setText("Enter");
        enterJB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enterJBMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(60, 63, 65));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Software developed by the L3 students");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p2pchatsystem/main/views/Logo Université.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(enterJB, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameJTF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterJB)
                .addGap(18, 18, 18)
                .addComponent(jLabel2))
        );

        jLabel2.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel3);
        jPanel3.setBounds(120, 40, 290, 310);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p2pchatsystem/main/views/uppa_site.png"))); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(500, 390));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 520, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterJBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterJBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_enterJBMouseClicked

    private void nameJTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTFActionPerformed


    public static EnterV getEnterV() {
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
            java.util.logging.Logger.getLogger(EnterV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        // Create a latch that will count down when the GUI is ready
        final CountDownLatch latch = new CountDownLatch(1);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EnterV.enterV = new EnterV();
                EnterV.enterV.setVisible(true);
                latch.countDown();
            }
        });
        // wait the variable to be returned
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("GUI generated Form(by Netbeans) \"EnterV\" cannot be loaded: "+e);
        }
        return EnterV.enterV; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enterJB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nameJTF;
    // End of variables declaration//GEN-END:variables

    public JButton getEntrerJB() {
        return enterJB;
    }

    public void setEntrerJB(JButton entrerJB) {
        this.enterJB = entrerJB;
    }

    public JTextField getNameJTF() {
        return nameJTF;
    }

    public void setNameJTF(JTextField nameJTF) {
        this.nameJTF = nameJTF;
    }

}
