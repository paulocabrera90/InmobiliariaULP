/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato.Controlador;

import Contrato.Modelo.*;
import Inmueble.Modelo.ConsultasInmueble;
import Inmueble.Modelo.Inmueble;
import Vista.Contrato.FromBuscarInmueble;
import Vista.Contrato.FromContrato;
import Vista.fromMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CtrlContrato  implements ActionListener{
    private Contrato con;
    private ConsultaContrato consContr;
    private FromContrato frmCon;
    private ConsultasInmueble consultaInmueble=new ConsultasInmueble();
    private ArrayList<Inmueble> inmuebles=new ArrayList<Inmueble>();
    
    
    public CtrlContrato (Contrato con, ConsultaContrato consContr, FromContrato frmCon) {
      
        this.con=con;
        this.consContr = consContr;
        this.frmCon = frmCon;
        this.frmCon.jButtonBuscarInmueble.addActionListener(this);
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
      
  }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource()==frmCon.jButtonBuscarInmueble){
               FromBuscarInmueble tableroBuscarInmueble = new FromBuscarInmueble();
               tableroBuscarInmueble.setLocation(0, 0);
               tableroBuscarInmueble.setVisible(true);
               
         }
    }
    
    public void cargarInmueble(){
        consultaInmueble.obtenerInmuebles(inmuebles);
         for(Inmueble elem:inmuebles){
            this.frmCon.jComboBoxInmueble.addItem(elem);
         }
    }
}
