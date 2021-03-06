package Frames;

import Auxiliar.MetodesGenerals;
import Auxiliar.SharedData;
import Classes.Empleat;
import Metodes.MetodesEmpleat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;

/**
 *
 * @author Grup 2: Evaldas Casas
 */
public class FrameEmpleatsMostrar extends javax.swing.JFrame {

    /**
     * Creates new form FrameAtraccionsInserir
     */
    public FrameEmpleatsMostrar() {
        initComponents();
        carregarGUI();
    }

    private void carregarGUI() {
        this.setSize(500, 400);
        JScrollPane pane = new JScrollPane(this.getContentPane());
        this.setContentPane(pane);
        this.setLocationRelativeTo(null);
        EmpleatNaixement.setDateFormatString(MetodesGenerals.DATE_FORMAT);
        EmpleatContracteInici.setDateFormatString(MetodesGenerals.DATE_FORMAT);
        EmpleatContracteFi.setDateFormatString(MetodesGenerals.DATE_FORMAT);
        carregarDades();
    }

    private void carregarDades() {
        
        String email = SharedData.getEmailEmpleat();

        Empleat emp = MetodesEmpleat.getDadesEmpleat(email, Empleat.getQueryShow());

//        EmpleatRol.setSelectedItem(emp.getId_rol());

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dataNaix = null;
        Date dataContracteInici = null;
        Date dataContracteFi = null;
        try {
            dataNaix = format.parse(emp.getData_naixement());
            dataContracteInici =  format.parse(emp.getData_inici_contracte());
            dataContracteFi = format.parse(emp.getData_fi_contracte());

        } catch (ParseException ex) {
            Logger.getLogger(FrameAtraccionsMostrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        EmpleatNom.setText(emp.getNom());
        EmpleatCognom.setText(emp.getCognom1());
        EmpleatCorreu.setText(emp.getEmail());
        EmpleatAdreca.setText(emp.getAdreca());
        EmpleatCiutat.setText(emp.getCiutat());
        EmpleatProvincia.setText(emp.getProvincia());
        EmpleatCodiPostal.setText(emp.getCodi_postal());
        EmpleatNumeroDoc.setText(emp.getNumero_document());
        EmpleatTelefon.setText(emp.getTelefon());
        EmpleatCSS.setText(emp.getCodi_seg_social());
        EmpleatNomina.setText(emp.getNum_nomina());
        EmpleatIBAN.setText(emp.getIBAN());
        EmpleatEspecialitat.setText(emp.getEspecialitat());
        EmpleatCarrec.setText(emp.getCarrec());
        //EmpleatRol.setSelectedIndex(emp.getId_rol());
       // EmpleatHorari.setSelectedIndex(emp.getId_horari());
        EmpleatNaixement.setDate(dataNaix);
        EmpleatContracteInici.setDate(dataContracteInici);
        EmpleatContracteFi.setDate(dataContracteFi);

        
        EmpleatNom.setEnabled(false);
        EmpleatCognom.setEnabled(false);
        EmpleatCorreu.setEnabled(false);
        EmpleatAdreca.setEnabled(false);
        EmpleatCiutat.setEnabled(false);
        EmpleatProvincia.setEnabled(false);
        EmpleatCodiPostal.setEnabled(false);
        EmpleatNumeroDoc.setEnabled(false);
        EmpleatTelefon.setEnabled(false);
        EmpleatCSS.setEnabled(false);
        EmpleatNomina.setEnabled(false);
        EmpleatIBAN.setEnabled(false);
        EmpleatEspecialitat.setEnabled(false);
        EmpleatCarrec.setEnabled(false);
      //  EmpleatRol.setEnabled(false);
  //      EmpleatSexe.setEnabled(false);
        EmpleatTipusDoc.setEnabled(false);
        EmpleatNaixement.setEnabled(false);
        EmpleatContracteInici.setEnabled(false);
        EmpleatContracteFi.setEnabled(false);;
        
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EmpleatAdreca1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EmpleatNom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EmpleatAdreca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        EmpleatCognom = new javax.swing.JTextField();
        EmpleatCorreu = new javax.swing.JTextField();
        EmpleatNaixement = new com.toedter.calendar.JDateChooser();
        EmpleatProvincia = new javax.swing.JTextField();
        EmpleatCiutat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        EmpleatCodiPostal = new javax.swing.JTextField();
        EmpleatTipusDoc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        EmpleatNumeroDoc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        EmpleatTelefon = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        EmpleatNomina = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        EmpleatIBAN = new javax.swing.JTextField();
        EmpleatCSS = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        EmpleatEspecialitat = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        EmpleatCarrec = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        EmpleatContracteInici = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        EmpleatContracteFi = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Univeylandia Parc - Treballadors - Mostrar");

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setText("Treballador - Mostrar");

        jLabel2.setText("Nom");

        jLabel3.setText("Cognom");

        jLabel4.setText("Correu electrònic");

        jLabel5.setText("Data de naixement");

        jLabel6.setText("Adreça");

        jLabel7.setText("Ciutat");

        jLabel8.setText("Provincia");

        jLabel9.setText("Codi Postal");

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel_small.png"))); // NOI18N
        backBtn.setText("Enrere");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        EmpleatCognom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleatCognomActionPerformed(evt);
            }
        });

