/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Inmueble;

import Inmueble.Controlador.CrlInmueble;
import Inmueble.Modelo.ConsultasInmueble;
import Inmueble.Modelo.Inmueble;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author garba
 */
public class PanelInmueble extends javax.swing.JPanel {

  private Propietario propietario=new Propietario();
    private Inmueble inmueble=new Inmueble();
    private static ConsultasPropietario consultasp= new ConsultasPropietario();
    private static ConsultasInmueble consultasi=new ConsultasInmueble();
    private static ArrayList<Inmueble> inmuebles=new ArrayList<Inmueble>();
    private static DefaultTableModel modeloinmuebles;
    
    public PanelInmueble() {
        initComponents();
        modeloinmuebles=new DefaultTableModel();
        armarCabeceraInmuebles();
        cargarInmuebles();
        grpbotonesgrilla.add(rbDisponiblegrilla);
        grpbotonesgrilla.add(rbNodisponiblegrilla);
 
        
    }
    public void armarCabeceraInmuebles(){
        ArrayList<Object> columnasi=new ArrayList<Object>();
        columnasi.add("ID inmueble");
        columnasi.add("Características");
        columnasi.add("Propietario");
        columnasi.add("Superficie");
        columnasi.add("Precio mensual");
        for(Object col:columnasi)
            modeloinmuebles.addColumn(col);
        tabInmuebles.setModel(modeloinmuebles);
    }
    public static void cargarInmuebles(){
        inmuebles.clear();
        consultasi.obtenerInmuebles(inmuebles);
        borrarInmuebles();
        for(Inmueble i:inmuebles){
            modeloinmuebles.addRow(new Object[] {i.getId_inmueble(),i.getTipo_inmueble(),i.getPropietario().getApellido_propietario(),i.getSuperficie(),i.getPrecio_base()});
        }
        
    }
    
