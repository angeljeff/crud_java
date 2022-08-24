/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Persona {

    int id ;
    String nombre;
    String apellidos;
    String fecha_nacimiento;
    String correo;
    
    public Persona(){
    }
    
    public Persona( String nombre, String apellido, String fecha, String correo){
        this.id= 0;
        this.nombre= nombre;
        this.apellidos= apellido;
        this.fecha_nacimiento= fecha;
        this.correo= correo;
    } 
    
        
    public void setid(int id) {
    this.id = id;
    }
    public int getid() {
    return id;
    }
    
    public void setName(String name) {
    this.nombre = name;
    }
    public String getName() {
    return nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }
    public String getapellido() {
        return apellidos;
    }
    public void setfecha(String fecha) {
        this.fecha_nacimiento = fecha;
    }
    public String getfecha() {
        return fecha_nacimiento;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCorreo() {
        return correo;
    }
    
    


}
