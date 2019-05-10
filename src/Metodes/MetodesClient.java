/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Auxiliar.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Classes.Client;


/**
 *
 * @author Ferran Climent - DAW2
 */
public class MetodesClient {
        
    
    /**
     * Mètode que rep un objecte Client i realitza un INSERT en la taula
     * Clients amb les dades de l'objecte. Retorna un result.
     *
     * @param vo
     * @return result
     */
    
    public static String registrarClient(Client users) throws SQLException {    //Metode per registrar un client
        String result = null, last = null;                                      //Variable per mostrar el resultat
        DBConnection cc = new DBConnection();                                   //Crear una nova DBConnection
        Connection cn = DBConnection.getConnection();                           //Crear una nova conexio
        PreparedStatement pst = null;                                           //Crear el Statemnt
        String sql = "INSERT INTO users (nom, cognom1, cognom2, email, password, data_naixement, adreca, ciutat, provincia, codi_postal, tipus_document, numero_document, sexe, telefon, id_rol)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";       //La SQL per inserir clients
              
        try {
            pst = cn.prepareStatement(sql);                                     //Passar tots els valors necesaris per el insert
            pst.setString(1, users.getNom());
            pst.setString(2, users.getCognom1());
            pst.setString(3, users.getCognom2());
            pst.setString(4, users.getEmail());
            pst.setString(5, users.getPassword()); //bcrypt
            pst.setString(6, users.getData_naixement());
            pst.setString(7, users.getAdreca());
            pst.setString(8, users.getCiutat());
            pst.setString(9, users.getProvincia());
            pst.setString(10, users.getCodi_postal());
            pst.setString(11, users.getTipus_document());
            pst.setString(12, users.getNumero_document());
            pst.setString(13, users.getSexe());
            pst.setString(14, users.getTelefon());
            pst.setInt(15, users.getId_rol());
            pst.execute();                                                      //Executar el STATEMNT
            pst = cn.prepareStatement("SELECT MAX(id) AS id FROM users");
            ResultSet rs = pst.executeQuery();                                  //Executar la Query
            
            if (rs.next()) {                                                    
                last = rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());                                 //Mostrar el error
        }catch(Exception ex){
            System.out.println(ex.getMessage()); 
        }finally {
            if (cn != null) {
                cn.close();                                                     //Tancar conexio i el statement
                pst.close();

            }
        }
        return result;                                                          //Retornar el resultat
    }
    
     /**
     * Mètode que rep un objecte Client i realitza un DELETE en la taula
     * Clients amb les dades de l'objecte. Retorna un result.
     *
     * @param vo
     * @return result
     */
    
    public static String eliminarClient(Client users) throws SQLException {
        String result = null, last = null;                                      //Variable per mostrar el resultat
        DBConnection cc = new DBConnection();                                   //Crear una nova DBConnection
        Connection cn = DBConnection.getConnection();                           //Crear una nova conexio
        PreparedStatement pst = null;                                           //Crear el Statemnt
        String sql = "DELETE FROM users WHERE numero_document =?";                            //SQL per eliminar el client
        
        try {
            pst = cn.prepareStatement(sql);                                     //Preperar el estat
            pst.setString(1, users.getNumero_document());                       //Passar el atributs necessaris
            pst.executeUpdate();                                                //Executar el Statement
            System.out.println(users.getNumero_document());
            System.out.println("Usuari eliminat amb exit, ID: " + users.getId());//Mostrar el usuari eliminat amb el seu ID

        } catch (SQLException e) {
           System.out.println(e.getMessage());                                  //Si existeix un error mostar-ho
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            if (cn != null) {
                cn.close();                                                     //Tancar conexio i Statement
                pst.close();

            }
        }return result;                                                         //Retornar el resultat
    }
    
     /**
     * Mètode que rep un numero_document d'un CLIENT i una QUERY i guarda les variables en un objecte
     * Clients amb les dades de l'objecte. Retorna un objecte de tipus Client.
     *
     * @param clientNumeroDocument, query
     * @return cli
     */
    
