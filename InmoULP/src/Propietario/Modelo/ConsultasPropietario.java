/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propietario.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class ConsultasPropietario extends Conexion{
    
public boolean Guardar(Propietario propi){
        
        PreparedStatement ps=null;
        Connection con = conexion();
        
        String sql = "INSERT INTO propietario (dni_propietario,nombre_propietario,apellido_propietario,domicilio_propietario,telefono_propietario) VALUES (?,?,?,?,?);"; 
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,propi.getDni_propietario());
            ps.setString(2, propi.getNombre_propietario());
            ps.setString(3, propi.getApellido_propietario());
            ps.setString(4, propi.getDomicilio_propietario());
            ps.setInt(5,propi.getTelefono_propietario());
           
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
 
public boolean Modificar(Propietario propi){
        
        PreparedStatement ps=null;
        Connection con = conexion();
        
        String sql = "UPDATE propietario SET nombre_propietario=?,apellido_propietario=?,domicilio_propietario=?,telefono_propietario=?  WHERE dni_propietario=? "; 
        
        try {
            ps=con.prepareStatement(sql);
           
            ps.setString(1, propi.getNombre_propietario());
            ps.setString(2, propi.getApellido_propietario());
            ps.setString(3, propi.getDomicilio_propietario());
            ps.setInt(4,propi.getTelefono_propietario());
            ps.setInt(5,propi.getDni_propietario());
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
      
public boolean Borrar(Propietario propi){
        
        PreparedStatement ps=null;
        Connection con = conexion();
        
        String sql = "DELETE FROM  propietario WHERE dni_propietario=?"; 
        
        try {
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,propi.getDni_propietario());
            
           
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
      
public boolean Buscar(Propietario propi){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM propietario WHERE dni_propietario=?"; 
        
        try {
            ps = con.prepareStatement(sql);
             ps.setInt(1,propi.getDni_propietario());
            rs = ps.executeQuery();
     
            if(rs.next()){
                propi.setDni_propietario(rs.getInt("dni_propietario"));
                propi.setNombre_propietario(rs.getString("nombre_propietario"));
                propi.setApellido_propietario(rs.getString("apellido_propietario"));
                propi.setDomicilio_propietario(rs.getString("domicilio_propietario"));
                propi.setTelefono_propietario(rs.getInt("telefono_propietario"));
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
