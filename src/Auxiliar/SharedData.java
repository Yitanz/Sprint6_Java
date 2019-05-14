package Auxiliar;

/**
 *
 * @author Grup 2: Evaldas Casas
 */
public class SharedData {

    private static String nomAtraccio;
    private static String clientNumeroDocument;
    private static String emailEmpleat;
    private static String codiSS;
private static String idTicket;

    public static void setNomAtraccio(String x) {
        SharedData.nomAtraccio = x;
    }

    public static String getNomAtraccio() {
        return nomAtraccio;
    }

    public static void setClientNumeroDocument(String x) {
        SharedData.clientNumeroDocument = x;
    }

    public static String getClientNumeroDocument() {
        return clientNumeroDocument;
    }
    
    public static String getEmailEmpleat() {
        return emailEmpleat;
    }

    public static void setEmailEmpleat(String emailEmpleat) {
        SharedData.emailEmpleat = emailEmpleat;
    }

    public static String getCodiSS() {
        return codiSS;
    }

    public static void setCodiSS(String codiSS) {
        SharedData.codiSS = codiSS;
    }

    public static String getIdTicket() {
        return idTicket;
    }

    public static void setIdTicket(String x) {
        SharedData.idTicket = x;
    }
}