    public static Client getDadesClient(String clientNumeroDocument, String query) {
        System.out.println(clientNumeroDocument);
        Client cli = null;
        
        DBConnection cc = new DBConnection();                                   //Crear una nova DBConnection
        Connection cn = DBConnection.getConnection();                           //Crear una nova conexio
        PreparedStatement pst = null;                                           //Crear el Statemnt
        
        try {
            pst = cn.prepareStatement(query);
            pst.setString(1, clientNumeroDocument);
            pst.execute();
            
            ResultSet resultSet2 = pst.executeQuery();
            resultSet2.first();

            /* Omplir els camps amb les dades de la query */
            String nom1 = resultSet2.getString("nom");
            String cognom11 = resultSet2.getString("cognom1");
            String cognom21 = resultSet2.getString("cognom2");
            String email1 = resultSet2.getString("email");
            String password1 = resultSet2.getString("password");
            String data_naixement1 = resultSet2.getString("data_naixement");
            String adreca1 = resultSet2.getString("adreca");
            String ciutat1 = resultSet2.getString("provincia");
            String provincia1 = resultSet2.getString("ciutat");
            String codi_postal1 = resultSet2.getString("codi_postal");
            String tipus_document1 = resultSet2.getString("tipus_document");
            String numero_document1 = resultSet2.getString("numero_document");
            String sexe1 = resultSet2.getString("sexe");
            String telefon1 = resultSet2.getString("telefon");
            int id_rol1 = resultSet2.getInt("id_rol");
            
            cli = new Client();
            cli.setNom(nom1);
            cli.setCognom1(cognom11);
            cli.setCognom2(cognom21);
            cli.setEmail(email1);
            cli.setPassword(password1);
            cli.setData_naixement(data_naixement1);
            cli.setAdreca(adreca1);
            cli.setCiutat(ciutat1);
            cli.setProvincia(provincia1);
            cli.setCodi_postal(codi_postal1);
            cli.setTipus_document(tipus_document1);
            cli.setNumero_document(numero_document1);
            cli.setSexe(sexe1);
            cli.setTelefon(telefon1);
            cli.setId_rol(id_rol1);
              
            /* Tancar connexió, statements i resultSet */
            cn.close();
            pst.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cli;
    }
    
     /**
     * Mètode que rep un numero_document d'un CLIENT i una Cli i guarda les variables en un objecte
     * Clients amb les dades de l'objecte. Retorna rowsinserted
     *
     * @param clientNumeroDocument, cli
     * @return rowsinserted
     */

    public static int ModificarClient(String clientnumerodocument, Client cli) throws SQLException {
        int rowsInserted = 0;
        String result = null, last = null;                                      //Variable per mostrar el resultat
        DBConnection cc = new DBConnection();                                   //Crear una nova DBConnection
        Connection cn = DBConnection.getConnection();                           //Crear una nova conexio
        PreparedStatement pst = null;                                           //Crear el Statemnt
        String sql = "UPDATE users SET nom = ?, cognom1 = ?, cognom2 = ?, email = ?, password = ?, data_naixement = ?, adreca = ?, ciutat = ?, provincia = ?, codi_postal = ?, tipus_document = ?, numero_document = ?, sexe = ?, telefon = ?, id_rol = ? WHERE numero_document = ?;";       //La SQL per MODIFICAR clients
              
        try {
            
            pst = cn.prepareStatement(sql);                                     //Passar tots els valors necesaris per el insert
            pst.setString(1, cli.getNom());
            pst.setString(2, cli.getCognom1());
            pst.setString(3, cli.getCognom2());
            pst.setString(4, cli.getEmail());
            pst.setString(5, cli.getPassword());
            pst.setString(6, cli.getData_naixement());
            pst.setString(7, cli.getAdreca());
            pst.setString(8, cli.getCiutat());
            pst.setString(9, cli.getProvincia());
            pst.setString(10, cli.getCodi_postal());
            pst.setString(11, cli.getTipus_document());
            pst.setString(12, cli.getNumero_document());
            pst.setString(13, cli.getSexe());
            pst.setString(14, cli.getTelefon());
            pst.setInt(15, cli.getId_rol());
            pst.setString(16, clientnumerodocument);
            rowsInserted = pst.executeUpdate();
             
        } catch (SQLException e) {
           System.out.println(e.getMessage());                                  //Si existeix un error mostar-ho
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally {
            if (cn != null) {
                cn.close();                                                     //Tancar conexio i Statement
                pst.close();

            }
        } return rowsInserted;
    }
    
}
