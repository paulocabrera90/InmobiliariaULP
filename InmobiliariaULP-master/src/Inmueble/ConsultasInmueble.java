/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmueble;

import Propietario.Modelo.Conexion;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author garba
 */
public class ConsultasInmueble extends Conexion{
         
        public boolean GuardarInmueble(Inmueble inmueble){
            PreparedStatement ps=null;
            Connection con = conexion();
        
             String sql = "INSERT INTO inmueble (id_tipo_inmueble,dni_propietario,direccion_inmueble,superficie,precio_base,estado_inmueble) VALUES (?,?,?,?,?,?);";
            try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,inmueble.getTipo_inmueble().getId_tipo_inmueble());
            ps.setInt(2,inmueble.getPropietario().getDni_propietario());
            ps.setString(3,inmueble.getDireccion_inmueble());
            ps.setDouble(4,inmueble.getSuperficie());
            ps.setDouble(5,inmueble.getPrecio_base());
            ps.setString(6,inmueble.getEstado_inmueble());

           
            ps.execute();
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
 
public boolean Modificar(Inmueble inmueble){
        
        PreparedStatement ps=null;
        Connection con = conexion();
        
        String sql = "UPDATE inmueble SET tipo_inmueble=?,dni_propietario=?,direccion_inmueble=?,superficie=?,precio_base=?  WHERE id_inmueble? "; 
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,inmueble.getTipo_inmueble().getId_tipo_inmueble());
            ps.setInt(2,inmueble.getPropietario().getDni_propietario());
            ps.setString(3,inmueble.getDireccion_inmueble());
            ps.setDouble(4,inmueble.getSuperficie());
            ps.setDouble(6,inmueble.getPrecio_base());
            ps.setString(7,inmueble.getEstado_inmueble());

           
            ps.execute();
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
      
public boolean Borrar(Inmueble inmueble){
        
        PreparedStatement ps=null;
        Connection con = conexion();
        
        String sql = "DELETE FROM  inmueble WHERE id_inmueble=?"; 
        
        try {
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,inmueble.getId_inmueble());
            
           
            ps.execute();
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
      
public boolean Buscar(Inmueble inmueble){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM inmueble WHERE id_inmueble=?"; 
        
        try {
            Propietario propietario=new Propietario();
            TipoInmueble tipoinmueble=new TipoInmueble();
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            ps.setInt(1,inmueble.getId_inmueble());
            rs = ps.executeQuery();
            

            
            if(rs.next()){
                propietario.setDni_propietario(rs.getInt("dni_propietario"));
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setDireccion_inmueble(rs.getString("direccion_inmueble"));
                inmueble.setSuperficie(Double.parseDouble(rs.getString("superficie")));
                inmueble.setPrecio_base(Double.parseDouble(rs.getString("precio_base")));
                inmueble.setEstado_inmueble(rs.getString("estado_inmueble"));
                
                return true;
                
            }
            return false; 
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
 public boolean obtenerInmuebles(ArrayList<Inmueble> inmuebles){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM inmueble"; 
        
        try {
            Propietario propietario=new Propietario();
            TipoInmueble tipoinmueble=new TipoInmueble();
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Inmueble inmueble=new Inmueble();
                propietario.setDni_propietario(rs.getInt("dni_propietario"));
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setDireccion_inmueble(rs.getString("direccion_inmueble"));
                inmueble.setSuperficie(Double.parseDouble(rs.getString("superficie")));
                inmueble.setPrecio_base(Double.parseDouble(rs.getString("precio_base")));
                inmueble.setEstado_inmueble(rs.getString("estado_inmueble")); 
                inmuebles.add(inmueble);
    
            }
            return true; 
        }
        catch(SQLException e){
        System.err.println(e);
        return false;
        }/*finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }*/
        
    }
    
    
}
