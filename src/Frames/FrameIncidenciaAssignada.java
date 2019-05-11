/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Auxiliar.MetodesGenerals;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import Metodes.MetodesIncidencia;
import Classes.Incidencia;
import javax.swing.JOptionPane;
import Frames.FrameAtraccionsModificar;

/**
 *
 * @author alumne
 */
public class FrameIncidenciaAssignada extends javax.swing.JFrame {
    private String sql = "select incidencies.id, titol, descripcio, nom_prioritat, nom_estat, users.nom, users.cognom1, users.email from incidencies, estat_incidencies, tipus_prioritat, users where users.id = incidencies.id_usuari_assignat and id_prioritat=tipus_prioritat.id and estat_incidencies.id= id_estat";

    /**
     * Creates new form FrameAtraccionsInicial
     */
    public FrameIncidenciaAssignada() {
        initComponents();
        carregarGUI();
    }

    private void carregarGUI() {
        this.setSize(450, 350);
        JScrollPane pane = new JScrollPane(this.getContentPane());
        this.setContentPane(pane);
        this.setLocationRelativeTo(null);

        MetodesGenerals.loadTable(incidentTable,sql);
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
        addBtn = new javax.swing.JButton();
        filterField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        incidentTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        incidentDelete = new javax.swing.JButton();
        incidentUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Incidències - assignades");

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/plus_small.png"))); // NOI18N
        addBtn.setText("Afegir");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        filterField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterFieldKeyReleased(evt);
            }
        });

        incidentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        incidentTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(incidentTable);

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel_small.png"))); // NOI18N
        backBtn.setText("Enrere");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        incidentDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete_small.png"))); // NOI18N
        incidentDelete.setText("Eliminar");
        incidentDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incidentDeleteActionPerformed(evt);
            }
        });

        incidentUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit_small.png"))); // NOI18N
        incidentUpdate.setText("Modificar");
        incidentUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incidentUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(addBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(incidentUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(incidentDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(addBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(incidentDelete)
                    .addComponent(incidentUpdate))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        FrameIncidenciaInserir fai = new FrameIncidenciaInserir();
        this.setVisible(false);
        fai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        FrameIncidenciaInicial fi = new FrameIncidenciaInicial();
        this.setVisible(false);
        fi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void incidentUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incidentUpdateActionPerformed
        // TODO add your handling code here:
        int filaseleccionada = incidentTable.getSelectedRow();

        try {

            String id;
            String titol;
            String descripcio;
            String id_prioritat;
            String id_estat;

            if (filaseleccionada == -1) {

                JOptionPane.showMessageDialog(null, "Selecciona una incidencia per a poder modificar-la", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {

                id = incidentTable.getValueAt(filaseleccionada, 0).toString();
                titol = incidentTable.getValueAt(filaseleccionada, 1).toString();
                descripcio = incidentTable.getValueAt(filaseleccionada, 2).toString();
                id_prioritat = incidentTable.getValueAt(filaseleccionada, 3).toString();
                id_estat = incidentTable.getValueAt(filaseleccionada, 4).toString();
                String user_assignat = incidentTable.getValueAt(filaseleccionada, 5).toString() + " " + incidentTable.getValueAt(filaseleccionada, 6).toString() + " - " + incidentTable.getValueAt(filaseleccionada,7).toString();
                System.out.println(user_assignat);

                FrameIncidenciaModificar fi = new FrameIncidenciaModificar(id, titol, descripcio, id_prioritat, id_estat, user_assignat);
                this.setVisible(false);
                fi.setVisible(true);
                this.dispose();
            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_incidentUpdateActionPerformed

    private void incidentDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incidentDeleteActionPerformed

        int filaseleccionada = incidentTable.getSelectedRow();

        try {
            if (filaseleccionada == -1) {

                JOptionPane.showMessageDialog(null, "Selecciona una incidencia per a poder eliminar-la", "Advertencia", JOptionPane.WARNING_MESSAGE);

            } else {

                String idIncident = incidentTable.getValueAt(filaseleccionada, 0).toString();
                int idIncidencia = Integer.parseInt(idIncident);
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "Estas segur que vols eliminar l'incidència", "Confirma per a eliminar", dialogButton);

                if (dialogResult == 0) {

                    MetodesIncidencia.deleteIncident(idIncidencia);
                    MetodesGenerals.loadTable(incidentTable,sql);

                } else {
                    JOptionPane.showMessageDialog(null, "Incidència no eliminada", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_incidentDeleteActionPerformed

    private void filterFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterFieldKeyReleased
        String keyword = "(?i)" + filterField.getText();
        MetodesGenerals.filterTable(incidentTable, keyword);
    }//GEN-LAST:event_filterFieldKeyReleased

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
            java.util.logging.Logger.getLogger(FrameIncidenciaAssignada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameIncidenciaAssignada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameIncidenciaAssignada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameIncidenciaAssignada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameIncidenciaAssignada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField filterField;
    private javax.swing.JButton incidentDelete;
    private javax.swing.JTable incidentTable;
    private javax.swing.JButton incidentUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}