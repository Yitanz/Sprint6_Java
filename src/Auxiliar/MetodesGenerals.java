package Auxiliar;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Grups 1 i 2 - DAW 2 2018/2019
 */
public class MetodesGenerals {

    static DBConnection connexio;
    static Statement stmt = null;
    static ResultSet rs = null;

    static DefaultTableModel model;

    final public static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Mètode auxiliar genera una taula de forma dinàmica.
     *
     * @param resultTable
     * @param query
     *
     * @author Evaldas Casas
     */
    public static void loadTable(JTable resultTable, String query) {
        try {

            model = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ArrayList columnNames = new ArrayList();

            connexio = new DBConnection();

            stmt = connexio.getConnection().createStatement();

            rs = stmt.executeQuery(query);

            /* obtenir metadades del resultat de la consulta */
            ResultSetMetaData md = rs.getMetaData();

            /* comptar el numero de columnes del resultat */
            int columnCount = md.getColumnCount();

            /* emmagatzemar el nom de les columnes en un ArrayList */
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(md.getColumnName(i));
            }

            /* Generar taula */
            resultTable.setModel(model);

            for (int i = 0; i < columnNames.size(); i++) {
                model.addColumn(columnNames.get(i));
            }

            /* mostrar les dades en la taula despres d'haver-les guardat en un Objecte[] */
            while (rs.next()) {
                Object[] row = new Object[columnCount];

                for (int i = 0; i < columnCount; ++i) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                connexio.disconnect();
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Mètode que filtra dades d'un JTable.
     *
     * @param resultsTable
     * @param keyword
     *
     * @author Evaldas Casas
     */
    public static void filterTable(JTable resultsTable, String keyword) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

        resultsTable.setRowSorter(sorter);

        sorter.setRowFilter(RowFilter.regexFilter(keyword));
    }

}
