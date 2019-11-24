/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato.Controlador;

import Contrato.Modelo.*;
import Inmueble.Modelo.ConsultasInmueble;
import Inmueble.Modelo.Inmueble;
import Inquilino.Modelo.*;
import Vista.Contrato.FromBuscarInmueble;
import Vista.Contrato.FromBuscarInquilino;
import Vista.Contrato.FromContrato;
import Vista.Inquilino.PanelInquilino;
import Vista.fromMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CtrlContrato  implements ActionListener{
    private Contrato con;
    private ConsultaContrato consContr;
    private FromContrato frmCon;
    private ConsultasInmueble consultaInmueble=new ConsultasInmueble();    
    private ConsultasInquilno consultaInquilino=new ConsultasInquilno();
    private ArrayList<Inmueble> inmuebles=new ArrayList<Inmueble>();
    private ArrayList<Inquilino> inquilinos=new ArrayList<Inquilino>();
    private FromBuscarInmueble tableroBuscarInmueble = new FromBuscarInmueble();
    private FromBuscarInquilino tableroBuscarInquilino = new FromBuscarInquilino();
    
    public CtrlContrato (Contrato con, ConsultaContrato consContr, FromContrato frmCon) {
      
        this.con=con;
        this.consContr = consContr;
        this.frmCon = frmCon;
        this.frmCon.jButtonBuscarInmueble.addActionListener(this);
        this.frmCon.jButtonGuardar.addActionListener(this);
//        this.frmCon.btnModificar.addActionListener(this);
//        this.frmCon.btnBorrar.addActionListener(this);
//        this.frmCon.btnBuscar.addActionListener(this);
//        this.frmCon.btnLimpiar.addActionListener(this);
        
    
    }
    
    
  public void iniciar(){
      frmCon.setTitle("Contrato");
      frmCon.setLocationRelativeTo(null);
      //frmP.jtDni.setVisible(true);
      cargarInmueble();
      cargarInquilino();
  }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==frmCon.jButtonBuscarInmueble){
               //Boolean flagCerrar = false;
               frmCon.enable(false);
               tableroBuscarInmueble.setLocation(0, 0);
               tableroBuscarInmueble.setVisible(true);
               tableroBuscarInmueble.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent we){
                     
                      tableroBuscarInmueble.setVisible(false);
                       frmCon.enable(true);
                       frmCon.setVisible(true);
                       
                    }
               });
         }
         if (e.getSource()==frmCon.jButtonGuardar){
            try{
                  //  con.setId_contrato(Integer.parseInt(frmCon.txtID_contrato.getText()));
                    con.setEstado_contrato(frmCon.jComboBoxEstadoContrato.getSelectedItem().toString());
                    con.setMonto(Double.parseDouble(frmCon.txtMonto.getText()));
                    con.setId_inmueble(((Inmueble) frmCon.jComboBoxInmueble.getSelectedItem()).getId_inmueble());
                    con.setDni_inquilino(((Inquilino) frmCon.jComboBoxInquilino.getSelectedItem()).getDni_inquilino());
                    con.setFecha_ini(  frmCon.jDateChooserFecIni.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    con.setFecha_fin(  frmCon.jDateChooserFecFin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//                    con.setFecha_ini( frmCon.jDateChooserFecIni.getDate().);
//                    con.setFecha_fin( frmCon.jDateChooserFecFin.getDate());
                    
                    
          
                if (consContr.Guardar(con)){
              
                    JOptionPane.showMessageDialog(null, "Contrato Guardado");
                    limpiar();
                
               LocalDate.parse( frmCon.jDateChooserFecIni.getDate().toString() ,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
               // panelPropietarioList.cargarPropietarios();
              
              
                } else{ JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
        }
            catch(Exception num){JOptionPane.showMessageDialog(null, "Dato invalido");
      
            }
         }
         
         if (e.getSource()==frmCon.jButtonBuscarInquilino){
               Boolean flagCerrar = false;
               frmCon.enable(false);
               tableroBuscarInquilino.setLocation(0, 0);
               tableroBuscarInquilino.setVisible(true);
               tableroBuscarInquilino.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent we){
                     
                      tableroBuscarInquilino.setVisible(false);
                       frmCon.enable(true);
                       frmCon.setVisible(true);
                       
                    }
               });
         }
    }
    
    public void cargarInmueble(){
        consultaInmueble.obtenerInmuebles(inmuebles);
         for(Inmueble elem:inmuebles){
            this.frmCon.jComboBoxInmueble.addItem(elem);
         }
    }
    
    public void cargarInquilino(){
        consultaInquilino.obtenerInquilinos(inquilinos);
         for(Inquilino elem:inquilinos){
            this.frmCon.jComboBoxInquilino.addItem(elem);
         }
    }
    
    public void limpiar(){
      
      frmCon.txtID_contrato.setText("");
      frmCon.jComboBoxInquilino.setSelectedItem(null);
      frmCon.jComboBoxInmueble.setSelectedItem(null);
//      frmCon.jtDomicilio.setText("");
//      frmCon.jtTelefono.setText("");
      
  }
}
