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
            System.out.println(e.getMessage());
        }
    }
}
