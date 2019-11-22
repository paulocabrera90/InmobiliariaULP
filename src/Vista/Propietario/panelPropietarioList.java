/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Propietario;

import Inquilino.Controlador.CtrInquilino;
import Inquilino.Modelo.ConsultasInquilno;
import Inquilino.Modelo.Inquilino;
import Propietario.Controlador.CtrPropietario;
import Propietario.Modelo.Conexion;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import Vista.Inquilino.PanelInquilino;
import static Vista.Inquilino.PanelInquilino.borrarInquilinos;
import static Vista.Inquilino.PanelInquilino.cargarInquilinos;
import static Vista.Inquilino.PanelInquilino.modeloInquilino;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Usuario
 */
public class panelPropietarioList extends javax.swing.JPanel {
 
    public static DefaultTableModel modeloPropietario;
    private static ConsultasPropietario cdPropietario=new ConsultasPropietario();
     private static ArrayList<Propietario> propietarios=new ArrayList<Propietario>();
    public panelPropietarioList() {
        initComponents();
       // DefaultTableModel modeloPropietario = new DefaultTableModel();
         //    jTablePropietario.setModel(modelo);
         modeloPropietario= new DefaultTableModel(){ 
            @Override
	 public boolean isCellEditable(int row, int column) {
         return false;
	}
	};
        
        jTablePropietario.addMouseListener
    (
    	new MouseAdapter()
    	{
    	public void mouseClicked(MouseEvent evnt)
    	{
          if (evnt.getClickCount() > 1)
          {
                    Propietario propietario=new Propietario();
                    ConsultasPropietario cdPropietario=new ConsultasPropietario();
                    Vista.Propietario.frmPropietario frmP = new Vista.Propietario.frmPropietario();
                  // int fila=Vista.Inquilino.PanelInquilino.modeloInquilino.
                   //  inquilino.setDni_inquilino(Vista.Inquilino.PanelInquilino.modeloInquilino.getSelectedRow());
                   propietario= panelPropietarioList.obtenerIPropietarioDeTabla();
                   cdPropietario.Buscar(propietario);
                   frmP.jtDni.setText(Integer.toString(propietario.getDni_propietario()));
                  frmP.jtNombre.setText(propietario.getNombre_propietario());
                   frmP.jtApellido.setText(propietario.getApellido_propietario());
                   frmP.jtDomicilio.setText(propietario.getDomicilio_propietario());
                   frmP.jtTelefono.setText(propietario.getTelefono_propietario());
                   CtrPropietario ctrPropietario = new CtrPropietario(propietario, cdPropietario, frmP);
                   ctrPropietario.iniciar();
                   panelPropietarioList.cargarPropietarios();	
                   frmP.btnGuardar.setEnabled(false);
                   
          }
    	}
    	}
    );
        
        armarCabeceraPropietario();
        cargarPropietarios();
      //  borrarInquilinos();
    
        
    }
    
     public void armarCabeceraPropietario(){
        ArrayList<Object> columnasp=new ArrayList<Object>();
        columnasp.add("Dni");
            columnasp.add("Nombre");
            columnasp.add("Apellido");
            columnasp.add("Domicilio");
            columnasp.add("Telefono");
     for(Object col:columnasp) 
            modeloPropietario.addColumn(col);
        jTablePropietario.setModel(modeloPropietario);}
        
        
         public static void cargarPropietarios(){
        propietarios.clear();
      cdPropietario.obtenerPropietarios(propietarios);
        borrarPropietarios();
        for(Propietario pro:propietarios){
            modeloPropietario.addRow(new Object[] {pro.getDni_propietario(),pro.getNombre_propietario(),pro.getApellido_propietario(),
                pro.getDomicilio_propietario(),pro.getTelefono_propietario()});
        }}
              public static void borrarPropietarios(){
        int c=modeloPropietario.getRowCount()-1;
        for(int i=c;i>=0;i--)
            modeloPropietario.removeRow(i);
    }
              
       public static Propietario  obtenerIPropietarioDeTabla(){
        Propietario propietario=new Propietario();
          
      int fila=jTablePropietario.getSelectedRow();
      if (fila > -1){
       propietario.setDni_propietario((int)jTablePropietario.getValueAt(fila, 0));
       cdPropietario.Buscar(propietario);
       return propietario;
      } else{ // JOptionPane.showMessageDialog(null, "Inquilino Guardado");
      //return inquilino;
        return null;      
      } }      
        
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAbrirPropietario = new javax.swing.JButton();
        btnBorrarPropietario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePropietario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDNIB = new javax.swing.JTextField();
        btnBuscarB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombreB = new javax.swing.JTextField();
        txtApellidoB = new javax.swing.JTextField();
        btnNuevoPropietario = new javax.swing.JButton();