    public static void borrarInmuebles(){
        int c=modeloinmuebles.getRowCount()-1;
        for(int i=c;i>=0;i--)
            modeloinmuebles.removeRow(i);
    }
    public static void cargarDisponibles(){
        inmuebles.clear();
        consultasi.obtenerInmueblesDisponibles(inmuebles);
        borrarInmuebles();
        for(Inmueble i:inmuebles){
            modeloinmuebles.addRow(new Object[] {i.getId_inmueble(),i.getTipo_inmueble(),i.getPropietario().getApellido_propietario(),i.getSuperficie(),i.getPrecio_base()});
        }
    }
    public static void cargarNoDisponibles(){
        inmuebles.clear();
        consultasi.obtenerInmueblesNoDisponibles(inmuebles);
        borrarInmuebles();
        for(Inmueble i:inmuebles){
            modeloinmuebles.addRow(new Object[] {i.getId_inmueble(),i.getTipo_inmueble(),i.getPropietario().getApellido_propietario(),i.getSuperficie(),i.getPrecio_base()});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDnipropietario1 = new javax.swing.JTextField();
        grpbotonesgrilla = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabInmuebles = new javax.swing.JTable();
        btnInmuebleNuevo = new javax.swing.JButton();
        btnEliminarInmueble = new javax.swing.JButton();
        btnAbrirInmueble = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rbDisponiblegrilla = new javax.swing.JRadioButton();
        rbNodisponiblegrilla = new javax.swing.JRadioButton();

        tabInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabInmuebles);

        btnInmuebleNuevo.setText("Nuevo");
        btnInmuebleNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInmuebleNuevoActionPerformed(evt);
            }
        });

        btnEliminarInmueble.setText("Eliminar");
        btnEliminarInmueble.setToolTipText("");
        btnEliminarInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInmuebleActionPerformed(evt);
            }
        });

        btnAbrirInmueble.setText("Abrir");
        btnAbrirInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirInmuebleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Inmuebles");

        rbDisponiblegrilla.setText("Disponible");
        rbDisponiblegrilla.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbDisponiblegrillaStateChanged(evt);
            }
        });
        rbDisponiblegrilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDisponiblegrillaActionPerformed(evt);
            }
        });

        rbNodisponiblegrilla.setText("No disponible");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbDisponiblegrilla)
                        .addGap(18, 18, 18)
                        .addComponent(rbNodisponiblegrilla))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminarInmueble, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInmuebleNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAbrirInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDisponiblegrilla)
                    .addComponent(rbNodisponiblegrilla))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInmuebleNuevo)
                        .addGap(24, 24, 24)
                        .addComponent(btnEliminarInmueble)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbrirInmueble))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInmuebleNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInmuebleNuevoActionPerformed
        
        Inmueble inmueble= new Inmueble();
        FormInmueble formularioinmueble= new FormInmueble();
        ConsultasInmueble consultasinmueble=new ConsultasInmueble();
        CrlInmueble crlinmueble=new CrlInmueble(inmueble,consultasinmueble,formularioinmueble);
        crlinmueble.iniciar();
        formularioinmueble.setVisible(true);
    }//GEN-LAST:event_btnInmuebleNuevoActionPerformed

    private void btnEliminarInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInmuebleActionPerformed

        ConsultasInmueble consultainmueble= new ConsultasInmueble();
        if(tabInmuebles.getRowCount()!=0)
        {
            consultainmueble.Borrar((Integer)tabInmuebles.getValueAt(tabInmuebles.getSelectedRow(),0));
            int rowselected=tabInmuebles.getSelectedRow();
            modeloinmuebles.removeRow(rowselected);
            cargarInmuebles();
        }
    }//GEN-LAST:event_btnEliminarInmuebleActionPerformed

    private void btnAbrirInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirInmuebleActionPerformed
       ConsultasInmueble consultainmueble= new ConsultasInmueble();
       Inmueble inmueble= new Inmueble();
       FormInmueble formulario= new FormInmueble();
       CrlInmueble crlinmueble=new CrlInmueble(inmueble,consultainmueble,formulario);
       crlinmueble.iniciar();
       formulario.setVisible(true);
        if(tabInmuebles.getRowCount()!=0)
        {
            inmueble.setId_inmueble(((Integer)tabInmuebles.getValueAt(tabInmuebles.getSelectedRow(),0)));
            consultainmueble.Buscar(inmueble);
            formulario.txtID_inmueble.setText(Integer.toString(inmueble.getId_inmueble()));
            formulario.txtDireccion.setText(inmueble.getDireccion_inmueble());
            if(formulario.rbDisponible.isSelected())
            inmueble.setEstado_inmueble("Disponible");
            else 
              inmueble.setEstado_inmueble("No disponible");
            formulario.txtPrecio.setText(Double.toString(inmueble.getPrecio_base()));
            formulario.txtSuperficie.setText(Double.toString(inmueble.getSuperficie()));
            formulario.cboTipo_inm.setSelectedItem(inmueble.getTipo_inmueble());
            formulario.txtDniPropietario.setText(Integer.toString(inmueble.getPropietario().getDni_propietario()));
            
        }
    }//GEN-LAST:event_btnAbrirInmuebleActionPerformed

    private void rbDisponiblegrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDisponiblegrillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbDisponiblegrillaActionPerformed

    private void rbDisponiblegrillaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbDisponiblegrillaStateChanged
        if(rbDisponiblegrilla.isSelected())
            cargarDisponibles();
        else {
            if(rbNodisponiblegrilla.isSelected())
                cargarNoDisponibles();
        }
    }//GEN-LAST:event_rbDisponiblegrillaStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirInmueble;
    public javax.swing.JButton btnEliminarInmueble;
    private javax.swing.JButton btnInmuebleNuevo;
    private javax.swing.ButtonGroup grpbotonesgrilla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDisponiblegrilla;
    private javax.swing.JRadioButton rbNodisponiblegrilla;
    public javax.swing.JTable tabInmuebles;
    public javax.swing.JTextField txtDnipropietario1;
    // End of variables declaration//GEN-END:variables
}
