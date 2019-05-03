/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Auxiliar.DBConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import Auxiliar.AES;

/**
 *
 * @author alumne
 */
public class FrameConfiguracio extends javax.swing.JFrame {
    public static final String directoriConfig = "config/";
    public static final String arxiuConfig = "conf.txt";
    final String secretKey = "ssssssssssssssssssssssssas?";
    
    /**
     * Creates new form FrameConfiguracio
     */
    public FrameConfiguracio() throws IOException {
        initComponents();
        carregarGUI();       
    }
    
    private void carregarGUI() throws IOException {
        this.setSize(450, 350);
        JScrollPane pane = new JScrollPane(this.getContentPane());
        this.setContentPane(pane);
        this.setLocationRelativeTo(null);
        /** CARREGAR DADES CONFIG */
        try{
            BufferedReader saveFile= new BufferedReader(new FileReader(directoriConfig + arxiuConfig));
            hostField.setText(saveFile.readLine()); 
            databaseField.setText(saveFile.readLine());
            userField.setText(saveFile.readLine());
            passwordField.setText(AES.decrypt(saveFile.readLine(), secretKey));
            saveFile.close();
        }catch (FileNotFoundException e){
            System.out.println ("Error al carregar la configuració: " + e);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        hostField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        databaseField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        provarConnexioButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Univeylandia Parc - Configuració");

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Configuració");

        jLabel2.setText("Host");

        jLabel3.setText("Base de dades");

        jLabel4.setText("Usuari");

        jLabel5.setText("Contrasenya");

        backBtn.setText("Enrere");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        submitBtn.setText("Acceptar");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        provarConnexioButton.setText("Provar connexió");
        provarConnexioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provarConnexioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField)
                    .addComponent(hostField)
                    .addComponent(databaseField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submitBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backBtn))
                    .addComponent(userField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 299, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(provarConnexioButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(provarConnexioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(databaseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addComponent(submitBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        FrameInicial fi = new FrameInicial();
        this.setVisible(false);
        fi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        new File("config").mkdirs();
        String emptyFields = "\n";
        try{
            if(hostField.getText().isEmpty() || databaseField.getText().isEmpty() || userField.getText().isEmpty() || passwordField.getText().isEmpty()){
                if(hostField.getText().isEmpty()){ emptyFields = emptyFields + "- Host\n";}
                if (databaseField.getText().isEmpty()){emptyFields = emptyFields + "- Base de dades\n";}
                if (userField.getText().isEmpty()){emptyFields = emptyFields + "- Usuari\n";}
                if (passwordField.getText().isEmpty()){emptyFields = emptyFields + "- Contrasenya\n";}
                JOptionPane.showMessageDialog(this, "Hi han camps sense omplir: " + emptyFields);
            }else{
                FileWriter saveFile = new FileWriter(directoriConfig + arxiuConfig);
                saveFile.write(hostField.getText() + "\n");
                saveFile.write(databaseField.getText() + "\n");
                saveFile.write(userField.getText() + "\n");
                //System.out.println(passwordField.getText() + "empty: " + passwordField.getText().isEmpty());
                saveFile.write(AES.encrypt(passwordField.getText(), secretKey) + "\n");
                saveFile.close();
                JOptionPane.showMessageDialog(this, "Configuració guardada correctament");
            }
         }catch (Exception e){
            //System.out.println("Error: " + e);
            if(!Files.exists(Paths.get(directoriConfig))) { 
                JOptionPane.showMessageDialog(this, "No s'ha pogur crear el directori de configuració");
            }
            else if (!Files.exists(Paths.get(directoriConfig + arxiuConfig))) {
                JOptionPane.showMessageDialog(this, "No s'ha pogur crear l'arxiu de configuració");
            }
            else if(!Files.isWritable(Paths.get(directoriConfig + arxiuConfig))){
                JOptionPane.showMessageDialog(this, "No es tenen permisos d'escriptura sobre l'arxiu de configuració");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al guardar la configuració: " + e);
            } 
         } 
    }//GEN-LAST:event_submitBtnActionPerformed

    private void provarConnexioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provarConnexioButtonActionPerformed
        DBConnection connexio = new DBConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try{    
            statement = connexio.getConnection().createStatement();
            JOptionPane.showMessageDialog(this, "Connexió correcta");
        }catch (Exception e){
            if(!Files.exists(Paths.get(directoriConfig))) { 
                JOptionPane.showMessageDialog(this, "No existeix el directori de configuració");
            }
            else if (!Files.exists(Paths.get(directoriConfig + arxiuConfig))) {
                JOptionPane.showMessageDialog(this, "No existeix l'arxiu de configuració");
            }
            else if(!Files.isReadable(Paths.get(directoriConfig + arxiuConfig))){
                JOptionPane.showMessageDialog(this, "No es tenen permisos de lectura sobre l'arxiu de configuració");
            }
            else{
                JOptionPane.showMessageDialog(this, "Error al realitzar la connexió: " + e);
            }
        }finally{
            try {
                statement.close();
                connexio.disconnect();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_provarConnexioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FrameConfiguracio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameConfiguracio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameConfiguracio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameConfiguracio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrameConfiguracio().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FrameConfiguracio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField databaseField;
    private javax.swing.JTextField hostField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton provarConnexioButton;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
