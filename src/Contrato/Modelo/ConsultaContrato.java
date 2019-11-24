/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato.Modelo;

import Inmueble.Modelo.ConsultasInmueble;
import Inmueble.Modelo.ConsultasTipoInmueble;
import Inmueble.Modelo.Inmueble;
import Inmueble.Modelo.TipoInmueble;
import Inquilino.Modelo.ConsultasInquilno;
import Inquilino.Modelo.Inquilino;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ConsultaContrato {
    private Connection con = null;
    private PreparedStatement ps = null;

   public boolean Guardar(Contrato cont){
        
        
        String sql = "INSERT INTO contrato (id_contrato, id_inmueble, dni_inquilno, estado_contrto, monto, fecha_ini, fecha_ini) VALUES (?,?,?,?,?,?,?);"; 
        
         try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,cont.getId_contrato());
            ps.setInt(2, cont.getId_inmueble());
            ps.setInt(3, cont.getDni_inquilino());
            ps.setInt(4, cont.getId_estado_contrato());
            ps.setDouble(5,cont.getMonto());
             ps.setDate(6,cont.getFecha_ini());
            ps.setDate(7,cont.getFecha_fin());
            
            ps.execute();
             ps.close();
            return true;
            
            
        }
        catch(SQLException e){
        System.err.println(e);
        return false;
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
    }
   
   public boolean obtenerContratos(ArrayList<Contrato> contratos){
        
        ResultSet rs= null;
        String sql = "SELECT * FROM contrato"; 
        
        try {
            ConsultasInmueble consultasInmueble=new ConsultasInmueble();
            ConsultasInquilno consultasInquilino=new ConsultasInquilno();
                      
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Contrato contrato = new Contrato();
                Inmueble inmueble = new Inmueble();
                Inquilino inquilino = new Inquilino();
                
                inmueble.setId_inmueble(rs.getInt("dni_propietario"));
                inquilino.setDni_inquilino(rs.getInt("id_tipo_inmueble"));
                
                consultasInmueble.Buscar(inmueble);
                consultasInquilino.Buscar(inquilino);
                
                contrato.setId_inmueble(inmueble.getId_inmueble());
                contrato.setDni_inquilino(inquilino.getDni_inquilino());
                
                contrato.setId_contrato(rs.getInt("id_contrato"));
                contrato.setId_estado_contrato(rs.getInt("estado_contrato"));
                contrato.setMonto(rs.getDouble("monto"));
                contrato.setFecha_ini(rs.getDate("fecha_ini"));
                contrato.setFecha_fin(rs.getDate("fecha_fin")); 
                contratos.add(contrato);
    
            }
            return true; 
        }
        catch(SQLException e){
        System.err.println(e);
        return false;
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    
     

    private Connection conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
