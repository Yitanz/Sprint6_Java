package Metodes;

import Auxiliar.DBConnection;
import Classes.Atraccio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Grup 2: Evaldas Casas
 */
public class MetodesAtraccio {

    static DBConnection connexio;
    static Statement stmt = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    /**
     * Mètode que rep un objecte Atracció i realitza un INSERT en la taula
     * Atraccions amb les dades de l'objecte. Retorna un enter.
     *
     * @param atr
     * @return rowsInserted
     */
    public static int RegistrarAtraccio(Atraccio atr) {
        int rowsInserted = 0;
        try {
            connexio = new DBConnection();

            String query = "INSERT INTO atraccions (nom_atraccio, tipus_atraccio, data_inauguracio, altura_min, "
                    + "altura_max, accessibilitat, acces_express, descripcio, path) VALUES (?,?,?,?,?,?,?,?,?)";

            pst = connexio.getConnection().prepareStatement(query);

            pst.setString(1, atr.getNom_atraccio());
            pst.setInt(2, atr.getTipus_atraccio());
            pst.setString(3, atr.getData_innauguracio());
            pst.setInt(4, atr.getAltura_min());
            pst.setInt(5, atr.getAltura_max());
            pst.setString(6, atr.isAccessibilitat());
            pst.setString(7, atr.isAcces_expres());
            pst.setString(8, atr.getDescripcio());
            pst.setString(9, "NO");

            rowsInserted = pst.executeUpdate();

            /*if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "S'ha inserit un nou registre!");
            }*/
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error.");
        } finally {
            try {
                /* Tancar connexió i statement */
                connexio.disconnect();
                pst.close();
            } catch (SQLException e) {
                //System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null,"Error.");
            }
        }
        return rowsInserted;
    }

    /**
     * Mètode que plena un combobox amb les dades d'una consulta de la taula
     * Tipus_atraccions.
     *
     * @param typeField
     */
    public static void getTipusAtraccions(JComboBox typeField) {
        try {
            connexio = new DBConnection();

            String tipus_atraccions_query = "SELECT tipus FROM tipus_atraccions";

            stmt = connexio.getConnection().createStatement();

            rs = stmt.executeQuery(tipus_atraccions_query);

            /* Carregar les dades de la SELECT en el ComboBox */
            while (rs.next()) {
                typeField.addItem(rs.getString("tipus"));
            }

            /*connection.close();
            statement.close();
            resultSet.close();*/
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error.");
        }
    }

    /**
     * Mètode que plena de dades un objecte de tipus Atracció i un combobox del
     * formulari.
     *
     * @param nomAtraccio
     * @param typeField
     * @return atr
     */
    public static Atraccio getDadesAtraccio(String nomAtraccio, JComboBox typeField, String query) {
        //System.out.println(nomAtraccio);
        Atraccio atr = null;
        try {
            connexio = new DBConnection();

            String tipus_atraccions_query = "SELECT tipus FROM tipus_atraccions";

            stmt = connexio.getConnection().createStatement();

            rs = stmt.executeQuery(tipus_atraccions_query);

            /* Omplir el ComboBox amb els noms dels tipus d'atraccions */
            while (rs.next()) {
                typeField.addItem(rs.getString("tipus"));
            }

            pst = connexio.getConnection().prepareStatement(query);

            pst.setString(1, nomAtraccio);

            ResultSet resultSet2 = pst.executeQuery();

            resultSet2.first();

            /* Omplir els camps amb les dades de la query */
            String name = resultSet2.getString("nom_atraccio");
            String type = resultSet2.getString("tipus");
            String data = resultSet2.getString("data_inauguracio");
            int min = resultSet2.getInt("altura_min");
            int max = resultSet2.getInt("altura_max");
            String accessibility = resultSet2.getString("accessibilitat");
            String express = resultSet2.getString("acces_express");
            String desc = resultSet2.getString("descripcio");

            atr = new Atraccio(name, type, data, min, max, accessibility, express, desc);

            /* Tancar connexió, statements i resultSet */
            connexio.disconnect();
            stmt.close();
            rs.close();
            resultSet2.close();

        } catch (Exception e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error.");
        }
        return atr;
    }
    
    /**
     * Mètode que rep un objecte Atracció i realitza un INSERT en la taula
     * Atraccions amb les dades de l'objecte. Retorna un enter.
     *
     * @param atr
     * @return rowsInserted
     */
    public static int ModificarAtraccio(String nomAtraccio, Atraccio atr) {
        int rowsInserted = 0;
        try {
            connexio = new DBConnection();

            String query = "UPDATE atraccions SET nom_atraccio = ?, tipus_atraccio = ?, data_inauguracio = ?, altura_min = ?, "
                    + "altura_max = ?, accessibilitat = ?, acces_express = ?, descripcio = ? WHERE nom_atraccio = ?;";

            pst = connexio.getConnection().prepareStatement(query);

            pst.setString(1, atr.getNom_atraccio());
            pst.setInt(2, atr.getTipus_atraccio());
            pst.setString(3, atr.getData_innauguracio());
            pst.setInt(4, atr.getAltura_min());
            pst.setInt(5, atr.getAltura_max());
            pst.setString(6, atr.isAccessibilitat());
            pst.setString(7, atr.isAcces_expres());
            pst.setString(8, atr.getDescripcio());
            pst.setString(9, nomAtraccio);

            rowsInserted = pst.executeUpdate();

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error.");
        } finally {
            try {
                /* Tancar connexió i statement */
                connexio.disconnect();
                pst.close();
            } catch (SQLException e) {
                //System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null,"Error.");
            }
        }
        return rowsInserted;
    }

    /**
     * Mètode que elimina una atracció de la taula Atraccions.
     *
     * @param nomAtraccio
     */
    public static int EliminarAtraccio(String nomAtraccio, String query) {
        int rowsInserted = 0;
        try {
            connexio = new DBConnection();

            pst = connexio.getConnection().prepareStatement(query);

            pst.setString(1, nomAtraccio);

            rowsInserted = pst.executeUpdate();

            /* Tancar connexió, statements i resultSet */
            connexio.disconnect();
            pst.close();
            rs.close();

        } catch (Exception e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Error.");
        }
        return rowsInserted;
    }
}
