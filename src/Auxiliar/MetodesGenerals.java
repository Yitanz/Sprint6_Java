package Auxiliar;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
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

/**
     * Mètode auxiliar que rep un JTable i un String de query i genera una taula
     * de forma dinàmica.
     *
     * @param resultTable
     * @param query
     *
     * @author Evaldas Casas
     * @param showBtn
     * @param editBtn
     * @param deleteBtn
     */
    public static void loadTable(JTable resultTable, String query, JButton showBtn, JButton editBtn, JButton deleteBtn) {
        try {

            model = new DefaultTableModel() {
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
                    System.out.println(columnCount);
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

            showBtn.setEnabled(false);
            editBtn.setEnabled(false);
            deleteBtn.setEnabled(false);

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
     * Mètode que rep un JTable i un String per filtrar dades d'un JTable.
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
