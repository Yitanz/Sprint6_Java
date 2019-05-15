/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodes;

import Auxiliar.DBConnection;
import Classes.Empleat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class MetodesEmpleat {

    static DBConnection connexio;
    static Statement statement = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    public static int RegistrarEmpleat(Empleat emp) {
        String result = null, last = null;
        int rowsInserted = 0;
        int rowsInserted2 = 0;

        try {
            System.out.println("Inicia");
            connexio = new DBConnection();
            statement = connexio.getConnection().createStatement();
            PreparedStatement pst = null;

            //crear dades emp
            String sql2 = "INSERT INTO dades_empleats (codi_seg_social, num_nomina, IBAN, especialitat, carrec, data_inici_contracte, data_fi_contracte, id_horari) values(?,?,?,?,?,?,?,?)";

            pst = connexio.getConnection().prepareStatement(sql2);
            pst.setString(1, emp.getCodi_seg_social());
            pst.setString(2, emp.getNum_nomina());
            pst.setString(3, emp.getIBAN());
            pst.setString(4, emp.getEspecialitat());
            pst.setString(5, emp.getCarrec());
            pst.setString(6, emp.getData_inici_contracte());
            pst.setString(7, emp.getData_fi_contracte());
            pst.setInt(8, emp.getId_horari());
            rowsInserted = pst.executeUpdate();
            if (rowsInserted < 1) {
                JOptionPane.showMessageDialog(null, "S'ha produit un error");
            }

            System.out.println("segon insert fet");
            System.out.println(rowsInserted);

            PreparedStatement pst2 = null;
            PreparedStatement pst3 = null;
            
            int id_dadesEmpleats = 0;
            /*Seleccionem el ID de les dades empleats*/
            ResultSet rs2 = null;
            try{
                connexio = new DBConnection();

                String id_dadesEmpleat = "SELECT id FROM dades_empleats ORDER BY id DESC LIMIT 1";

                statement = connexio.getConnection().createStatement();

                rs2 = statement.executeQuery(id_dadesEmpleat);


                rs2.first();

                /* Omplir els camps amb les dades de la query */
                id_dadesEmpleats = (int) rs2.getInt("id");
            }catch(SQLException e){
                System.out.println("error en al seleccionar el id de les dades de l'empleat: ");
            }
            
            //crear usuari
            String sql = "INSERT INTO users (nom, cognom1, email, password, data_naixement, adreca, ciutat, provincia, codi_postal, tipus_document, numero_document, sexe, telefon, id_rol, id_dades_empleat) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst2 = connexio.getConnection().prepareStatement(sql);
            pst2.setString(1, emp.getNom());
            pst2.setString(2, emp.getCognom1());
            pst2.setString(3, emp.getEmail());
            pst2.setString(4, emp.getPassword());
            pst2.setString(5, emp.getData_naixement());
            pst2.setString(6, emp.getAdreca());
            pst2.setString(7, emp.getCiutat());
            pst2.setString(8, emp.getProvincia());
            pst2.setString(9, emp.getCodi_postal());
            pst2.setString(10, emp.getTipus_document());
            pst2.setString(11, emp.getNumero_document());
            pst2.setString(12, emp.getSexe());
            pst2.setString(13, emp.getTelefon());
            pst2.setInt(14, emp.getId_rol());
            pst2.setInt(15, id_dadesEmpleats);
            rowsInserted2 = pst2.executeUpdate();

            if (rowsInserted2 < 1) {
                JOptionPane.showMessageDialog(null, "S'ha produit un error");
                
                eliminarDadesEmpleat(id_dadesEmpleats);
            }

            result = "Empleat registrat amb exit";
            statement.close();
            connexio.disconnect();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "S'ha produit un error" + e);

            System.out.println(e);
        }
        return rowsInserted;
    }

    //mostrar
    public static Empleat getDadesEmpleat(String EmpleatNom, String query) {
        System.out.println(EmpleatNom);
        Empleat emp = null;

        try {
            connexio = new DBConnection();

            String rol_empleat = "SELECT nom_rol FROM rols";

            statement = connexio.getConnection().createStatement();

            rs = statement.executeQuery(rol_empleat);
            
            pst = connexio.getConnection().prepareStatement(query);

            pst.setString(1, EmpleatNom);

            ResultSet resultSet2 = pst.executeQuery();

            resultSet2.first();

            /* Omplir els camps amb les dades de la query */
            String nom = resultSet2.getString("nom");
            String cognom1 = resultSet2.getString("cognom1");
            String email = resultSet2.getString("email");
            String data_naixement = resultSet2.getString("data_naixement");
            String adreca = resultSet2.getString("adreca");
            String ciutat = resultSet2.getString("ciutat");
            String provincia = resultSet2.getString("provincia");
            String codi_postal = resultSet2.getString("codi_postal");
            String numero_document = resultSet2.getString("numero_document");
            String sexe = resultSet2.getString("sexe");
            String telefon = resultSet2.getString("telefon");
            String codi_seg_social = resultSet2.getString("codi_seg_social");
            String num_nomina = resultSet2.getString("num_nomina");
            String IBAN = resultSet2.getString("IBAN");
            String especialitat = resultSet2.getString("especialitat");
            String carrec = resultSet2.getString("carrec");
            String data_inici_contracte = resultSet2.getString("data_inici_contracte");
            String data_fi_contracte = resultSet2.getString("data_fi_contracte");

            emp = new Empleat(nom, cognom1, email, data_naixement, adreca, ciutat,
                    provincia, codi_postal, numero_document, sexe, telefon, codi_seg_social,
                    num_nomina, IBAN, especialitat, carrec, data_inici_contracte, data_fi_contracte);

            /* Tancar connexió, statements i resultSet */
            connexio.disconnect();
            statement.close();
            rs.close();
            resultSet2.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(this, e);
        }
        return emp;
    }

    /**
     * Mètode que rep un objecte Atracció i realitza un INSERT en la taula
     * Atraccions amb les dades de l'objecte. Retorna un enter.
     *
     * @param emp
     * @return rowsInserted
     */
    public static int ModificarEmpleat(String EmpleatEmail, Empleat emp) {
        int rowsInserted = 0;
        try {
            connexio = new DBConnection();

            String selecciona = Empleat.getQueryShow();

            PreparedStatement pst2 = connexio.getConnection().prepareStatement(selecciona);

            pst2.setString(1, EmpleatEmail);

            ResultSet rs2 = pst2.executeQuery();

            rs2.first();

            String codi_seg_social = rs2.getString("codi_seg_social");

            pst2.close();

            System.out.println(codi_seg_social);

            String query = "UPDATE users SET nom = ?, cognom1 = ?, email = ?, data_naixement = ?, adreca= ?, ciutat = ?, provincia = ?, codi_postal = ?, numero_document = ?, sexe = ?, telefon = ? WHERE email = ?;";

            pst = connexio.getConnection().prepareStatement(query);

            pst.setString(1, emp.getNom());
            pst.setString(2, emp.getCognom1());
            pst.setString(3, emp.getEmail());
            pst.setString(4, emp.getData_naixement());
            pst.setString(5, emp.getAdreca());
            pst.setString(6, emp.getCiutat());
            pst.setString(7, emp.getProvincia());
            pst.setString(8, emp.getCodi_postal());
            pst.setString(9, emp.getNumero_document());
            pst.setString(10, emp.getSexe());
            pst.setString(11, emp.getTelefon());
            pst.setString(12, EmpleatEmail);

            rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {

                String query2 = "UPDATE dades_empleats SET codi_seg_social = ?, num_nomina = ?, IBAN = ?, especialitat = ?, carrec = ?, data_inici_contracte = ?, data_fi_contracte = ? WHERE codi_seg_social = ?;";

                PreparedStatement pst3 = connexio.getConnection().prepareStatement(query2);

                pst3.setString(1, emp.getCodi_seg_social());
                pst3.setString(2, emp.getNum_nomina());
                pst3.setString(3, emp.getIBAN());
                pst3.setString(4, emp.getEspecialitat());
                pst3.setString(5, emp.getCarrec());
                pst3.setString(6, emp.getData_inici_contracte());
                pst3.setString(7, emp.getData_fi_contracte());
                pst3.setString(8, codi_seg_social);

                rowsInserted = pst3.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                /* Tancar connexió i statement */
                connexio.disconnect();
                pst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted;
    }

    public static int ElEmpleat(String email, String query) {
        /*Busquem el id de les dades d'empleat i eliminem les dades de l'empleat*/
        int id_dadesEmpleats = 0;
        ResultSet rs2 = null;
        try{
            connexio = new DBConnection();

            pst = connexio.getConnection().prepareStatement(Empleat.queryIdDadesEmpleats);

            pst.setString(1, email);

            rs2 = pst.executeQuery();
            
            
            rs2.first();

            /* Omplir els camps amb les dades de la query */
            id_dadesEmpleats = (int) rs2.getInt("id_dades_empleat");
            System.out.println(id_dadesEmpleats);
            
            connexio.disconnect();
        }catch(SQLException e){
            System.out.println("error en al seleccionar el id de les dades de l'empleat: " + e);
        }
        
        
        int rowsInserted = 0;
        
        /*Eliminem l'empleat*/
        try {
            connexio = new DBConnection();

            pst = connexio.getConnection().prepareStatement(query);

            pst.setString(1, email);

            rowsInserted = pst.executeUpdate();
            connexio.disconnect();
            pst.close();
//            rs.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        /*Eliminem les dades de l'empleat*/
        try {
            connexio = new DBConnection();

            pst = connexio.getConnection().prepareStatement(Empleat.queryDelDadesEmpleats);

            pst.setInt(1, id_dadesEmpleats);

            rowsInserted = pst.executeUpdate();
            connexio.disconnect();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        
        
       
        return rowsInserted;
    }
    
    public static void eliminarDadesEmpleat(int idDadesEmpleat){
        ResultSet rs = null;

        /*Eliminem les dades de l'empleat*/
        try {
            connexio = new DBConnection();

            pst = connexio.getConnection().prepareStatement("DELETE FROM `dades_empleats` WHERE id = ?");

            pst.setInt(1, idDadesEmpleat);

            pst.executeUpdate();
            connexio.disconnect();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
