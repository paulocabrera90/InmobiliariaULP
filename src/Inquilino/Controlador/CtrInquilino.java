/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquilino.Controlador;

import Vista.Inquilino.frmInquilino;
import Inquilino.Modelo.Inquilino;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
//import Contrato.Modelo.frmInquilino;

import Inquilino.Modelo.ConsultasInquilno;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JOptionPane;
import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;
import Vista.*;

/**
 *
 * @author Martin
 */
public class CtrInquilino implements  ActionListener{
    
    private Inquilino inquilino;
    private ConsultasInquilno cdInquilino;
    private frmInquilino frmI;
   // private panelInquilino pnlI;
   
    public CtrInquilino(Inquilino inquilino, ConsultasInquilno cdInquilino, frmInquilino frmI) {
      
        this.inquilino=inquilino;
        this.cdInquilino=cdInquilino;
        this.frmI=frmI;
        this.frmI.btnGuardar.addActionListener(this);
        this.frmI.btnModificar.addActionListener(this);
        this.frmI.btnBorrar.addActionListener(this);
      //  this.frmI.btnBuscar.addActionListener(this);
        this.frmI.btnLimpiar.addActionListener(this);
        
    
    }

    
    
  public void iniciar(){
   frmI.setVisible(true);
   
  }
 
    
    @Override
  public void actionPerformed(ActionEvent e){
      
      if (e.getSource()==frmI.btnGuardar){
          inquilino.setDni_inquilino(Integer.parseInt(frmI.jtDni.getText()));
          inquilino.setNombre_inquilino(frmI.jtNombre.getText());
          inquilino.setApellido_inquilino(frmI.jtApellido.getText());
          inquilino.setCuit_inquilino(Integer.parseInt(frmI.jtCuit.getText()));
          inquilino.setLugar_trabajo_inquilino(frmI.jtLugarTrab.getText());
          inquilino.setNom_garante_inquilino(frmI.jtGarante.getText());
          inquilino.setDni_garante_inquilino(Integer.parseInt(frmI.jtDniGarante.getText()));
          
          if (cdInquilino.Guardar(inquilino)){
              
              JOptionPane.showMessageDialog(null, "Inquilino Guardado");
              limpiar();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al Guardar");
              limpiar();
      }
      
  }
      
      if (e.getSource()==frmI.btnModificar){
          
         inquilino.setDni_inquilino(Integer.parseInt(frmI.jtDni.getText()));
          inquilino.setNombre_inquilino(frmI.jtNombre.getText());
          inquilino.setApellido_inquilino(frmI.jtApellido.getText());
          inquilino.setCuit_inquilino(Integer.parseInt(frmI.jtCuit.getText()));
          inquilino.setLugar_trabajo_inquilino(frmI.jtLugarTrab.getText());
          inquilino.setNom_garante_inquilino(frmI.jtGarante.getText());
          inquilino.setDni_garante_inquilino(Integer.parseInt(frmI.jtDniGarante.getText()));
          
          if (cdInquilino.Modificar(inquilino)){
              
              JOptionPane.showMessageDialog(null, "Inquilino Modificado");
              limpiar();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al Modificar");
              limpiar();
      }
      
      }
      
      if (e.getSource()==frmI.btnBorrar){
          
          inquilino.setDni_inquilino(Integer.parseInt(frmI.jtDni.getText()));
        
          
          if (cdInquilino.Borrar(inquilino)){
              
              JOptionPane.showMessageDialog(null, "Inquilino Borrado");
              limpiar();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al Borrar");
              limpiar();
      }
      
      }
      
     /* if (e.getSource()== frmI.jbtnBuscarInqui){
          
          inquilino.setDni_inquilino(Integer.parseInt(pnlI.jbtnBuscarInqui.getText()));
        
          
          if (cdInquilino.Buscar(inquilino)){
              
              
           inquilino.setDni_inquilino(Integer.parseInt(frmI.jtDni.getText()));
          inquilino.setNombre_inquilino(frmI.jtNombre.getText());
          inquilino.setApellido_inquilino(frmI.jtApellido.getText());
          inquilino.setCuit_inquilino(Integer.parseInt(frmI.jtCuit.getText()));
          inquilino.setLugar_trabajo_inquilino(frmI.jtLugarTrab.getText());
          inquilino.setNom_garante_inquilino(frmI.jtGarante.getText());
          inquilino.setDni_garante_inquilino(Integer.parseInt(frmI.jtDniGarante.getText()));
   
          } else{ JOptionPane.showMessageDialog(null, "No se Encontro el propietario");
              limpiar();
      }              
      
      }*/
       if(e.getSource()== frmI.btnLimpiar){
              limpiar();
       }
    
}
  
 
  public void limpiar(){
      
      frmI.jtDni.setText("");
      frmI.jtNombre.setText("");
      frmI.jtApellido.setText("");
      frmI.jtCuit.setText("");
      frmI.jtLugarTrab.setText("");
      frmI.jtDniGarante.setText("");
      frmI.jtGarante.setText("");
      
  }

}
