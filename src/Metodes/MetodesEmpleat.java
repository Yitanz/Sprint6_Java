/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodes;

import Auxiliar.DBConnection;
import Classes.Empleat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class MetodesEmpleat {
    
   static DBConnection connexio = new DBConnection();
   static Statement statement = null;

   
    public static String RegistrarEmpleat(Empleat emp){
        String result = null, last = null;
          try{    
            statement = connexio.getConnection().createStatement();
              PreparedStatement pst = null;
              
              //crear usuari
              String sql = "INSERT INTO users values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null)";
              
              pst = connexio.getConnection().prepareStatement(sql);
              pst.setString(2, emp.getNom());
              pst.setString(3, emp.getCognom1());
              pst.setString(4, emp.getCognom2());
              pst.setString(5, emp.getEmail());
              pst.setDate(6, (Date) emp.getData_naixement());
              pst.setString(7, emp.getAdreca());
              pst.setString(8, emp.getCiutat());
              pst.setString(9, emp.getProvincia());
              pst.setString(10, emp.getCodi_postal());
              pst.setString(11, emp.getTipus_document());
              pst.setString(12, emp.getNumero_document());
              pst.setString(13, emp.getSexe());
              pst.setString(14, emp.getTelefon());
              pst.execute();
              
              //crear dades emp
              String sql2 = "INSERT INTO dades_empleats values(null,?,?,?,?,?,?,?,?,null,null)";
              
              pst = connexio.getConnection().prepareStatement(sql2);
              pst.setString(2, emp.getCodi_seg_social());
              pst.setString(3, emp.getNum_nomina());
              pst.setString(4, emp.getIBAN());
              pst.setString(5, emp.getEspecialitat());
              pst.setString(6, emp.getCarrec());
              pst.setDate(7, (Date) emp.getData_inici_contracte());
              pst.setDate(8, (Date) emp.getData_fi_contracte());
              pst.setString(9, emp.getId_horari());
              pst.execute();
              
              result = "Empleat registrat amb exit";
              statement.close();
              connexio.disconnect();
              
              
        }catch(Exception e){
            
        }
          return result;
    }
    
    
   
}
