package Frames;

import Auxiliar.MetodesGenerals;
import Auxiliar.SharedData;
import Classes.Ticket;
import Metodes.MetodesTicket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author GRUP2: Ferran Climent
 */
public class FrameTicketsModificar extends javax.swing.JFrame {

    String id_ticket;
    Statement statement = null;
    ResultSet resultSet = null;
    ResultSet resultTipus = null;

    /**
     * Creates new form FrameAtraccionsInserir
     */
    public FrameTicketsModificar() {
        initComponents();
        carregarGUI();
        dataCompra.setDateFormatString(MetodesGenerals.DATE_FORMAT);
    }

    private void carregarGUI() {
        this.setSize(500, 400);
        JScrollPane pane = new JScrollPane(this.getContentPane());
        this.setContentPane(pane);
        this.setLocationRelativeTo(null);
        CarregarDades();
    }

    /**
     * Metode per a cargar les variables del objecte de tipus Ticket.
     *
     */
    public void CarregarDades() {
        String idTicket = SharedData.getIdTicket();

        Ticket tck = MetodesTicket.getDadesTicket(idTicket, Ticket.getQueryShow());

        //System.out.println(tck.toString());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dataCompraT = null;
        try {
            //System.out.println(tck.getData_compra());
            dataCompraT = format.parse(tck.getData_compra());
        } catch (Exception ex) {
            Logger.getLogger(FrameAtraccionsMostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        NomComprador.setText(tck.getComprador());
        selectTipus.setText(tck.getTipus_ticket_string());
        numViatges.setValue(tck.getTickets_viatges());
        preu.setValue(tck.getPreu());
        selectEstat.setSelectedItem(tck.getEstat());
        dataCompra.setDate(dataCompraT);

        NomComprador.setEnabled(false);
        selectTipus.setEnabled(false);
        preu.setEnabled(false);
        dataCompra.setEnabled(false);
        JFormattedTextField sne = ((JSpinner.DefaultEditor) numViatges.getEditor()).getTextField();
        sne.setEditable(false);
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
        dataCompra = new com.toedter.calendar.JDateChooser();
        backBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        selectEstat = new javax.swing.JComboBox<>();
        numViatges = new javax.swing.JSpinner();
        preu = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        NomComprador = new javax.swing.JTextField();
        selectTipus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Univeylandia Parc - Tickets - Modificar");

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Tickets - Modificar");

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel_small.png"))); // NOI18N
        backBtn.setText("Enrere");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ok_small.png"))); // NOI18N
        submitBtn.setText("Acceptar");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Data entrada:");

        jLabel2.setText("Número de viatges");

        jLabel3.setText("Tipus");

        jLabel4.setText("Preu (€)");

        jLabel5.setText("Estat");

        selectEstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actiu", "Desactivat"}));

        jLabel7.setText("Comprador");

        selectTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTipusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectEstat, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(preu, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectTipus, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 160, Short.MAX_VALUE)
                                .addComponent(submitBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backBtn))
                            .addComponent(NomComprador, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numViatges)
                            .addComponent(dataCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(NomComprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(selectTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numViatges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectEstat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(submitBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        FrameTicketsInicial fai = new FrameTicketsInicial();
        this.setVisible(false);
        fai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        int nViatges = (Integer) numViatges.getValue();
        String estat_ticket_selector = (String) selectEstat.getSelectedItem();
        String idTicket = SharedData.getIdTicket();
        
        MetodesTicket.updateTicket(nViatges, idTicket, estat_ticket_selector);

        /*try {
            String data_entrada;
            String update_atributs_ticket_query = "";
            
            
            if (((JTextField) dataCompra.getDateEditor().getUiComponent()).getText().equalsIgnoreCase(null)) {
                data_entrada = "'" + ((JTextField) dataCompra.getDateEditor().getUiComponent()).getText() + "'";
                update_atributs_ticket_query = "update atributs_producte set nom = " + tipus + ", tickets_viatges = " + nViatges + ", preu = " + valorPreu + ", data_entrada = " + data_entrada + " where id = " + id_ticket + ";";

            } else {
                update_atributs_ticket_query = "update atributs_producte set nom = " + tipus + ", tickets_viatges = " + nViatges + ", preu = " + valorPreu + " where id = " + id_ticket + ";";
            }
            int estat_ticket;
            
            if (estat_ticket_selector.equalsIgnoreCase("Actiu")) {
                estat_ticket = 1;
            } else {
                estat_ticket = 0;
            }
            String update_ticket_query = "update productes set Estat = " + estat_ticket + " where id = " + id_ticket + ";";
            System.out.println(update_atributs_ticket_query);
            System.out.println(update_ticket_query);
            statement = Auxiliar.DBConnection.getConnection().createStatement();
            statement.executeUpdate(update_atributs_ticket_query);
            statement.executeUpdate(update_ticket_query);
            JOptionPane.showMessageDialog(this, "Ticket actualitzat correctament");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e);
        } finally {
            try {
                statement.close();
                Auxiliar.DBConnection.disconnect();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, e);
            }
                    
            
        }*/
        FrameTicketsInicial ft = new FrameTicketsInicial();
        this.setVisible(false);
        ft.setVisible(true);
    }//GEN-LAST:event_submitBtnActionPerformed

    private void selectTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTipusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectTipusActionPerformed

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
            java.util.logging.Logger.getLogger(FrameTicketsModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTicketsModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTicketsModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTicketsModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTicketsModificar().setVisible(true);
            }
        });
    }
    /*void loadcombo() {
        try {
            statement = Auxiliar.DBConnection.getConnection().createStatement();
            resultTipus = statement.executeQuery("select nom from tipus_producte where id in (1,2,3,4,5,6,7);");
            while (resultTipus.next()) {
                selectTipus.addItem(resultTipus.getString(1));
            }
            Auxiliar.DBConnection.disconnect();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NomComprador;
    private javax.swing.JButton backBtn;
    private com.toedter.calendar.JDateChooser dataCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner numViatges;
    private javax.swing.JSpinner preu;
    private javax.swing.JComboBox<String> selectEstat;
    private javax.swing.JTextField selectTipus;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
