/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author jeffe
 */
public class Conexion {
    
    Connection conexion= null;
    String usuario= "root";
    String contrasenia="";
    String bd="crud";
    String ip="127.0.0.1";
    String port="3306";
    String url= "jdbc:mysql://"+ip+":"+port+"/"+bd;
    
    public Connection establecer_conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(url,usuario,contrasenia);
  
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return conexion;
    }
    
    
    
}
