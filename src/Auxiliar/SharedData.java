package Auxiliar;

/**
 *
 * @author Grup 2: Evaldas Casas
 */
public class SharedData {

    private static String nomAtraccio;
    
    private static String clientNumeroDocument;

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
}
