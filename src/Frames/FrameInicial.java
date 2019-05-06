/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

/**
 *
 * @author alumne
 */
public class FrameInicial extends javax.swing.JFrame {

    /**
     * Creates new form FrameInicial
     */
    public FrameInicial() {
        initComponents();
        carregarGUI();
    }
    
    private void carregarGUI() {
        this.setSize(450, 350);
        JScrollPane pane = new JScrollPane(this.getContentPane());
        this.setContentPane(pane);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLbl = new javax.swing.JLabel();
        clientsBtn = new javax.swing.JButton();
        employeesBtn = new javax.swing.JButton();
        atraccionsBtn = new javax.swing.JButton();
        incidenciesBtn = new javax.swing.JButton();
        tiquetsBtn = new javax.swing.JButton();
        configBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Univeylandia Parc - Inici");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        titleLbl.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        titleLbl.setText("Gestió del parc Univeylandia");

        clientsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/clients_small.png"))); // NOI18N
        clientsBtn.setText("Clients");
        clientsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsBtnActionPerformed(evt);
            }
        });

        employeesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/employee_small.png"))); // NOI18N
        employeesBtn.setText("Treballadors");
        employeesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesBtnActionPerformed(evt);
            }
        });

        atraccionsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/roller_small.png"))); // NOI18N
        atraccionsBtn.setText("Atraccions");
        atraccionsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atraccionsBtnActionPerformed(evt);
            }
        });

        incidenciesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/incidence_small.png"))); // NOI18N
        incidenciesBtn.setText("Incidències");
        incidenciesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incidenciesBtnActionPerformed(evt);
            }
        });

        tiquetsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ticket_small.png"))); // NOI18N
        tiquetsBtn.setText("Tiquets");
        tiquetsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiquetsBtnActionPerformed(evt);
            }
        });

        configBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/settings_small.png"))); // NOI18N
        configBtn.setText("Configuració");
        configBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configBtnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo_small.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(configBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleLbl)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(clientsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(employeesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(atraccionsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(incidenciesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tiquetsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(108, 108, 108)))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atraccionsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(incidenciesBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tiquetsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(configBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configBtnActionPerformed
        try {
            FrameConfiguracio fc = new FrameConfiguracio();
            this.setVisible(false);
            fc.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(FrameInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_configBtnActionPerformed

    private void atraccionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atraccionsBtnActionPerformed
        FrameAtraccionsInicial fai = new FrameAtraccionsInicial();
        this.setVisible(false);
        fai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_atraccionsBtnActionPerformed

    private void incidenciesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incidenciesBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_incidenciesBtnActionPerformed

    private void tiquetsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiquetsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiquetsBtnActionPerformed

    private void clientsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientsBtnActionPerformed

    private void employeesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesBtnActionPerformed
        FrameEmpleatsInicial fai = new FrameEmpleatsInicial();
        this.setVisible(false);
        fai.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_employeesBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atraccionsBtn;
    private javax.swing.JButton clientsBtn;
    private javax.swing.JButton configBtn;
    private javax.swing.JButton employeesBtn;
    private javax.swing.JButton incidenciesBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton tiquetsBtn;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
