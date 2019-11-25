/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Inmueble;

import Inmueble.Controlador.CrlInmueble;
import Inmueble.Modelo.ConsultasInmueble;
import Inmueble.Modelo.ConsultasTipoInmueble;
import Inmueble.Modelo.Inmueble;
import Inmueble.Modelo.TipoInmueble;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author garba
 */
public class PanelInmueble extends javax.swing.JPanel {

  private Propietario propietario=new Propietario();
    private Inmueble inmueble=new Inmueble();
    private TipoInmueble tipoinmueble=new TipoInmueble();
    private ConsultasTipoInmueble consultatipo= new ConsultasTipoInmueble();
    private ArrayList<TipoInmueble> tiposinmueble= new ArrayList<TipoInmueble>();
    private static ConsultasPropietario consultasp= new ConsultasPropietario();
    private static ConsultasInmueble consultasi=new ConsultasInmueble();
    private static ArrayList<Inmueble> inmuebles=new ArrayList<Inmueble>();
    private static ArrayList<Propietario> propietarios=new ArrayList<Propietario>();
    private static DefaultTableModel modeloinmuebles;
    
    public PanelInmueble() {
        initComponents();
        modeloinmuebles=new DefaultTableModel();
        armarCabeceraInmuebles();
        grpbotonesgrilla.add(rbDisponiblegrilla);
        grpbotonesgrilla.add(rbNodisponiblegrilla);
        grpbotonesgrilla.add(rbTodos);
        rbTodos.setSelected(true);
        cargarPropietarios();
        cargarTipos();
        cargarPrecios();
        this.cbPropietarios.setSelectedIndex(-1);
        this.cbPrecio.setSelectedIndex(-1);
        this.cbTipoInmueble.setSelectedIndex(-1);
        cargarInmueblesFiltrados();
  
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
    public static void cargarInmuebles(ArrayList<Inmueble> inmuebles){
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
        cargarInmueblesFiltrados();
        int c=modeloinmuebles.getRowCount()-1;
        for(int i=c;i>=0;i--)
        {
          if(inmuebles.get(i).getEstado_inmueble().equals("No disponible"))
          modeloinmuebles.removeRow(i);
        }
    }
    public static void cargarNoDisponibles(){
        cargarInmueblesFiltrados();
        int c=modeloinmuebles.getRowCount()-1;
        for(int i=c;i>=0;i--)
        {
          if(inmuebles.get(i).getEstado_inmueble().equals("Disponible"))
          modeloinmuebles.removeRow(i);
        }
    } 
    public void cargarPropietarios(){
      consultasp.obtenerPropietarios(propietarios);
      
      for(Propietario prop:propietarios)
          cbPropietarios.addItem(prop);
  }
    
    public static void cargarInmueblesFiltrados(){
        if(cbPropietarios.getSelectedIndex()==-1 &&cbPrecio.getSelectedIndex()==-1 &&cbTipoInmueble.getSelectedIndex()==-1) //Todos vacíos
        {
            inmuebles.clear();
            consultasi.obtenerInmuebles(inmuebles);
            cargarInmuebles(inmuebles);
        } else
        {
            if(cbPropietarios.getSelectedIndex()!=-1 &&cbPrecio.getSelectedIndex()==-1 &&cbTipoInmueble.getSelectedIndex()==-1)// Solo Propietario
            {
                inmuebles.clear();
                consultasi.filtrarInmueblesDni(inmuebles,((Propietario)cbPropietarios.getSelectedItem()).getDni_propietario());
                cargarInmuebles(inmuebles);
            } else
                {
                     if(cbPropietarios.getSelectedIndex()!=-1 &&cbPrecio.getSelectedIndex()!=-1 &&cbTipoInmueble.getSelectedIndex()==-1)//Propietario y Precio
                  {
                     inmuebles.clear();
                     consultasi.filtrarInmueblesPrecioDni(inmuebles,(Integer)cbPrecio.getSelectedItem(),((Propietario)cbPropietarios.getSelectedItem()).getDni_propietario());
                     cargarInmuebles(inmuebles);
                  } else {
                            if(cbPropietarios.getSelectedIndex()!=-1 &&cbPrecio.getSelectedIndex()!=-1 &&cbTipoInmueble.getSelectedIndex()!=-1)//Propietarioo precio y tipo
                            {
                                inmuebles.clear();
                                consultasi.filtrarInmueblesPrecioDniTipo(inmuebles,(Integer)cbPrecio.getSelectedItem(),((Propietario)cbPropietarios.getSelectedItem()).getDni_propietario(),((TipoInmueble)cbTipoInmueble.getSelectedItem()).getId_tipo_inmueble());
                                cargarInmuebles(inmuebles);
                            } else {
                                       if(cbPropietarios.getSelectedIndex()!=-1 &&cbPrecio.getSelectedIndex()==-1 &&cbTipoInmueble.getSelectedIndex()!=-1)//Propietario y tipo
                                       {
                                           inmuebles.clear();
                                           consultasi.filtrarInmueblesDniTipo(inmuebles, ((Propietario)cbPropietarios.getSelectedItem()).getDni_propietario(), ((TipoInmueble)cbTipoInmueble.getSelectedItem()).getId_tipo_inmueble());
                                           cargarInmuebles(inmuebles);
                                       } else 
                                       {
                                           if(cbPropietarios.getSelectedIndex()==-1 &&cbPrecio.getSelectedIndex()==-1 &&cbTipoInmueble.getSelectedIndex()!=-1)//Solo tipo
                                           {
                                               inmuebles.clear();
                                               consultasi.filtrarInmueblesTipo(inmuebles,((TipoInmueble)cbTipoInmueble.getSelectedItem()).getId_tipo_inmueble());
                                               cargarInmuebles(inmuebles);
                                           } else 
                                           {
                                               if(cbPropietarios.getSelectedIndex()==-1 &&cbPrecio.getSelectedIndex()!=-1 &&cbTipoInmueble.getSelectedIndex()!=-1)//Precio y tipo
                                               {
                                                   inmuebles.clear();
                                                   consultasi.filtrarInmueblesPrecioTipo(inmuebles, (Integer)cbPrecio.getSelectedItem(),((TipoInmueble)cbTipoInmueble.getSelectedItem()).getId_tipo_inmueble());
                                                   cargarInmuebles(inmuebles);
                                               } else
                                               {
                                                   if(cbPropietarios.getSelectedIndex()==-1 &&cbPrecio.getSelectedIndex()!=-1 &&cbTipoInmueble.getSelectedIndex()==-1)//Solo precio
                                                   {
                                                       inmuebles.clear();
                                                       consultasi.filtrarInmueblesPrecio(inmuebles,(Integer)cbPrecio.getSelectedItem());
                                                       cargarInmuebles(inmuebles);
                                                   }
                                               }
                                           }
                                       }
                                   } 
                         }
        
                } 
        }
    }
    
        
    public void cargarTipos(){
      consultatipo.ObtenerTiposInmueble(tiposinmueble);
      for(TipoInmueble tipo:tiposinmueble)
          cbTipoInmueble.addItem(tipo);
  }
    public void cargarPrecios(){
        cbPrecio.addItem(5000);
        cbPrecio.addItem(7500);
        cbPrecio.addItem(10000);
        cbPrecio.addItem(15000);
        
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
        cbPropietarios = new javax.swing.JComboBox<>();
        cbTipoInmueble = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbPrecio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        rbTodos = new javax.swing.JRadioButton();
        btnLimpiarProp = new javax.swing.JButton();
        btnLimpiarTipo = new javax.swing.JButton();
        btnLimpiarPrecio = new javax.swing.JButton();

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
        rbNodisponiblegrilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNodisponiblegrillaActionPerformed(evt);
            }
        });

        cbPropietarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPropietariosActionPerformed(evt);
            }
        });

        cbTipoInmueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoInmuebleActionPerformed(evt);
            }
        });

        jLabel2.setText("Propietario");

        jLabel4.setText("Tipo de inmueble");

        cbPrecio.setToolTipText("");
        cbPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrecioActionPerformed(evt);
            }
        });

        jLabel3.setText("Precio hasta");

        rbTodos.setText("Todos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });

        btnLimpiarProp.setText("Limpiar");
        btnLimpiarProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPropActionPerformed(evt);
            }
        });

        btnLimpiarTipo.setText("Limpiar");
        btnLimpiarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTipoActionPerformed(evt);
            }
        });

        btnLimpiarPrecio.setText("Limpiar");
        btnLimpiarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPrecioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnInmuebleNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnEliminarInmueble)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbrirInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbDisponiblegrilla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbNodisponiblegrilla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbTodos)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(cbPropietarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbTipoInmueble, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpiarProp)
                                    .addComponent(btnLimpiarTipo)
                                    .addComponent(btnLimpiarPrecio)))
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbNodisponiblegrilla)
                            .addComponent(rbDisponiblegrilla)
                            .addComponent(rbTodos)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInmuebleNuevo)
                            .addComponent(btnEliminarInmueble)
                            .addComponent(btnAbrirInmueble))
                        .addGap(99, 99, 99))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPropietarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarProp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
            
               if(consultainmueble.Borrar((Integer)tabInmuebles.getValueAt(tabInmuebles.getSelectedRow(),0)))
             {
            int rowselected=tabInmuebles.getSelectedRow();
            modeloinmuebles.removeRow(rowselected);
            cargarInmueblesFiltrados(); 
            JOptionPane.showMessageDialog(null, "Inmueble eliminado");
            
            } else JOptionPane.showMessageDialog(null,"No se puede eliminar inmueble");
            
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
            formulario.cbDnipropietarios.setSelectedItem(inmueble.getPropietario().getDni_propietario());
            
        }
    }//GEN-LAST:event_btnAbrirInmuebleActionPerformed

    private void rbDisponiblegrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDisponiblegrillaActionPerformed
        // TODO add your handling code here:
        cargarInmueblesFiltrados();
        int c=modeloinmuebles.getRowCount()-1;
        for(int i=c;i>=0;i--)
        {
          if(inmuebles.get(i).getEstado_inmueble().equals("No disponible"))
          modeloinmuebles.removeRow(i);
        }
            
    }//GEN-LAST:event_rbDisponiblegrillaActionPerformed

    private void rbDisponiblegrillaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbDisponiblegrillaStateChanged
    
        
    }//GEN-LAST:event_rbDisponiblegrillaStateChanged

    private void cbPropietariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPropietariosActionPerformed
        cargarInmueblesFiltrados();
        if(rbDisponiblegrilla.isSelected())
            cargarDisponibles();
        else 
            if(rbNodisponiblegrilla.isSelected())
                cargarNoDisponibles();

    }//GEN-LAST:event_cbPropietariosActionPerformed

    private void cbTipoInmuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoInmuebleActionPerformed
        cargarInmueblesFiltrados();
        if(rbDisponiblegrilla.isSelected())
            cargarDisponibles();
        else 
        {   if(rbNodisponiblegrilla.isSelected())
                cargarNoDisponibles();
        }
    }//GEN-LAST:event_cbTipoInmuebleActionPerformed

    private void cbPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrecioActionPerformed
        cargarInmueblesFiltrados();
        if(rbDisponiblegrilla.isSelected())
            cargarDisponibles();
        else 
        {
            if(rbNodisponiblegrilla.isSelected())
                cargarNoDisponibles();
        }
    }//GEN-LAST:event_cbPrecioActionPerformed

    private void rbNodisponiblegrillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNodisponiblegrillaActionPerformed
        cargarInmueblesFiltrados();
        int c=modeloinmuebles.getRowCount()-1;
        for(int i=c;i>=0;i--)
        {
          if(inmuebles.get(i).getEstado_inmueble().equals("Disponible"))
          modeloinmuebles.removeRow(i);
        }
    }//GEN-LAST:event_rbNodisponiblegrillaActionPerformed

    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        
     cargarInmueblesFiltrados();
    }//GEN-LAST:event_rbTodosActionPerformed

    private void btnLimpiarPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPropActionPerformed
        
        cbPropietarios.setSelectedIndex(-1);
    }//GEN-LAST:event_btnLimpiarPropActionPerformed

    private void btnLimpiarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTipoActionPerformed
        
        cbTipoInmueble.setSelectedIndex(-1);
    }//GEN-LAST:event_btnLimpiarTipoActionPerformed

    private void btnLimpiarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPrecioActionPerformed
        
        cbPrecio.setSelectedIndex(-1);
    }//GEN-LAST:event_btnLimpiarPrecioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirInmueble;
    public javax.swing.JButton btnEliminarInmueble;
    private javax.swing.JButton btnInmuebleNuevo;
    public javax.swing.JButton btnLimpiarPrecio;
    public javax.swing.JButton btnLimpiarProp;
    public javax.swing.JButton btnLimpiarTipo;
    public static javax.swing.JComboBox<Object> cbPrecio;
    public static javax.swing.JComboBox<Propietario> cbPropietarios;
    public static javax.swing.JComboBox<TipoInmueble> cbTipoInmueble;
    private javax.swing.ButtonGroup grpbotonesgrilla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDisponiblegrilla;
    private javax.swing.JRadioButton rbNodisponiblegrilla;
    private javax.swing.JRadioButton rbTodos;
    public javax.swing.JTable tabInmuebles;
    public javax.swing.JTextField txtDnipropietario1;
    // End of variables declaration//GEN-END:variables
}
