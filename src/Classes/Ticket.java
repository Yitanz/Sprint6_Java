/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @Evaldas Casas, Jose Febrer, Ferran Climent / GRUP-2 - Gestio d'atracions del
 * parc
 */
public class Ticket {

    private int id;
    private String descripcio;
    private int estat;//
    private int tipus;//
    private String tipus_ticket_string;//

    private int mida;
    private int tickets_viatges;//
    private int preu;//
    private String comprador;
    private String data_compra;

    public Ticket(int estat, String tipus, int tickets_viatges, int preu, String comprador, String data_compra) {
        this.estat = estat;
        this.tipus_ticket_string = tipus;
        this.tickets_viatges = tickets_viatges;
        this.preu = preu;
        this.comprador = comprador;
        this.data_compra = data_compra;
    }

    private static String querySelect = "select p.id, tp.nom as tipus, p.descripcio, ap.tickets_viatges, ap.preu, p.estat "
            + "                          from productes p left join atributs_producte ap on p.atributs = ap.id left join tipus_producte tp on ap.nom = tp.id "
            + "                          where tp.id in (1,2,3,4,5,6,7) and p.Estat = 1 order by p.id desc limit 5000";

    private static String queryShow = "SELECT  p.id,u.nom as Nom,u.cognom1 as Cognom, tp.id as id_tipus, tp.nom as tipus_tiquet,  DATE_FORMAT(vp.created_at, '%Y-%m-%d') AS data_compra, ap.tickets_viatges, ap.preu, p.estat "
            + "                        FROM users u,venta_productes vp, productes p left join atributs_producte ap on p.atributs = ap.id left join tipus_producte tp on ap.nom = tp.id "
            + "                        WHERE vp.id_usuari = u.id and p.id = ?";

    public Ticket(String descripcio_c, int estat_c, int tipus_c, int mida_c, int tickets_viatges_c, int preu_c) {
        descripcio = descripcio_c;
        estat = estat_c;
        tipus = tipus_c;
        mida = mida_c;
        tickets_viatges = tickets_viatges_c;
        preu = preu_c;
    }

    /* GETTERS */
    public int getId() {
        return id;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public int getEstat() {
        return estat;
    }

    public int getTipus() {
        return tipus;
    }

    public int getMida() {
        return mida;
    }

    public int getTickets_viatges() {
        return tickets_viatges;
    }

    public int getPreu() {
        return preu;
    }

    public static String getQuerySelect() {
        return querySelect;
    }

    public String getComprador() {
        return comprador;
    }

    public String getData_compra() {
        return data_compra;
    }

    public static String getQueryShow() {
        return queryShow;
    }

    public String getTipus_ticket_string() {
        return tipus_ticket_string;
    }

    public void setTipus_ticket_string(String tipus_ticket_string) {
        this.tipus_ticket_string = tipus_ticket_string;
    }

    public static ArrayList<Ticket> arrayTickets = new ArrayList<Ticket>();
}
