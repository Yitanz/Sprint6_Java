package Classes;

/**
 *
 * @author Grup2: Evaldas Casas
 */
public class Atraccio {

    private String nom_atraccio;
    private int tipus_atraccio;
    private String tipus_atraccio_string;
    private String data_innauguracio;
    private int altura_min;
    private int altura_max;
    private String accessibilitat;
    private String acces_expres;
    private String descripcio;

    /*
    private static String queryOG = "SELECT a.id, nom_atraccio, ta.tipus, data_inauguracio, altura_min, altura_max, accessibilitat, "
            + "acces_express, descripcio, path, votacions, a.created_at, a.updated_at "
            + "FROM atraccions a "
            + "INNER JOIN tipus_atraccions ta ON a.tipus_atraccio = ta.id ORDER BY a.id;";
     */
    
    private static String queryShow = "SELECT a.nom_atraccio, ta.tipus, a.data_inauguracio, a.altura_min, "
            + "a.altura_max, a.accessibilitat, a.acces_express, a.descripcio "
            + "FROM atraccions a JOIN tipus_atraccions ta ON a.tipus_atraccio = ta.id WHERE a.nom_atraccio = ?";

    private static String querySelect = "SELECT a.nom_atraccio, ta.tipus FROM atraccions a "
            + "INNER JOIN tipus_atraccions ta ON a.tipus_atraccio = ta.id ORDER BY a.id;";

    private static String queryUpdate = "UPDATE atraccions SET nom_atraccio = ?, tipus_atraccio = ?, data_inauguracio = ?, altura_min = ?, "
            + "altura_max = ?, accessibilitat = ?, acces_express = ?, descripcio = ? WHERE nom_atraccio = ? ;";

    private static String queryDelete = "DELETE FROM atraccions WHERE nom_atraccio = ? ;";

    /* ************************************** Constructors ************************************** */
    public Atraccio(String nom_atraccio, int tipus_atraccio, String data_innauguracio, int altura_min, int altura_max, String accessibilitat, String acces_expres, String descripcio) {
        this.nom_atraccio = nom_atraccio;
        this.tipus_atraccio = tipus_atraccio;
        this.data_innauguracio = data_innauguracio;
        this.altura_min = altura_min;
        this.altura_max = altura_max;
        this.accessibilitat = accessibilitat;
        this.acces_expres = acces_expres;
        this.descripcio = descripcio;
    }

    public Atraccio(String name, String type, String data, int min, int max, String accessibility, String express, String desc) {
        this.nom_atraccio = name;
        this.tipus_atraccio_string = type;
        this.data_innauguracio = data;
        this.altura_min = min;
        this.altura_max = max;
        this.accessibilitat = accessibility;
        this.acces_expres = express;
        this.descripcio = desc;
    }

    /* ************************************** Mètodes accessors a les sentencies SQL ************************************** */
    public static String getQueryShow() {
        return queryShow;
    }

    public static String getQuerySelect() {
        return querySelect;
    }

    public static String getQueryUpdate() {
        return queryUpdate;
    }

    public static String getQueryDelete() {
        return queryDelete;
    }

    /* ************************************** Mètodes accessors ************************************** */
    public String getNom_atraccio() {
        return nom_atraccio;
    }

    public void setNom_atraccio(String nom_atraccio) {
        this.nom_atraccio = nom_atraccio;
    }

    public int getTipus_atraccio() {
        return tipus_atraccio;
    }

    public void setTipus_atraccio(int tipus_atraccio) {
        this.tipus_atraccio = tipus_atraccio;
    }

    public String getTipus_atraccio_string() {
        return tipus_atraccio_string;
    }

    public void setTipus_atraccio_string(String tipus_atraccio_string) {
        this.tipus_atraccio_string = tipus_atraccio_string;
    }

    public String getData_innauguracio() {
        return data_innauguracio;
    }

    public void setData_innauguracio(String data_innauguracio) {
        this.data_innauguracio = data_innauguracio;
    }

    public int getAltura_min() {
        return altura_min;
    }

    public void setAltura_min(int altura_min) {
        this.altura_min = altura_min;
    }

    public int getAltura_max() {
        return altura_max;
    }

    public void setAltura_max(int altura_max) {
        this.altura_max = altura_max;
    }

    public String isAccessibilitat() {
        return accessibilitat;
    }

    public void setAccessibilitat(String accessibilitat) {
        this.accessibilitat = accessibilitat;
    }

    public String isAcces_expres() {
        return acces_expres;
    }

    public void setAcces_expres(String acces_expres) {
        this.acces_expres = acces_expres;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}
