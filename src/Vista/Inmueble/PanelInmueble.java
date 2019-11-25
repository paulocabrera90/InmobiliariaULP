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
        modeloinmuebles=new DefaultTableModel(){
             @Override
	 public boolean isCellEditable(int row, int column) {
         return false;
	}
        };
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
        columnasi.add("ID");
        columnasi.add("Características");
        columnasi.add("Propietario");
        columnasi.add("Superficie");
        columnasi.add("Precio");
        for(Object col:columnasi)
            modeloinmuebles.addColumn(col);
        tabInmuebles.setModel(modeloinmuebles);
        tabInmuebles.getColumn("ID").setMaxWidth(30);
        tabInmuebles.getColumn("Características").setMinWidth(160);
        tabInmuebles.getColumn("Propietario").setMinWidth(100);
        tabInmuebles.getColumn("Superficie").setMaxWidth(75);
        tabInmuebles.getColumn("Precio").setMaxWidth(60);
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
    public static void cargarPropietarios(){
        propietarios.clear();
      consultasp.obtenerPropietarios(propietarios);
      cbPropietarios.removeAllItems();
      for(Propietario prop:propietarios)
          cbPropietarios.addItem(prop);
       cbPropietarios.setSelectedIndex(-1);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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
        tabInmuebles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabInmueblesMouseClicked(evt);
            }
        });
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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

        jLabel5.setText("Seleccione Disponible, No disponible o Todos según la búsqueda que desee realizar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("FILTROS DE BÚSQUEDA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbDisponiblegrilla)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbNodisponiblegrilla)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbTodos))
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(cbPropietarios, 0, 126, Short.MAX_VALUE)
                                    .addComponent(cbTipoInmueble, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimpiarProp)
                                    .addComponent(btnLimpiarTipo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarPrecio))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInmuebleNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarInmueble)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAbrirInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInmuebleNuevo)
                            .addComponent(btnEliminarInmueble)
                            .addComponent(btnAbrirInmueble))
                        .addContainerGap(88, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbNodisponiblegrilla)
                            .addComponent(rbDisponiblegrilla)
                            .addComponent(rbTodos))
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInmuebleNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInmuebleNuevoActionPerformed
        
        Inmueble inmueblenuevo= new Inmueble();
        FormInmueble formularioinmueble= new FormInmueble();
        ConsultasInmueble consultasinmueble=new ConsultasInmueble();
        CrlInmueble crlinmueble=new CrlInmueble(inmueblenuevo,consultasinmueble,formularioinmueble);
        crlinmueble.iniciar();
        formularioinmueble.setVisible(true);
        formularioinmueble.btnBorrar.setEnabled(false);
        formularioinmueble.btnModificar.setEnabled(false);
        
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
       Inmueble inmuebleabrir= new Inmueble();
       FormInmueble formulario= new FormInmueble();
       CrlInmueble crlinmueble=new CrlInmueble(inmuebleabrir,consultainmueble,formulario);
       crlinmueble.iniciar();
       formulario.setVisible(true);
       inmuebleabrir.setId_inmueble(((Integer)tabInmuebles.getValueAt(tabInmuebles.getSelectedRow(),0)));
       consultainmueble.Buscar(inmuebleabrir);
       formulario.txtID_inmueble.setText(Integer.toString(inmuebleabrir.getId_inmueble()));
       formulario.txtDireccion.setText(inmuebleabrir.getDireccion_inmueble());
       if(inmuebleabrir.getEstado_inmueble().equals("Disponible"))
       formulario.rbDisponible.setSelected(true);
       else 
       formulario.rbNodisponible.setSelected(true);
       formulario.txtPrecio.setText(Double.toString(inmuebleabrir.getPrecio_base()));
       formulario.txtSuperficie.setText(Double.toString(inmuebleabrir.getSuperficie()));
       formulario.cboPropietarios.getModel().setSelectedItem((Propietario)inmuebleabrir.getPropietario());
       formulario.cboTipo_inm.getModel().setSelectedItem((TipoInmueble)inmuebleabrir.getTipo_inmueble());
       formulario.btnGuardar.setEnabled(false);
       formulario.btnLimpiar.setEnabled(false);
       
        
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

    private void tabInmueblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabInmueblesMouseClicked
        if(evt.getClickCount()>1){
       ConsultasInmueble consultainmueble= new ConsultasInmueble();
       Inmueble inmuebleabrir= new Inmueble();
       FormInmueble formulario= new FormInmueble();
       CrlInmueble crlinmueble=new CrlInmueble(inmuebleabrir,consultainmueble,formulario);
       crlinmueble.iniciar();
       formulario.setVisible(true);
       inmuebleabrir.setId_inmueble(((Integer)tabInmuebles.getValueAt(tabInmuebles.getSelectedRow(),0)));
       consultainmueble.Buscar(inmuebleabrir);
       formulario.txtID_inmueble.setText(Integer.toString(inmuebleabrir.getId_inmueble()));
       formulario.txtDireccion.setText(inmuebleabrir.getDireccion_inmueble());
       if(inmuebleabrir.getEstado_inmueble().equals("Disponible"))
       formulario.rbDisponible.setSelected(true);
       else 
       formulario.rbNodisponible.setSelected(true);
       formulario.txtPrecio.setText(Double.toString(inmuebleabrir.getPrecio_base()));
       formulario.txtSuperficie.setText(Double.toString(inmuebleabrir.getSuperficie()));
       formulario.cboPropietarios.getModel().setSelectedItem((Propietario)inmuebleabrir.getPropietario());
       formulario.cboTipo_inm.getModel().setSelectedItem((TipoInmueble)inmuebleabrir.getTipo_inmueble());
       formulario.btnGuardar.setEnabled(false);
       formulario.btnLimpiar.setEnabled(false);
        } 
    }//GEN-LAST:event_tabInmueblesMouseClicked


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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbDisponiblegrilla;
    private javax.swing.JRadioButton rbNodisponiblegrilla;
    private javax.swing.JRadioButton rbTodos;
    public javax.swing.JTable tabInmuebles;
    public javax.swing.JTextField txtDnipropietario1;
    // End of variables declaration//GEN-END:variables
}
