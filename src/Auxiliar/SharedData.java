package Auxiliar;

/**
 *
 * @author Grup 2: Evaldas Casas
 */
public class SharedData {

    private static String nomAtraccio;

    public static void setNomAtraccio(String x) {
        SharedData.nomAtraccio = x;
    }

    public static String getNomAtraccio() {
        return nomAtraccio;
    }
}
