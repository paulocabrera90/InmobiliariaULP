/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Inmueble.Modelo.ConsultasInmueble;
import Inmueble.Controlador.CrlInmueble;
import Vista.Inmueble.FormInmueble;
import Inmueble.Modelo.Inmueble;
import Inquilino.Modelo.Inquilino;
import Propietario.Controlador.CtrPropietario;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import Vista.Propietario.panelPropietarioList;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Inquilino.Modelo.ConsultasInquilno;
import Inquilino.Controlador.CtrInquilino;
import Vista.Inquilino.PanelInquilino;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class fromMenu extends javax.swing.JFrame {

   private Propietario propietario=new Propietario();
    private Inmueble inmueble=new Inmueble();
    private static ConsultasPropietario consultasp= new ConsultasPropietario();
    private static ConsultasInmueble consultasi=new ConsultasInmueble();
    private static ArrayList<Inmueble> inmuebles=new ArrayList<Inmueble>();
    private static DefaultTableModel modeloinmuebles;
   // private static ConsultasInquilino cdInquilino= new ConsultasInquilino();
    
    public fromMenu() {
        initComponents();
        this.setTitle("Inmobliaria");
        //this.setExtendedState(this.MAXIMIZED_BOTH);
      //  this.setResizable(false);
        this.setSize(new Dimension(1240, 600));
        this.setMinimumSize(new Dimension(1000, 600));
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/Inmo2.png")).getImage()) ;// poner imagen a jframe
        modeloinmuebles=new DefaultTableModel();
        
        
        
        
    }
 /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneMenu = new javax.swing.JTabbedPane();
        jPanelContrato = new javax.swing.JPanel();
        jPanelPropietario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelPropietarioList2 = new Vista.Propietario.panelPropietarioList();
        jPanelInmueble = new javax.swing.JPanel();
        panelInmueble1 = new Vista.Inmueble.PanelInmueble();
        jPanelInquilino = new javax.swing.JPanel();
        jbtnNuevoInquilino = new javax.swing.JButton();
        jbtnAbrirInquilino = new javax.swing.JButton();
        jbtnBorrarInquilino = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelInquilino1 = new Vista.Inquilino.PanelInquilino();
        jSalirInq = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPaneMenu.setName("aasds"); // NOI18N
        jTabbedPaneMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelContratoLayout = new javax.swing.GroupLayout(jPanelContrato);
        jPanelContrato.setLayout(jPanelContratoLayout);
        jPanelContratoLayout.setHorizontalGroup(
            jPanelContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1213, Short.MAX_VALUE)
        );
        jPanelContratoLayout.setVerticalGroup(
            jPanelContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        jTabbedPaneMenu.addTab("Contrato", jPanelContrato);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Salir");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Lista propietarios");

        javax.swing.GroupLayout jPanelPropietarioLayout = new javax.swing.GroupLayout(jPanelPropietario);
        jPanelPropietario.setLayout(jPanelPropietarioLayout);
        jPanelPropietarioLayout.setHorizontalGroup(
            jPanelPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPropietarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(jPanelPropietarioLayout.createSequentialGroup()
                .addComponent(panelPropietarioList2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 251, Short.MAX_VALUE))
        );
        jPanelPropietarioLayout.setVerticalGroup(
            jPanelPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPropietarioLayout.createSequentialGroup()
                .addGroup(jPanelPropietarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPropietarioLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPropietarioList2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 290, Short.MAX_VALUE))
        );

        jTabbedPaneMenu.addTab("Propietario", jPanelPropietario);

        javax.swing.GroupLayout jPanelInmuebleLayout = new javax.swing.GroupLayout(jPanelInmueble);
        jPanelInmueble.setLayout(jPanelInmuebleLayout);
        jPanelInmuebleLayout.setHorizontalGroup(
            jPanelInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInmuebleLayout.createSequentialGroup()
                .addComponent(panelInmueble1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 546, Short.MAX_VALUE))
        );
        jPanelInmuebleLayout.setVerticalGroup(
            jPanelInmuebleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInmuebleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInmueble1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        jTabbedPaneMenu.addTab("Inmueble", jPanelInmueble);

        jbtnNuevoInquilino.setText("Nuevo");
        jbtnNuevoInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoInquilinoActionPerformed(evt);
            }
        });

        jbtnAbrirInquilino.setText("Abrir");
        jbtnAbrirInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAbrirInquilinoActionPerformed(evt);
            }
        });

        jbtnBorrarInquilino.setText("Borrar");
        jbtnBorrarInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBorrarInquilinoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Lista inquilinos");

        jSalirInq.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jSalirInq.setText("Salir");
        jSalirInq.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSalirInq.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jSalirInq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSalirInqMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelInquilinoLayout = new javax.swing.GroupLayout(jPanelInquilino);
        jPanelInquilino.setLayout(jPanelInquilinoLayout);
        jPanelInquilinoLayout.setHorizontalGroup(
            jPanelInquilinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInquilinoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInquilinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInquilinoLayout.createSequentialGroup()
                        .addComponent(panelInquilino1, javax.swing.GroupLayout.PREFERRED_SIZE, 1148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(jPanelInquilinoLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSalirInq))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInquilinoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnNuevoInquilino)
                .addGap(33, 33, 33)
                .addComponent(jbtnAbrirInquilino)
                .addGap(36, 36, 36)
                .addComponent(jbtnBorrarInquilino)
                .addGap(147, 147, 147))
        );
        jPanelInquilinoLayout.setVerticalGroup(
            jPanelInquilinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInquilinoLayout.createSequentialGroup()
                .addGroup(jPanelInquilinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInquilinoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addComponent(jSalirInq, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInquilino1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanelInquilinoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnBorrarInquilino)
                    .addComponent(jbtnAbrirInquilino)
                    .addComponent(jbtnNuevoInquilino))
                .addContainerGap(232, Short.MAX_VALUE))
        );

        jTabbedPaneMenu.addTab("Inquilino", jPanelInquilino);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 1218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMenu)
        );

        jTabbedPaneMenu.getAccessibleContext().setAccessibleName("Menu");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPaneMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMenuMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTabbedPaneMenuMouseClicked

    private void jbtnNuevoInquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoInquilinoActionPerformed
        // TODO add your handling code here:
        Inquilino inquilino=new Inquilino();
      
        ConsultasInquilno cdInquilino = new ConsultasInquilno();
        Vista.Inquilino.FrmInquilino frmI = new Vista.Inquilino.FrmInquilino();
        CtrInquilino ctrInquilino = new CtrInquilino(inquilino, cdInquilino, frmI);
        
        ctrInquilino.iniciar();
        frmI.setVisible(true);
        frmI.btnModificar.setEnabled(false);
        frmI.btnBorrar.setEnabled(false);
         //PanelInquilino.cargarInquilinos();
        
        
    }//GEN-LAST:event_jbtnNuevoInquilinoActionPerformed

    private void jbtnAbrirInquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAbrirInquilinoActionPerformed
        // TODO add your handling code here:
       Inquilino inquilino=new Inquilino();
       ConsultasInquilno cdInquilino = new ConsultasInquilno();
       Vista.Inquilino.FrmInquilino frmI = new Vista.Inquilino.FrmInquilino();
     // int fila=Vista.Inquilino.PanelInquilino.modeloInquilino.
      //  inquilino.setDni_inquilino(Vista.Inquilino.PanelInquilino.modeloInquilino.getSelectedRow());
      inquilino= PanelInquilino.obtenerInquilinoDeTabla();
       if (inquilino==null)
           { JOptionPane.showMessageDialog(null, "No se selecciono ningun inquilino de la tabla");}
            else {
      cdInquilino.Buscar(inquilino);
      frmI.jtDni.setText(Integer.toString(inquilino.getDni_inquilino()));
      frmI.jtNombre.setText(inquilino.getNombre_inquilino());
      frmI.jtApellido.setText(inquilino.getApellido_inquilino());
      frmI.jtCuit.setText(inquilino.getCuit_inquilino());
      frmI.jtLugarTrab.setText(inquilino.getLugar_trabajo_inquilino());
      frmI.jtGarante.setText(inquilino.getNom_garante_inquilino());
      frmI.jtDniGarante.setText(Integer.toString(inquilino.getDni_garante_inquilino()));
      CtrInquilino ctrInquilino = new CtrInquilino(inquilino, cdInquilino, frmI);
        ctrInquilino.iniciar();
        PanelInquilino.cargarInquilinos();
        frmI.btnGuardar.setEnabled(false);
        frmI.jtDni.setEnabled(false);
        frmI.btnLimpiar.setEnabled(false);
       // this.setEnabled(false);
       }
               
    }//GEN-LAST:event_jbtnAbrirInquilinoActionPerformed

    private void jbtnBorrarInquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarInquilinoActionPerformed
        // TODO add your handling code here:
          Inquilino inquilino=new Inquilino();
           ConsultasInquilno cdInquilino = new ConsultasInquilno();
           inquilino= PanelInquilino.obtenerInquilinoDeTabla();
        
             if (inquilino==null)
           { JOptionPane.showMessageDialog(null, "No se selecciono ningun inquilino de la tabla");}
            else {
            int i =JOptionPane.showConfirmDialog(this,"¿Desea eliminar el inquilino seleccionado?","Confirmar Eliminación",JOptionPane.YES_NO_OPTION);
            if(i==0){
             i = JOptionPane.showConfirmDialog(this,"¿Realmente desea eliminar el inquilino seleccionado?","Confirmar Eliminación",JOptionPane.YES_NO_OPTION);
            if(i==0)
             {              
           if(cdInquilino.Borrar(inquilino))
           {
           JOptionPane.showMessageDialog(null, "Se elimino inquilino", "Info", JOptionPane.WARNING_MESSAGE);
           PanelInquilino.cargarInquilinos();
           } else  JOptionPane.showMessageDialog(null, "No se puede eliminar inquilino. Verifique si tiene un contrato realizado", "Info", JOptionPane.WARNING_MESSAGE);
             }
            }
           }
    }//GEN-LAST:event_jbtnBorrarInquilinoActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
         int i =JOptionPane.showConfirmDialog(this,"¿Desea Salir del sistema?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(i==0){
        System.exit(0);
        setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
            }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jSalirInqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalirInqMouseClicked
        // TODO add your handling code here:
                 int i =JOptionPane.showConfirmDialog(this,"¿Desea Salir del sistema?","Confirmar salida",JOptionPane.YES_NO_OPTION);
            if(i==0){
        System.exit(0);
        setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
            }
    }//GEN-LAST:event_jSalirInqMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fromMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new Login().setVisible(true);
             //  new fromMenu().setVisible(true);
               // fromMenu tablero=new fromMenu();
               // tablero.setLocationRelativeTo(null);
               // tablero.setVisible(true);
                
                //PROPIETARIO
              //  panelPropietarioList panelPropietarioList= new panelPropietarioList();
              //  tablero.jPanelPropietario.add(panelPropietarioList);
               // panelPropietarioList.isEnabled();
                
                //inquilino
              //  PanelInquilino panelInquilino= new PanelInquilino();
              //  tablero.jPanelInquilino.add(panelInquilino);
               // panelInquilino.isEnabled();
                
            }
        });
        
        
     
    }
    
    public void enabledPanel (boolean flag){
         this.setVisible(flag);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelContrato;
    private javax.swing.JPanel jPanelInmueble;
    private javax.swing.JPanel jPanelInquilino;
    private javax.swing.JPanel jPanelPropietario;
    private javax.swing.JLabel jSalirInq;
    public javax.swing.JTabbedPane jTabbedPaneMenu;
    private javax.swing.JButton jbtnAbrirInquilino;
    private javax.swing.JButton jbtnBorrarInquilino;
    private javax.swing.JButton jbtnNuevoInquilino;
    private Vista.Inmueble.PanelInmueble panelInmueble1;
    private Vista.Inquilino.PanelInquilino panelInquilino1;
    private Vista.Propietario.panelPropietarioList panelPropietarioList2;
    // End of variables declaration//GEN-END:variables
}