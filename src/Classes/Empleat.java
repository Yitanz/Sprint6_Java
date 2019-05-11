/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author root
 */
public class Empleat {

    private int id;
    private String nom;
    private String cognom1;
    private String cognom2;
    private String email;
    private String password;
    private String data_naixement;
    private String adreca;
    private String ciutat;
    private String provincia;
    private String codi_postal;
    private String tipus_document;
    private String numero_document;
    private String sexe;
    private String telefon;
    private int id_rol;
    private int id_dades_empleat;
    private String codi_seg_social;
    private String num_nomina;
    private String IBAN;
    private String especialitat;
    private String carrec;
    private String data_inici_contracte;
    private String data_fi_contracte;
    private int id_horari;
    private String resultat;

    private static String querySelect = "SELECT nom, cognom1, email, telefon, tipus_document, numero_document FROM users WHERE id_rol != 1 AND id_dades_empleat IS NOT NULL ORDER BY id";
    
    public static String getQuerySelect() {
        return querySelect;
    }

    private static String queryShow = "SELECT e.nom, e.cognom1, e.email, e.data_naixement, e.adreca, e.ciutat, e.provincia, e.codi_postal,e.tipus_document, e.numero_document, e.sexe, e.telefon,d.codi_seg_social, d.num_nomina, d.IBAN, d.especialitat, d.carrec, d.data_inici_contracte, d.data_fi_contracte FROM users e JOIN dades_empleats d ON e.id_dades_empleat = d.id WHERE e.email = ?";
    
    public static String getQueryShow(){
        return queryShow;
    }
    
    public static String queryDel = "DELETE FROM users WHERE email = ?;";
    
    public static String getQueryDel(){
        return queryDel;
    }
    
    public static String queryDadesEmp = "DELETE FROM dades_empleat where codi_seg_social = ?;";

    public static String getQueryDadesEmp() {
        return queryDadesEmp;
    }
    
    
    public Empleat() {
    }

    /**
     * @Author Ivan constructor de afegir empleat empleat
     */
    public Empleat(int idEmployee, String NomEmployee, String CognomEmployee, String AdrecaEmployee, String CiutatEmployee) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.adreca = adreca;
        this.ciutat = ciutat;
    }


    public Empleat(String nom, String cognom1, String email, String data_naixement, String adreca, String ciutat, String provincia, String codi_postal, String numero_document, String sexe, String telefon, String codi_seg_social, String num_nomina, String IBAN, String especialitat, String carrec, String data_inici_contracte, String data_fi_contracte) {
        this.id = id;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.email = email;
        this.password = password;
        this.data_naixement = data_naixement;
        this.adreca = adreca;
        this.ciutat = ciutat;
        this.provincia = provincia;
        this.codi_postal = codi_postal;
        this.tipus_document = tipus_document;
        this.numero_document = numero_document;
        this.sexe = sexe;
        this.telefon = telefon;
        this.id_rol = id_rol;
        this.id_dades_empleat = id_dades_empleat;
        this.codi_seg_social = codi_seg_social;
        this.num_nomina = num_nomina;
        this.IBAN = IBAN;
        this.especialitat = especialitat;
        this.carrec = carrec;
        this.data_inici_contracte = data_inici_contracte;
        this.data_fi_contracte = data_fi_contracte;
        this.id_horari = id_horari;
        this.resultat = resultat;
    }

    public Empleat(String nom, String cognom1, String email, String adreca, String ciutat, String provincia, String codi_postal, String numero_document, String sexe, String telefon, String codi_seg_social, String num_nomina, String IBAN, String especialitat, String carrec, String data_inici_contracte, String data_fi_contracte) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.email = email;
        this.adreca = adreca;
        this.ciutat = ciutat;
        this.provincia = provincia;
        this.codi_postal = codi_postal;
        this.numero_document = numero_document;
        this.sexe = sexe;
        this.telefon = telefon;
        this.codi_seg_social = codi_seg_social;
        this.num_nomina = num_nomina;
        this.IBAN = IBAN;
        this.especialitat = especialitat;
        this.carrec = carrec;
        this.data_inici_contracte = data_inici_contracte;
        this.data_fi_contracte = data_fi_contracte;
    }

 

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getData_naixement() {
        return data_naixement;
    }

    public String getAdreca() {
        return adreca;
    }

    public String getCiutat() {
        return ciutat;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCodi_postal() {
        return codi_postal;
    }

    public String getTipus_document() {
        return tipus_document;
    }

    public String getNumero_document() {
        return numero_document;
    }

    public String getSexe() {
        return sexe;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getId_rol() {
        return id_rol;
    }

    public int getId_dades_empleat() {
        return id_dades_empleat;
    }

    public String getCodi_seg_social() {
        return codi_seg_social;
    }

    public String getNum_nomina() {
        return num_nomina;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public String getCarrec() {
        return carrec;
    }

    public String getData_inici_contracte() {
        return data_inici_contracte;
    }

    public String getData_fi_contracte() {
        return data_fi_contracte;
    }

    public int getId_horari() {
        return id_horari;
    }

    public String getResultat() {
        return resultat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setData_naixement(String data_naixement) {
        this.data_naixement = data_naixement;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCodi_postal(String codi_postal) {
        this.codi_postal = codi_postal;
    }

    public void setTipus_document(String tipus_document) {
        this.tipus_document = tipus_document;
    }

    public void setNumero_document(String numero_document) {
        this.numero_document = numero_document;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public void setId_dades_empleat(int id_dades_empleat) {
        this.id_dades_empleat = id_dades_empleat;
    }

    public void setCodi_seg_social(String codi_seg_social) {
        this.codi_seg_social = codi_seg_social;
    }

    public void setNum_nomina(String num_nomina) {
        this.num_nomina = num_nomina;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setEspecialitat(String especialitat) {
        this.especialitat = especialitat;
    }

    public void setCarrec(String carrec) {
        this.carrec = carrec;
    }

    public void setData_inici_contracte(String data_inici_contracte) {
        this.data_inici_contracte = data_inici_contracte;
    }

    public void setData_fi_contracte(String data_fi_contracte) {
        this.data_fi_contracte = data_fi_contracte;
    }

    public void setId_horari(int id_horari) {
        this.id_horari = id_horari;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "Employee{" + "nom=" + nom + ", cognom1=" + cognom1 + ", sexe=" + sexe + '}';
    }
}
