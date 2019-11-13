/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquilino.Modelo;

import Propietario.Modelo.Propietario;
import Inquilino.Modelo.Inquilino;
import Inquilino.Modelo.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martin
 */
public class ConsultasInquilno extends  Conexion {
 
    Connection con = null;
    
  //  public ConsultasInquilno(Conexion conexion){
  //      con= conexion.conexion();
  //  }
       public boolean Guardar(Inquilino inquilino){
        
        PreparedStatement ps=null;
        
        
        String sql = "INSERT INTO inquilino (dni_inquilino,nombre_inquilino,apellido_inquilino,cuit_inquilino,lugar_trabajo_inquilino,nom_garante_inquilino,dni_garante_inquilino) VALUES (?,?,?,?,?,?,?);"; 
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,inquilino.getDni_inquilino());
            ps.setString(2, inquilino.getNombre_inquilino());
            ps.setString(3, inquilino.getApellido_inquilino());
            ps.setInt(4, inquilino.getCuit_inquilino());
            ps.setString(5,inquilino.getLugar_trabajo_inquilino());
            ps.setString(6,inquilino.getNom_garante_inquilino());
            ps.setInt(7, inquilino.getDni_garante_inquilino());
           
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
 
public boolean Modificar(Inquilino inquilino){
        
        PreparedStatement ps=null;
       
        
        String sql = "UPDATE inquilino SET nombre_inquilino=?,apellido_inquilino=?,cuit_inquilino=?,lugar_trabajo_inquilino=?,nom_garante_inquilino=?,dni_garante_inquilino=?)  WHERE dni_inquilino=? "; 
        
        try {
            ps=con.prepareStatement(sql);
           
            
            ps.setString(1, inquilino.getNombre_inquilino());
            ps.setString(2, inquilino.getApellido_inquilino());
            ps.setInt(3, inquilino.getCuit_inquilino());
            ps.setString(4,inquilino.getLugar_trabajo_inquilino());
            ps.setString(5,inquilino.getNom_garante_inquilino());
            ps.setInt(6, inquilino.getDni_garante_inquilino());
            ps.setInt(7,inquilino.getDni_inquilino());
          
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
      
public boolean Borrar(Inquilino inquilino){
        
        PreparedStatement ps=null;
       
        
        String sql = "DELETE FROM  inquilino WHERE dni_inquilino=?"; 
        
        try {
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,inquilino.getDni_inquilino());
            
           
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
      
public boolean Buscar(Inquilino inquilino){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
     
        
        String sql = "SELECT * FROM inquilino WHERE dni_inquilino=?"; 
        
        try {
            ps = con.prepareStatement(sql);
             ps.setInt(1,inquilino.getDni_inquilino());
            rs = ps.executeQuery();
     
            if(rs.next()){
                inquilino.setDni_inquilino(rs.getInt("dni_inquilino"));
                inquilino.setNombre_inquilino(rs.getString("nombre_inquilino"));
                inquilino.setApellido_inquilino(rs.getString("apellido_inquilino"));
                inquilino.setCuit_inquilino(rs.getInt("cuit_inquilino"));
                inquilino.setLugar_trabajo_inquilino(rs.getString("lugar_trabajo_inquilino"));
                inquilino.setNom_garante_inquilino(rs.getString("nombre_garante_inquilino"));
                inquilino.setDni_garante_inquilino(rs.getInt("dni_garante_inquilino"));
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

 public boolean obtenerInquilinos(List <Inquilino> inquilinos){
        new ArrayList<Inquilino>();
          try {
            
            
            String sql= "SELECT * FROM inquilino ;";
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            Inquilino inquilino;
            
            while(rs.next()){
            inquilino= new Inquilino();
            inquilino.setDni_inquilino(rs.getInt("dni_inquilino"));
            inquilino.setNombre_inquilino(rs.getString("nombre_inquilino"));
            inquilino.setApellido_inquilino(rs.getString("apellido_inquilino"));
            inquilino.setCuit_inquilino(rs.getInt("cuit_inquilino"));
            inquilino.setLugar_trabajo_inquilino(rs.getString("lugar_trabajo_inquilino"));
            inquilino.setNom_garante_inquilino(rs.getString("nombre_garante_inquilino"));
            inquilino.setDni_garante_inquilino(rs.getInt("dni_garante_inquilino"));
            inquilinos.add(inquilino);
            }
           ps.close();
           return true;
          
          }   catch (SQLException ex) {
           // Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);obtener
            System.out.println("No se puede obtener lista de inquilinos. ");
           return false;
        }
          

}
}
