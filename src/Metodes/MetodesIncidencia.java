/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Auxiliar.DBConnection;
import Classes.Incidencia;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author manel
 */
public class MetodesIncidencia {

    public static String registerIncident(Incidencia incidencia) {

        String result;
        ResultSet rs;
        String lats = null;
        DBConnection cc = new DBConnection();

        Connection cn = cc.getConnection();
        System.out.print(incidencia.getId_priority());
        String sql = "INSERT INTO `incidencies`(`titol`, `descripcio`, `id_prioritat`, `id_estat`, `id_usuari_reportador`) VALUES (?,?,?,?,10)";

        PreparedStatement path = null;

        try {

            path = cn.prepareStatement(sql);
            path.setString(1, incidencia.getTitle());
            System.out.println(incidencia.getTitle());
            path.setString(2, incidencia.getDescript());
            System.out.println(incidencia.getDescript());
            path.setInt(3, incidencia.getId_priority());
            System.out.println(incidencia.getId_priority());
            path.setInt(4, incidencia.getName_state());
            System.out.println(incidencia.getName_state());
            //path.setInt(5, 10);

            path.execute();

            path = cn.prepareStatement("select id from incidencies;");
            rs = path.executeQuery();

            if (rs.next()) {
                lats = rs.getString(1);
            }

            result = "Incidència registrada amb exit" + lats;

        } catch (SQLException e) {

            result = "Error al inserir dades" + e.getMessage();

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
                result = "Error al tancar la connexió després d'inserir dades" + e.getMessage();
            }
        }
        return result;
    }

    public static String updateIncident(Incidencia incidencia) {
        String result;
        ResultSet rs;
        String lats = null;
        DBConnection cc = new DBConnection();

        Connection cn = cc.getConnection();
        String sql = "update incidencies set titol = ?,descripcio = ?,id_prioritat = ?,id_estat = ?, id_usuari_assignat = ? where id = ? ";
        PreparedStatement path = null;

        try {

            path = cn.prepareStatement(sql);
            path.setString(1, incidencia.getTitle());
            path.setString(2, incidencia.getDescript());
            path.setInt(3, incidencia.getId_priority());
            path.setInt(4, incidencia.getName_state());
            path.setInt(6, incidencia.getId());
            path.setInt(5, incidencia.getId_user_assign());

            path.execute();

            result = "Incidencia actualitzada correctament" + incidencia.getId();

        } catch (SQLException e) {
            System.out.println("Error al actualitzar les dades " + e);
            result = "Error al actualitzar les dades" + e.getMessage();

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
                result = "Error al tancar la connexió després d'actualitzar les dades" + e.getMessage();
            }
        }
        return result;
    }

    public static String deleteIncident(int key) {

        String result;
        DBConnection cc = new DBConnection();
        Incidencia incidencia = new Incidencia();
        PreparedStatement path = null;
        Connection cn = cc.getConnection();
        String sql = "delete from incidencies where id=?;";

        try {

            path = cn.prepareStatement(sql);
            path.setInt(1, key);
            path.executeUpdate();

            result = "Incidencia eliminada correctament";

        } catch (SQLException e) {

            result = ("Error al buscar la incidència" + e);

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
                result = ("Error al tancar la connexió");
            }
        }
        return result;
    }

    public static ArrayList<Incidencia> getList() {

        ArrayList<Incidencia> incidentList = new ArrayList<Incidencia>();
        PreparedStatement path = null;
        ResultSet rs;
        DBConnection cc = new DBConnection();
        Connection cn = cc.getConnection();
        //String sql = "select incidencies.id, titol, descripcio, nom_prioritat, nom_estat, users.nom, users.cognom1, users.email from incidencies, estat_incidencies, tipus_prioritat, users where users.id = incidencies.id_usuari_assignat and id_prioritat=tipus_prioritat.id and estat_incidencies.id= id_estat";
        String sql = "select incidencies.id, titol, descripcio, nom_prioritat, nom_estat from incidencies, estat_incidencies, tipus_prioritat where id_prioritat=tipus_prioritat.id and estat_incidencies.id= id_estat and id_usuari_assignat = ''";
        Incidencia incidentOb = null;
        try {

            path = cn.prepareStatement(sql);
            rs = path.executeQuery();

            while (rs.next()) {

                incidentOb = new Incidencia();

                incidentOb.setId(rs.getInt(1));
                incidentOb.setTitle(rs.getString(2));
                incidentOb.setDescript(rs.getString(3));
                incidentOb.setNom_prioritat(rs.getString(4));
                incidentOb.setNom_estat(rs.getString(5));

                if (incidentList.isEmpty()) {
                    incidentList.add(0, incidentOb);
                } else {
                    incidentList.add(incidentOb);
                }
            }

        } catch (SQLException e) {

            System.out.println("Error al buscar l'incidència" + e);

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
                System.out.println("Error al tancar la conexió");
            }
        }
        return incidentList;
    }
    
    public static ArrayList<Incidencia> getAssignedList() {

        ArrayList<Incidencia> incidentList = new ArrayList<Incidencia>();
        PreparedStatement path = null;
        ResultSet rs;
        DBConnection cc = new DBConnection();
        Connection cn = cc.getConnection();
        String sql = "select incidencies.id, titol, descripcio, nom_prioritat, nom_estat, users.nom, users.cognom1, users.email from incidencies, estat_incidencies, tipus_prioritat, users where users.id = incidencies.id_usuari_assignat and id_prioritat=tipus_prioritat.id and estat_incidencies.id= id_estat";
        //String sql = "select incidencies.id, titol, descripcio, nom_prioritat, nom_estat from incidencies, estat_incidencies, tipus_prioritat where id_prioritat=tipus_prioritat.id and estat_incidencies.id= id_estat";
        Incidencia incidentOb = null;
        try {

            path = cn.prepareStatement(sql);
            rs = path.executeQuery();

            while (rs.next()) {

                incidentOb = new Incidencia();

                incidentOb.setId(rs.getInt(1));
                incidentOb.setTitle(rs.getString(2));
                incidentOb.setDescript(rs.getString(3));
                incidentOb.setNom_prioritat(rs.getString(4));
                incidentOb.setNom_estat(rs.getString(5));
                incidentOb.setNom_usuari_assignat(rs.getString(6) + " " + rs.getString(7));
                incidentOb.setEmail_usuari_assignat(rs.getString(8));

                if (incidentList.isEmpty()) {
                    incidentList.add(0, incidentOb);
                } else {
                    incidentList.add(incidentOb);
                }
            }

        } catch (SQLException e) {

            System.out.println("Error al buscar l'incidència" + e);

        } finally {

            try {
                if (cn != null) {
                    cn.close();
                    path.close();
                }

            } catch (Exception e) {
                System.out.println("Error al tancar la conexió");
            }
        }
        return incidentList;
    }
    
    public static ResultSet FillComboBox(){
        ResultSet resultat = null;
        DBConnection cc = new DBConnection();
        try{
            cc = new DBConnection();
            Statement miStatement = cc.getConnection().createStatement();
            
            //Crear SQL (ResultSet es un objeto en forma de "tabla" donde está 
            //almacenada la info de la consulta
            resultat = miStatement.executeQuery("select id,nom,cognom1,email from users where id_rol!=1");
            
            
        }catch(Exception e){
            System.out.println("Error:");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error: " + e);
        }  
        return resultat;
    }
    public static void updateIncidentDades(int id, String titol, String descripcio, int state, int priority, int id_user_assign){
        Incidencia updateIncident = new Incidencia(id, titol, descripcio, state, priority, id_user_assign);
        MetodesIncidencia.updateIncident(updateIncident);
    }
    
    /**
     * Mètode per a buscar el ID d'un usuari amb el seu nom i cognom
     * @param nomcognom
     * @return id
     */
    public static int findID(String dades){
        int id = 0;
        String[] dadesArray = dades.split(" ");
        for(int i =0; i<dadesArray.length; ++i){
            System.out.println(dadesArray[i]);
        }
        ResultSet resultat = null;
        try{
            DBConnection connexio = new DBConnection();
            Statement miStatement = connexio.getConnection().createStatement();
            
            System.out.println(dadesArray[0] + " - " + dadesArray[1]);
            resultat = miStatement.executeQuery("select id from users where email = '" + dadesArray[3] + "'");
            resultat.next();
            id = resultat.getInt(1);
            System.out.println("INT ID: " + id);
        }catch(SQLException e){
            System.out.println("-Error: " + e);
        }
        return id;
    }
}
