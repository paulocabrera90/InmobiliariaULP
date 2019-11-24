/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmueble.Controlador;

import Inmueble.Modelo.ConsultasInmueble;
import Inmueble.Modelo.ConsultasTipoInmueble;
import Vista.Inmueble.FormInmueble;
import Inmueble.Modelo.Inmueble;
import Inmueble.Modelo.TipoInmueble;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import Vista.Inmueble.PanelInmueble;
import Vista.fromMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author garba
 */
public class CrlInmueble implements ActionListener{
    private Inmueble inmueble;
    private ConsultasInmueble consulta;
    private FormInmueble formulario;
    private ArrayList<TipoInmueble> tiposinmueble=new ArrayList<TipoInmueble>();
    private ArrayList<Propietario> propietarios=new ArrayList<Propietario>();
    private ConsultasTipoInmueble consultatipoinmueble=new ConsultasTipoInmueble();
    private Propietario propietario=new Propietario();
    private ConsultasPropietario consultaprop=new ConsultasPropietario();
    private TipoInmueble tipoinmueble= new TipoInmueble();
    private ConsultasTipoInmueble consultatipo=new ConsultasTipoInmueble();
    
    
    
    public CrlInmueble (Inmueble inmueble, ConsultasInmueble consulta, FormInmueble formulario) {
      
        this.inmueble=inmueble;
        this.consulta=consulta;
        this.formulario=formulario;
        this.formulario.btnGuardar.addActionListener(this);
        this.formulario.btnModificar.addActionListener(this);
        this.formulario.btnBorrar.addActionListener(this);
        this.formulario.btnLimpiar.addActionListener(this);
        
    
    }
    
    
  public void iniciar(){
      formulario.setTitle("Inmuebles");
      cargarTipoInmueble();
      cargarDniPropietario();
      formulario.rbDisponible.setSelected(true);
      formulario.cboPropietarios.setSelectedIndex(-1);
      formulario.cboTipo_inm.setSelectedIndex(-1);
  }
 
    @Override
  public void actionPerformed(ActionEvent e){
      
      if (e.getSource()==formulario.btnGuardar){
          propietario.setDni_propietario(((Propietario)formulario.cboPropietarios.getSelectedItem()).getDni_propietario());
          consultaprop.Buscar(propietario);
          inmueble.setPropietario(propietario);
          inmueble.setTipo_inmueble((TipoInmueble) formulario.cboPropietarios.getSelectedItem());
          inmueble.setDireccion_inmueble(formulario.txtDireccion.getText());
          if(formulario.rbDisponible.isSelected())
            inmueble.setEstado_inmueble("Disponible");
          else 
              inmueble.setEstado_inmueble("No disponible");
          inmueble.setPrecio_base(Double.parseDouble(formulario.txtPrecio.getText()));
          inmueble.setSuperficie(Double.parseDouble(formulario.txtSuperficie.getText()));
          
          
          if (consulta.GuardarInmueble(inmueble)){
              
              JOptionPane.showMessageDialog(null, "Inmueble guardado");
              limpiar();
              PanelInmueble.cargarInmueblesFiltrados();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al guardar inmueble");
              limpiar();
      }
      
  }
      
      if (e.getSource()==formulario.btnModificar){
          propietario.setDni_propietario(((Propietario)formulario.cboPropietarios.getSelectedItem()).getDni_propietario());
          consultaprop.Buscar(propietario);
          inmueble.setPropietario(propietario);
          inmueble.setTipo_inmueble((TipoInmueble) formulario.cboPropietarios.getSelectedItem());
          inmueble.setDireccion_inmueble(formulario.txtDireccion.getText());
          if(formulario.rbDisponible.isSelected())
            inmueble.setEstado_inmueble("Disponible");
          else 
              inmueble.setEstado_inmueble("No disponible");
          inmueble.setPrecio_base(Double.parseDouble(formulario.txtPrecio.getText()));
          inmueble.setSuperficie(Double.parseDouble(formulario.txtSuperficie.getText()));
          
          if (consulta.Modificar(inmueble)){
              
              JOptionPane.showMessageDialog(null, "Inmueble modificado");
              limpiar();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al modificar");
              limpiar();
      }
      
      }
      
      if (e.getSource()==formulario.btnBorrar){
          
          inmueble.setId_inmueble(Integer.parseInt(formulario.txtID_inmueble.getText()));

          if (consulta.Borrar(inmueble.getId_inmueble())){
              
              JOptionPane.showMessageDialog(null, "Inmueble borrado");
              limpiar();
              PanelInmueble.cargarInmueblesFiltrados();
              
              
          } else{ JOptionPane.showMessageDialog(null, "Error al borrar");
              limpiar();
      }
      
      }
      
     
          
       if(e.getSource()== formulario.btnLimpiar){
              limpiar();
       }

  }
  public void limpiar(){
      formulario.txtID_inmueble.setText("");
      formulario.txtDireccion.setText("");
      formulario.cboPropietarios.setSelectedIndex(-1);
      formulario.txtPrecio.setText("");
      formulario.txtSuperficie.setText("");
 
      
  }
  public void cargarTipoInmueble(){
      consultatipoinmueble.ObtenerTiposInmueble(tiposinmueble);
      for(TipoInmueble elem:tiposinmueble)
      formulario.cboTipo_inm.addItem(elem);
  }
  public void cargarDniPropietario(){
      consultaprop.obtenerPropietarios(propietarios);
      for(Propietario prop:propietarios)
          formulario.cboPropietarios.addItem(prop);
      
  }
  /*public void cargarPropietarios(){
      consultaprop
      System.out.println(tiposinmueble.size());
      for(TipoInmueble elem:tiposinmueble)
      formulario.cboTipo_inm.addItem(elem);
  }*/
    
}