        jLabel10.setText("Tipus Document");

        EmpleatTipusDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "NIE", "NIF" }));
        EmpleatTipusDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleatTipusDocActionPerformed(evt);
            }
        });

        jLabel11.setText("Número Document");

        jLabel13.setText("Telèfon");

        jLabel14.setText("Codi de la seguretat social");

        jLabel15.setText("Número de nòmina");

        jLabel16.setText("IBAN");

        jLabel17.setText("Especialitat");

        jLabel18.setText("Càrrec");

        jLabel19.setText("Data inici contracte");

        jLabel20.setText("Data fi contracte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EmpleatNom, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EmpleatAdreca, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backBtn))
                    .addComponent(EmpleatCognom)
                    .addComponent(EmpleatCorreu)
                    .addComponent(EmpleatNaixement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmpleatCiutat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EmpleatProvincia)
                    .addComponent(EmpleatCodiPostal)
                    .addComponent(EmpleatTipusDoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmpleatNumeroDoc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EmpleatTelefon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EmpleatNomina)
                    .addComponent(EmpleatIBAN)
                    .addComponent(EmpleatCSS)
                    .addComponent(EmpleatEspecialitat)
                    .addComponent(EmpleatCarrec)
                    .addComponent(EmpleatContracteInici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmpleatContracteFi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatCognom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatCorreu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatNaixement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatAdreca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatCiutat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatCodiPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatTipusDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatNumeroDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatCSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatEspecialitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatCarrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatContracteInici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmpleatContracteFi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        FrameEmpleatsInicial fai = new FrameEmpleatsInicial();
        this.setVisible(false);
        fai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void EmpleatCognomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleatCognomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleatCognomActionPerformed

    private void EmpleatTipusDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleatTipusDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmpleatTipusDocActionPerformed

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
            java.util.logging.Logger.getLogger(FrameEmpleatsMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameEmpleatsMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameEmpleatsMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameEmpleatsMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameEmpleatsMostrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmpleatAdreca;
    private javax.swing.JTextField EmpleatAdreca1;
    private javax.swing.JTextField EmpleatCSS;
    private javax.swing.JTextField EmpleatCarrec;
    private javax.swing.JTextField EmpleatCiutat;
    private javax.swing.JTextField EmpleatCodiPostal;
    private javax.swing.JTextField EmpleatCognom;
    private com.toedter.calendar.JDateChooser EmpleatContracteFi;
    private com.toedter.calendar.JDateChooser EmpleatContracteInici;
    private javax.swing.JTextField EmpleatCorreu;
    private javax.swing.JTextField EmpleatEspecialitat;
    private javax.swing.JTextField EmpleatIBAN;
    private com.toedter.calendar.JDateChooser EmpleatNaixement;
    private javax.swing.JTextField EmpleatNom;
    private javax.swing.JTextField EmpleatNomina;
    private javax.swing.JTextField EmpleatNumeroDoc;
    private javax.swing.JTextField EmpleatProvincia;
    private javax.swing.JTextField EmpleatTelefon;
    private javax.swing.JComboBox<String> EmpleatTipusDoc;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
