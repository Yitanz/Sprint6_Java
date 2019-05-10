package Frames;

import Auxiliar.MetodesGenerals;
import Auxiliar.SharedData;
import Classes.Client;
import Classes.MetodesClient;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

/**
 *
 * @author alumne
 */
public class FrameClientsInicial extends javax.swing.JFrame {

    int clic_tabla = 0;
    int posicioTaula[]; 
    String borrar_numero;

    public FrameClientsInicial() {
        initComponents();
        carregarGUI();
    }

    private void carregarGUI() {
        this.setSize(450, 350);
        JScrollPane pane = new JScrollPane(this.getContentPane());
        this.setContentPane(pane);
        this.setLocationRelativeTo(null);
        /* Per defecte desactivar els botons */
        showBtn.setEnabled(false);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        
        MetodesGenerals.loadTable(resultTable, Client.getQuerySelect());
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
        resultTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        showBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Univeylandia Parc - Client");

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Clients");

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/plus_small.png"))); // NOI18N
        addBtn.setText("Afegir");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        filterField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterFieldActionPerformed(evt);
            }
        });
        filterField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterFieldKeyReleased(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        resultTable.getTableHeader().setReorderingAllowed(false);
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resultTable);

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel_small.png"))); // NOI18N
        backBtn.setText("Enrere");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        showBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/eye_small.png"))); // NOI18N
        showBtn.setText("Mostrar");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit_small.png"))); // NOI18N
        editBtn.setText("Modificar");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete_small.png"))); // NOI18N
        deleteBtn.setText("Eliminar");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                        .addComponent(addBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(showBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
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
                    .addComponent(showBtn)
                    .addComponent(editBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        FrameClientInserir fai = new FrameClientInserir();
        this.setVisible(false);
        fai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        FrameInicial fi = new FrameInicial();
        this.setVisible(false);
        fi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void resultTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultTableMouseClicked
        // TODO add your handling code here:
        showBtn.setEnabled(true);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        
    }//GEN-LAST:event_resultTableMouseClicked

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        // TODO add your handling code here:
        int columna = 2;
        int fila = resultTable.getSelectedRow();
        String client = resultTable.getModel().getValueAt(fila, columna).toString();

        SharedData.setClientNumeroDocument(client);

        System.out.println(client);

        FrameClientMostrar famo = new FrameClientMostrar();
        this.setVisible(false);
        famo.setVisible(true);
    }//GEN-LAST:event_showBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        int columna = 2;
        int fila = resultTable.getSelectedRow();
        String client = resultTable.getModel().getValueAt(fila, columna).toString();

        SharedData.setClientNumeroDocument(client);

        System.out.println(client);

        FrameClientModificar famos = new FrameClientModificar();
        this.setVisible(false);
        famos.setVisible(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        try {
            posicioTaula = resultTable.getSelectedRows();                       //Iguales la array de la posicio de la taula a les files seleccionades

            if (posicioTaula.length > 1) {                                      //Alerta per evitar errors de mes de una fila seleccionada
                JOptionPane.showMessageDialog(null, "Nomes pots seleccionar una fila");
            } else {
                borrar_numero = resultTable.getValueAt(resultTable.getSelectedRow(), 2).toString();
            }
            } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", " .::Error En la Operacion::.", JOptionPane.ERROR_MESSAGE);  //Mostrar error amb JOption
        }
        
        int input = JOptionPane.showConfirmDialog(null,
                "Estàs segur de voler eliminar el registre: ", "Eliminar client", JOptionPane.OK_CANCEL_OPTION);
        
        if (input == 0) {
            Client users = new Client();                                            //Crear un nou usuari de tipus client
            users.setNumero_document(borrar_numero);                                //Seleccionar el ID cargat i enviar-ho
            try {
                MetodesClient.eliminarClient(users);                                //Cridar al metode de eliminar client, passar el user
            } catch (SQLException ex) {
                Logger.getLogger(FrameClientsInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        MetodesGenerals.loadTable(resultTable, Client.getQuerySelect());
        showBtn.setEnabled(false);
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void filterFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterFieldActionPerformed

    private void filterFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterFieldKeyReleased
        // TODO add your handling code here:
        String keyword = "(?i)"+filterField.getText();
        MetodesGenerals.filterTable(resultTable, keyword);
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
            java.util.logging.Logger.getLogger(FrameClientsInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameClientsInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameClientsInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameClientsInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameClientsInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField filterField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable resultTable;
    private javax.swing.JButton showBtn;
    // End of variables declaration//GEN-END:variables
}
