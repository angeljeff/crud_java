/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Vistas.panel_crud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.Persona_crud;

/**
 *
 * @author jeffe
 */
public class controlador_persona implements ActionListener{
    Persona per= new Persona();
    Persona_crud crud= new Persona_crud();
    panel_crud vista= new panel_crud();
    DefaultTableModel tabla_persona = new DefaultTableModel();

    public controlador_persona(panel_crud pa) {
        this.vista=pa;
        this.vista.btnlistar.addActionListener(this);
        this.vista.btnguardar.addActionListener(this);
        this.vista.btnlimpiar.addActionListener(this);
        this.vista.btnmodificar.addActionListener(this);
    }
    
    
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnlistar){
            System.out.println("llegue aqui");
            listar(vista.tabla);
        }
        
        if(e.getSource()==vista.btnguardar){
            
            System.out.println("llegue aqui");
            guardar();
        }
        if(e.getSource()== vista.btnlimpiar){
            limpiar();
        }
        if(e.getSource()== vista.btnmodificar){
            modificar();
        }
        if(e.getSource()== vista.btnlimpiar){
            limpiar();
        }
        
    }
    
    public void guardar(){
        per.setid(0);
        per.setName(vista.inputnombre.getText());
        per.setApellido(vista.inputapellido.getText());
        per.setfecha(vista.inputfecha.getText());
        per.setCorreo(vista.inputcorreo.getText());
        if(crud.guardar(per)){
            JOptionPane.showMessageDialog(null, "persona registrada");
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido registrar a la persona");
        } 
    
    }
    
        public void modificar(){
        per.setid(Integer.parseInt(vista.inputid.getText()));
        per.setName(vista.inputnombre.getText());
        per.setApellido(vista.inputapellido.getText());
        per.setfecha(vista.inputfecha.getText());
        per.setCorreo(vista.inputcorreo.getText());
        if(crud.modificar(per)){
            JOptionPane.showMessageDialog(null, "persona modificada");
        }else{
            JOptionPane.showMessageDialog(null, "No se ha podido modificar a la persona");
        } 
    
    }
    
    public void limpiar(){
        vista.inputid.setText(null);
        vista.inputnombre.setText(null);
        vista.inputapellido.setText(null);
        vista.inputfecha.setText(null);
        vista.inputcorreo.setText(null);
    
    }
    
    
    
    
    public void listar(JTable tabla){
        System.out.println("ahora aqui");
        tabla_persona = (DefaultTableModel) tabla.getModel();
        
        List<Persona> lista=crud.listar();
        System.out.println("esta es la lista"+lista);
        Object[]object= new Object[5];
        tabla_persona.setRowCount(0);
        for(int i=0; i<lista.size(); i++){
            System.out.println("esta es el tamaño"+lista.size());
            object[0]=lista.get(i).getid();
            object[1]=lista.get(i).getName();
            object[2]=lista.get(i).getapellido();
            object[3]=lista.get(i).getfecha();
            object[4]=lista.get(i).getCorreo();
            
            tabla_persona.addRow(object);
            
            
        }
        vista.tabla.setModel(tabla_persona);
    }
    
}
