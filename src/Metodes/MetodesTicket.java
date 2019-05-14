package Metodes;

import Auxiliar.DBConnection;
import Classes.Ticket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Grup 2: Evaldas Casas
 */
public class MetodesTicket {

    static DBConnection connexio;
    static Statement stmt = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    public static void updateTicket(int numViatges, String idTicket, String estat_ticket_selector) {

        Statement statement = null;
        try {
            connexio = new DBConnection();
            String update_atributs_ticket_query = "";

            update_atributs_ticket_query = "update atributs_producte set tickets_viatges = " + numViatges + " where id = " + idTicket + ";";

            int estat_ticket;
            if (estat_ticket_selector.equalsIgnoreCase("Actiu")) {
                estat_ticket = 1;
            } else {
                estat_ticket = 0;
            }
            String update_ticket_query = "update productes set Estat = " + estat_ticket + " where id = " + idTicket + ";";
            System.out.println(update_atributs_ticket_query);
            System.out.println(update_ticket_query);
            statement = Auxiliar.DBConnection.getConnection().createStatement();
            statement.executeUpdate(update_atributs_ticket_query);
            statement.executeUpdate(update_ticket_query);
            JOptionPane.showMessageDialog(null, "Ticket actualitzat correctament");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                statement.close();
                Auxiliar.DBConnection.disconnect();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    public static Ticket getDadesTicket(String idTicket, String query) {
        System.out.println(idTicket);
        Ticket tck = null;
        try {
            connexio = new DBConnection();

            pst = connexio.getConnection().prepareStatement(query);

            pst.setString(1, idTicket);

            ResultSet resultSet2 = pst.executeQuery();

            resultSet2.first();

            /* Omplir els camps amb les dades de la query */
            String nomComprador = resultSet2.getString("Nom");
            nomComprador += " ";
            nomComprador += resultSet2.getString("Cognom");
            String tipus_c = resultSet2.getString("tipus_tiquet");
            String data_compra = resultSet2.getString("data_compra");
            int tickets_viatges_c = resultSet2.getInt("tickets_viatges");
            int preu_c = resultSet2.getInt("preu");
            int estat_c = resultSet2.getInt("estat");

            tck = new Ticket(estat_c, tipus_c, tickets_viatges_c, preu_c, nomComprador, data_compra);

            /* Tancar connexió, statements i resultSet */
            connexio.disconnect();
            stmt.close();
            rs.close();
            resultSet2.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(this, e);
        }
        return tck;
    }
}