        btnAbrirPropietario.setText("Abrir");
        btnAbrirPropietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirPropietarioMouseClicked(evt);
            }
        });

        btnBorrarPropietario.setText("Borrar");

        jTablePropietario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dni", "Nombre", "Apellido"
            }
        ));
        jScrollPane1.setViewportView(jTablePropietario);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Apellido:");

        jLabel1.setText("Busqueda Propietario:");

        jLabel4.setText("DNI:");

        btnBuscarB.setText("Buscar");
        btnBuscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        txtNombreB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreB, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoB, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDNIB, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(btnBuscarB)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDNIB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnBuscarB)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        btnNuevoPropietario.setText("Nuevo");
        btnNuevoPropietario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoPropietarioMouseClicked(evt);
            }
        });
        btnNuevoPropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPropietarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnNuevoPropietario)
                        .addGap(51, 51, 51)
                        .addComponent(btnAbrirPropietario)
                        .addGap(46, 46, 46)
                        .addComponent(btnBorrarPropietario)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAbrirPropietario)
                            .addComponent(btnBorrarPropietario)
                            .addComponent(btnNuevoPropietario))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirPropietarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirPropietarioMouseClicked
        Propietario pod = new Propietario();
        ConsultasPropietario podP = new ConsultasPropietario ();
        Vista.Propietario.frmPropietario frmP = new Vista.Propietario.frmPropietario();

        CtrPropietario ctrl = new CtrPropietario(pod,podP,frmP);
        ctrl.iniciar();
        this.setEnabled(false);
        //-----------------

        frmP.setVisible(true);
    }//GEN-LAST:event_btnAbrirPropietarioMouseClicked

    private void btnBuscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBActionPerformed
             List <Propietario> Propietariobus = new ArrayList<Propietario>() ;
        ConsultasPropietario cdPropietario = new ConsultasPropietario();
       
       StringBuffer buffer = new StringBuffer( "SELECT * FROM propietario WHERE " );
       
       if ((txtNombreB.getText().length() < 1)
           &&(txtApellidoB.getText().length() < 1) && ( txtDNIB.getText().length()<1))
      {
            borrarPropietarios();
           cargarPropietarios();
      }
      else {
       if ((txtNombreB.getText() != null && txtNombreB.getText().length() > 0)
           &&( txtApellidoB.getText() != null && txtApellidoB.getText().length() > 0 ) && ( txtDNIB.getText() != null && txtDNIB.getText().length() > 0 ))
       {
           buffer.append("nombre_propietario LIKE '%"+txtNombreB.getText()+"%' AND apellido_propietario LIKE '%"+txtApellidoB.getText()+"%' AND dni_propietario LIKE '%"+txtDNIB.getText()+"%'");
       }
       else {
            if ((txtNombreB.getText() != null &&txtNombreB.getText().length() > 0)
           &&( txtApellidoB.getText() != null && txtApellidoB.getText().length() > 0 )){
              buffer.append("nombre_propietario LIKE '%"+txtNombreB.getText()+"%' AND apellido_propietario LIKE '%"+txtApellidoB.getText()+"%'");  
            } 
            else {
              if ((txtNombreB.getText() != null && txtNombreB.getText().length() > 0) && (txtDNIB.getText() != null && txtDNIB.getText().length() > 0 ))
              {
                  buffer.append("nombre_propietario LIKE '%"+txtNombreB.getText()+"%' AND dni_propietario LIKE '%"+txtDNIB.getText()+"%'");
              } 
              else{
                  if((txtApellidoB.getText() != null && txtApellidoB.getText().length() > 0 ) && ( txtDNIB.getText() != null &&txtDNIB.getText().length() > 0 ))
                  {
                     buffer.append (" apellido_propietario LIKE '%"+txtApellidoB.getText()+"%' AND dni_propietario LIKE '%"+txtDNIB.getText()+"%'");
                  }
                  else {
                      if( txtNombreB.getText() != null && txtNombreB.getText().length() > 0 ) 
                      { //suponiendo que el parámetro fuera un String
                      buffer.append( "nombre_propietario LIKE '%"+txtNombreB.getText()+"%'" );
                      }
                      else {
                         if( txtApellidoB.getText() != null && txtApellidoB.getText().length() > 0 ) 
                         { //suponiendo que el parámetro fuera un String
                          buffer.append( "apellido_propietario LIKE '%"+ txtApellidoB.getText()+"%'");
                          } 
                          else {
                             if(txtDNIB.getText() != null &&txtDNIB.getText().length() > 0 ) 
                             { //suponiendo que el parámetro fuera un String
                               buffer.append( "dni_propietario LIKE '%"+txtDNIB.getText()+"%'" );
                             } 
                             //else{
                             ///    cargarInquilinos();
                             //}
                      }
                   }
                }
              }
            }
             Propietariobus = cdPropietario.busquedaXNomApeDniP(buffer); //.(JtNombre_inqui.getText());
             borrarPropietarios();
            if (Propietariobus.isEmpty()){
                JOptionPane.showMessageDialog(null, "No se encontraron resultados");
            } else {
             for(Propietario pro: Propietariobus){
                modeloPropietario.addRow(new Object[] {pro.getDni_propietario(),pro.getNombre_propietario(),pro.getApellido_propietario(),
                pro.getDomicilio_propietario(),pro.getTelefono_propietario()});
              }
            }
       
       
    
       
       }
       }             
    }//GEN-LAST:event_btnBuscarBActionPerformed

    private void txtNombreBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBActionPerformed

    private void btnNuevoPropietarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoPropietarioMouseClicked
        Propietario pod = new Propietario();
        ConsultasPropietario podP = new ConsultasPropietario ();
        Vista.Propietario.frmPropietario frmP = new Vista.Propietario.frmPropietario();

        CtrPropietario ctrl = new CtrPropietario(pod,podP,frmP);
        ctrl.iniciar();
        this.setEnabled(false);
        //-----------------

        frmP.setVisible(true);

    }//GEN-LAST:event_btnNuevoPropietarioMouseClicked

    private void btnNuevoPropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPropietarioActionPerformed

    }//GEN-LAST:event_btnNuevoPropietarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirPropietario;
    private javax.swing.JButton btnBorrarPropietario;
    public javax.swing.JButton btnBuscarB;
    private javax.swing.JButton btnNuevoPropietario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTablePropietario;
    public javax.swing.JTextField txtApellidoB;
    public javax.swing.JTextField txtDNIB;
    public javax.swing.JTextField txtNombreB;
    // End of variables declaration//GEN-END:variables
}
