/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.mysql.cj.xdevapi.Result;
import java.util.List;
import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Persona;

/**
 *
 * @author jeffe
 */
public class Persona_crud {
    
    Conexion con = new Conexion();
    Connection conec;
    PreparedStatement ps;
    ResultSet rs;
    
    public Persona_crud(){

        
      }
    public List listar(){
         List<Persona> datos = new ArrayList<Persona>();
         String sqlx= "Select * from persona";

         try {
            conec= con.establecer_conexion();
            ps = conec.prepareStatement("select *from persona");
            rs= ps.executeQuery();
             System.out.println("rs" +rs);
            while(rs.next()){
                Persona p= new Persona();
                p.setid(rs.getInt(1));
                p.setName(rs.getString("nombre"));
                p.setApellido(rs.getString(3));
                p.setfecha(rs.getString(4));
                p.setCorreo(rs.getString(5));
                datos.add(p);
            }
        } catch (SQLException e) {
            
        }
         
        return datos;
    }
    
    
    public boolean guardar(Persona per){
         String sqlx= "insert into persona (id,nombre,apellidos,fecha_nacimiento,correo) values (?,?,?,?,?)";

         try {
            conec= con.establecer_conexion();
            ps = conec.prepareStatement(sqlx);
            ps.setInt(1,0);
            ps.setString(2,per.getName());
            ps.setString(3,per.getapellido());
            ps.setString(4,per.getfecha());
            ps.setString(5,per.getCorreo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
            
        }finally{
             try {
                 conec.close();
             } catch (SQLException e) {
             }
         }
         
    }
    
    
        public boolean modificar(Persona per){
         String sqlx= "update persona set nombre=?, apellidos=?, fecha_nacimiento=?, correo=? where id=?";

         try {
            conec= con.establecer_conexion();
            ps = conec.prepareStatement(sqlx);
            ps.setString(1,per.getName());
            ps.setString(2,per.getapellido());
            ps.setString(3,per.getfecha());
            ps.setString(4,per.getCorreo());
             ps.setInt(5,per.getid());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
            
        }finally{
             try {
                 conec.close();
             } catch (SQLException e) {
             }
         }
         
    }
        
        
        
         public boolean eliminar(Persona per){
         String sqlx= "delete from persona where id=?";

         try {
            conec= con.establecer_conexion();
            ps = conec.prepareStatement(sqlx);
            ps.setInt(1,per.getid());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
            
        }finally{
             try {
                 conec.close();
             } catch (SQLException e) {
             }
         }
         
    }
    
    
    
    
    
}
