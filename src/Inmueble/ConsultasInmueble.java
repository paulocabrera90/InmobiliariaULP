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

/**
 *
 * @author garba
 */
public class ConsultasInmueble extends Conexion{
         
        public boolean GuardarInmueble(Inmueble inmueble){
            PreparedStatement ps=null;
            Connection con = conexion();
        
             String sql = "INSERT INTO propietario (tipo_inmueble,dni_propietario,direccion_inmueble,altura_inmueblem,superficie,zona,precio_base) VALUES (?,?,?,?,?,?,?,);";
            try {
            ps=con.prepareStatement(sql);
            ps.setString(1,inmueble.getTipo_inmueble());
            ps.setInt(2,inmueble.getPropietario().getDni_propietario());
            ps.setString(3,inmueble.getDireccion_inmueble());
            ps.setInt(4,inmueble.getAltura_inmueble());
            ps.setDouble(5,inmueble.getSuperficie());
            ps.setString(6,inmueble.getZona());
            ps.setDouble(7,inmueble.getPrecio_base());

           
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
        
        String sql = "UPDATE propietario SET tipo_inmueble=?,dni_propietario=?,direccion_inmueble=?,altura_inmueble=?,superficie=?,zona=?,precio_base=?  WHERE id_inmueble? "; 
        
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,inmueble.getTipo_inmueble());
            ps.setInt(2,inmueble.getPropietario().getDni_propietario());
            ps.setString(3,inmueble.getDireccion_inmueble());
            ps.setInt(4,inmueble.getAltura_inmueble());
            ps.setDouble(5,inmueble.getSuperficie());
            ps.setString(6,inmueble.getZona());
            ps.setDouble(7,inmueble.getPrecio_base());

           
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
        
        String sql = "DELETE FROM  propietario WHERE id_inmueble=?"; 
        
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
        
        String sql = "SELECT * FROM propietario id_inmueble=?"; 
        
        try {
            Propietario propietario=new Propietario();
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ps = con.prepareStatement(sql);
            ps.setInt(1,inmueble.getId_inmueble());
            rs = ps.executeQuery();
            propietario.setDni_propietario(rs.getInt("dni_propietario"));
            consultapropietario.Buscar(propietario);
     
            if(rs.next()){
                inmueble.setTipo_inmueble(rs.getString("tipo_inmueble"));
                inmueble.setPropietario(propietario);
                inmueble.setDireccion_inmueble(rs.getString("direccion_inmueble"));
                inmueble.setAltura_inmueble(Integer.parseInt(rs.getString("altura_inmueble")));
                inmueble.setSuperficie(Double.parseDouble(rs.getString("superficie")));
                inmueble.setZona(rs.getString("zona"));
                inmueble.setPrecio_base(Double.parseDouble(rs.getString("precio_base")));
                
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
    
    
}
