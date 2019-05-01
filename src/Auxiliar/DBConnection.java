package Auxiliar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;                                                                       // Import per el SQL Connection
import java.sql.DriverManager;                                                                    // Import per el SQL Drive Manager
import Frames.FrameConfiguracio;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import Auxiliar.AES;


public class DBConnection {

    static Connection conn = null;                                                                         // Variable per la conexio de tipus Connection
    static final String DB_DRV = "com.mysql.jdbc.Driver";                                           // Variable per igualar el driver de la DB

    public DBConnection() {
        try {
            String DB_URL = "jdbc:mysql://" + carregarConf()[0] + "/" + carregarConf()[1];          // Variable per igualar la localitzacio de la DB
            String DB_USER = carregarConf()[2];                                                     // Variable per igualar el usuari de la DB
            String DB_PASSWD = carregarConf()[3];                                                   // Variable per igualar la contrasenya de la DB
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);                         // Crear la variable per la conexio amb la DB
        } catch (Exception ex) {
            System.out.println(ex.getMessage());                                                    // Mostrar error si no es conecta
        }
    }

    public static Connection getConnection() {                                                             // Metode per cridar a la conexio
        return conn;
    }

    public static void disconnect() {                                                                      // Metode per desconectar la conexio
        try {
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public String [] carregarConf() throws Exception{
        final String secretKey = "ssssssssssssssssssssssssas?";
        BufferedReader saveFile= new BufferedReader(new FileReader(FrameConfiguracio.directoriConfig + FrameConfiguracio.arxiuConfig));
        String host = saveFile.readLine(); 
        String db = saveFile.readLine();
        String user = saveFile.readLine();
        String pwd = AES.decrypt(saveFile.readLine(), secretKey);
        
        String configuracio [] = {host, db, user, pwd};
        saveFile.close();
        return configuracio;
    }
}
