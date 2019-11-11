
package Propietario.Controlador;

import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import Vista.Propietario.frmPropietario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class CtrPropietario implements ActionListener{
    
    private Propietario pod;
    private ConsultasPropietario podP;
    private frmPropietario frmP;
    
    public CtrPropietario (Propietario pod, ConsultasPropietario podP, frmPropietario frmP) {
      
        this.pod=pod;
        this.podP=podP;
        this.frmP=frmP;
        this.frmP.btnGuardar.addActionListener(this);
        this.frmP.btnModificar.addActionListener(this);
        this.frmP.btnBorrar.addActionListener(this);
        this.frmP.btnBuscar.addActionListener(this);
        this.frmP.btnLimpiar.addActionListener(this);
        
    
    }
    
    
  public void iniciar(){
      frmP.setTitle("Propietarios");
      frmP.setLocationRelativeTo(null);
      frmP.jtDni.setVisible(true);
  }
 
    @Override
  public void actionPerformed(ActionEvent e){
      
     
      if (e.getSource()==frmP.btnGuardar){
          
      try{
          pod.setDni_propietario(Integer.parseInt(frmP.jtDni.getText()));
          pod.setNombre_propietario(frmP.jtNombre.getText());
          pod.setApellido_propietario(frmP.jtApellido.getText());
          pod.setDomicilio_propietario(frmP.jtDomicilio.getText());
          pod.setTelefono_propietario(Long.parseLong(frmP.jtTelefono.getText()));
          
          if (podP.Guardar(pod)){
              
              JOptionPane.showMessageDialog(null, "Propietario Guardado");
              limpiar();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al Guardar");
              limpiar();
      }
      }
          catch(Exception num){JOptionPane.showMessageDialog(null, "Dato invalido");
      
  }
      }
      
      if (e.getSource()==frmP.btnModificar){
          try{
          
          pod.setDni_propietario(Integer.parseInt(frmP.jtDni.getText()));
          pod.setNombre_propietario(frmP.jtNombre.getText());
          pod.setApellido_propietario(frmP.jtApellido.getText());
          pod.setDomicilio_propietario(frmP.jtDomicilio.getText());
          pod.setTelefono_propietario(Long.parseLong(frmP.jtTelefono.getText()));
          
          if (podP.Modificar(pod)){
              
              JOptionPane.showMessageDialog(null, "Propietario Modificado");
              limpiar();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al Modificar");
              limpiar();
      }}
          catch(Exception num){JOptionPane.showMessageDialog(null, "Dato invalido");
      
  }
      
      }
      
      if (e.getSource()==frmP.btnBorrar){
          
          pod.setDni_propietario(Integer.parseInt(frmP.jtDni.getText()));
        
          
          if (podP.Borrar(pod)){
              
              JOptionPane.showMessageDialog(null, "Propietario Borrado");
              limpiar();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al Borrar");
              limpiar();
      }
      
      }
      
      if (e.getSource()==frmP.btnBuscar){
          
          pod.setDni_propietario(Integer.parseInt(frmP.jtDni.getText()));
        
          
          if (podP.Buscar(pod)){
              
              
              frmP.jtDni.setText(String.valueOf(pod.getDni_propietario()));
              frmP.jtNombre.setText(String.valueOf(pod.getNombre_propietario()));
              frmP.jtApellido.setText(String.valueOf(pod.getApellido_propietario()));
              frmP.jtDomicilio.setText(String.valueOf(pod.getDomicilio_propietario()));
              frmP.jtTelefono.setText(String.valueOf(pod.getTelefono_propietario()));
   
          } else{ JOptionPane.showMessageDialog(null, "No se Encontro el propietario");
              limpiar();
      }              
      
      }
       if(e.getSource()== frmP.btnLimpiar){
              limpiar();
       }
    
}
  
       
  
 
  public void limpiar(){
      
      frmP.jtDni.setText("");
      frmP.jtNombre.setText("");
      frmP.jtApellido.setText("");
      frmP.jtDomicilio.setText("");
      frmP.jtTelefono.setText("");
      
  }



}
