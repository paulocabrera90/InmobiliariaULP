/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmueble.Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author garba
 */
public class ConsultasTipoInmueble extends Conexion{
    
    public boolean GuardarInmueble(TipoInmueble tipoinmueble){
            PreparedStatement ps=null;
            Connection con = conexion();
        
             String sql = "INSERT INTO tipo_inmueble (tipo_inmueble,zona_inmueble) VALUES (?,?);";
            try {
            ps=con.prepareStatement(sql);
            ps.setString(1,tipoinmueble.getTipo_inmueble());
            ps.setString(2,tipoinmueble.getZona_inmueble());     
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
 
public boolean Modificar(TipoInmueble tipoinmueble){
        
        PreparedStatement ps=null;
            Connection con = conexion();
        
            String sql = "UPDATE tipo_inmueble SET tipo_inmueble=?,zona_inmueble=? VALUES (?,?);";
            try {
            ps=con.prepareStatement(sql);
            ps.setString(1,tipoinmueble.getTipo_inmueble());
            ps.setString(2,tipoinmueble.getZona_inmueble());     
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
      
public boolean Borrar(TipoInmueble tipoinmueble){
        
        PreparedStatement ps=null;
        Connection con = conexion();
        
        String sql = "DELETE FROM tipo_inmueble WHERE id_tipo_inmueble=?"; 
        
        try {
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,tipoinmueble.getId_tipo_inmueble());
            
           
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
      
public boolean Buscar(TipoInmueble tipoinmueble){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM tipo_inmueble WHERE id_tipo_inmueble=?"; 
        
        try {
            
            ps=con.prepareStatement(sql);
            ps.setInt(1,tipoinmueble.getId_tipo_inmueble());
            rs=ps.executeQuery();
            if(rs.next()){
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                tipoinmueble.setTipo_inmueble(rs.getString("tipo_inmueble"));
                tipoinmueble.setZona_inmueble(rs.getString("zona_inmueble"));
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
public boolean ObtenerTiposInmueble(ArrayList<TipoInmueble> tiposinmueble){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        String sql = "SELECT * FROM tipo_inmueble ORDER BY tipo_inmueble"; 
        try {
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                TipoInmueble tipoinmueble=new TipoInmueble();
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                tipoinmueble.setTipo_inmueble(rs.getString("tipo_inmueble"));
                tipoinmueble.setZona_inmueble(rs.getString("zona_inmueble"));
                tiposinmueble.add(tipoinmueble);
                
                
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
    
    
}
