/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author manel
 */
public class Incidencia {

    private int name_state;
    private String title;
    private String descript;
    private int id_priority;
    private int id_user_report;
    private int id_user_assign;
    private int id;
    private String resultat;
    private String nom_prioritat;
    private String nom_estat;
   

    public Incidencia() {
    }

    public Incidencia(String title, String descript, int id, String nom_prioritat, String nom_estat) {
        this.title = title;
        this.descript = descript;
        this.id = id;
        this.nom_prioritat = nom_prioritat;
        this.nom_estat = nom_estat;
    }

    
    public Incidencia(String title, String descript, int state, int id_priority) {
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.name_state = state;
    }

    public Incidencia(String title, String descript, int name_state, int id_priority, int id_user_report, int id_user_assign) {

        this.name_state = name_state;
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.id_user_report = id_user_report;
        this.id_user_assign = id_user_assign;

    }

    public Incidencia(int id, String title, String descript, int name_state, int id_priority) {

        this.name_state = name_state;
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.id = id;
    }
    
    public Incidencia(int id, String title, String descript, int name_state, int id_priority, int id_user_assign) {

        this.name_state = name_state;
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.id = id;
        this.id_user_assign = id_user_assign;
    }

    public Incidencia(int id, String title, String descript, int name_state, int id_priority, int id_user_report, int id_user_assign, String resultat) {

        this.name_state = name_state;
        this.title = title;
        this.descript = descript;
        this.id_priority = id_priority;
        this.id_user_report = id_user_report;
        this.id_user_assign = id_user_assign;
        this.id = id;
        this.resultat = resultat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName_state(int name_state) {

        this.name_state = name_state;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public void setDescript(String descript) {

        this.descript = descript;

    }

    public void setId_priority(int id_priority) {

        this.id_priority = id_priority;

    }

    public void setId_user_report(int id_user_report) {

        this.id_user_report = id_user_report;

    }

    public void setId_user_assign(int id_user_assign) {

        this.id_user_assign = id_user_assign;

    }

    public void setNom_prioritat(String nom_prioritat) {
        this.nom_prioritat = nom_prioritat;
    }

    public void setNom_estat(String nom_estat) {
        this.nom_estat = nom_estat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public int getName_state() {

        return name_state;

    }

    public String getTitle() {

        return title;

    }

    public String getDescript() {

        return descript;

    }

    public int getId_priority() {

        return id_priority;

    }

    public int getId_user_report() {

        return id_user_report;

    }

    public int getId_user_assign() {

        return id_user_assign;

    }

    public int getId() {
        return id;
    }

    public String getResultat() {
        return resultat;
    }

    public String getNom_prioritat() {
        return nom_prioritat;
    }

    public String getNom_estat() {
        return nom_estat;
    }
    
}
