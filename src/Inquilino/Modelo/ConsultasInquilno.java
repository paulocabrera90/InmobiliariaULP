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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin
 */
public class ConsultasInquilno extends  Conexion {
 
 //   Connection con = null;
    
  //  public ConsultasInquilno(Conexion conexion){
  //      con= conexion.conexion();
  //  }
       public boolean Guardar(Inquilino inquilino){
        
        PreparedStatement ps=null;
       
         Connection con = conexion();
        
        
        
        String sql = "INSERT INTO inquilino (dni_inquilino,nombre_inquilino,apellido_inquilino,cuit_inquilino,lugar_trabajo_inquilino,nom_garante_inquilino,dni_garante_inquilino) VALUES (?,?,?,?,?,?,?);"; 
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,inquilino.getDni_inquilino());
            ps.setString(2, inquilino.getNombre_inquilino());
            ps.setString(3, inquilino.getApellido_inquilino());
            ps.setString(4, inquilino.getCuit_inquilino());
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
        Connection con = conexion();
       
        
        String sql = "UPDATE inquilino SET nombre_inquilino=?,apellido_inquilino=?,cuit_inquilino=?,lugar_trabajo_inquilino=?,nom_garante_inquilino=?,dni_garante_inquilino=?  WHERE dni_inquilino=? "; 
        
        try {
            ps=con.prepareStatement(sql);
           
            
            ps.setString(1, inquilino.getNombre_inquilino());
            ps.setString(2, inquilino.getApellido_inquilino());
            ps.setString(3, inquilino.getCuit_inquilino());
            ps.setString(4,inquilino.getLugar_trabajo_inquilino());
            ps.setString(5,inquilino.getNom_garante_inquilino());
            ps.setInt(6, inquilino.getDni_garante_inquilino());
            ps.setInt(7,inquilino.getDni_inquilino());
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
      
public boolean Borrar(Inquilino inquilino){
        
        PreparedStatement ps=null;
        Connection con = conexion();
       
        
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
        Connection con = conexion();
     
        
        String sql = "SELECT * FROM inquilino WHERE dni_inquilino=?"; 
        
        try {
            ps = con.prepareStatement(sql);
             ps.setInt(1,inquilino.getDni_inquilino());
            rs = ps.executeQuery();
     
            if(rs.next()){
                inquilino.setDni_inquilino(rs.getInt("dni_inquilino"));
                inquilino.setNombre_inquilino(rs.getString("nombre_inquilino"));
                inquilino.setApellido_inquilino(rs.getString("apellido_inquilino"));
                inquilino.setCuit_inquilino(rs.getString("cuit_inquilino"));
                inquilino.setLugar_trabajo_inquilino(rs.getString("lugar_trabajo_inquilino"));
                inquilino.setNom_garante_inquilino(rs.getString("nom_garante_inquilino"));
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
         PreparedStatement ps = null;
       ResultSet rs= null;
        Connection con = conexion();
          try {
            
            
            String sql= "SELECT * FROM inquilino ORDER BY apellido_inquilino;";
             ps= con.prepareStatement(sql);
             rs= ps.executeQuery();
            Inquilino inquilino;// = new Inquilino();
                      
           // ConsultasPropietario consultapropietario=new ConsultasPropietario();
           
          
            
            while(rs.next()){
            inquilino= new Inquilino();
            inquilino.setDni_inquilino(rs.getInt("dni_inquilino"));
            inquilino.setNombre_inquilino(rs.getString("nombre_inquilino"));
            inquilino.setApellido_inquilino(rs.getString("apellido_inquilino"));
            inquilino.setCuit_inquilino(rs.getString("cuit_inquilino"));
            inquilino.setLugar_trabajo_inquilino(rs.getString("lugar_trabajo_inquilino"));
            inquilino.setNom_garante_inquilino(rs.getString("nom_garante_inquilino"));
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
 
   public Inquilino buscarInquilinoXNombre(String nombre) {
       
     
        Inquilino inquilino= null ;
        try{
        String sql = "SELECT * FROM inquilino WHERE nombre_inquilino LIKE ?;";
       // String sql ="SELECT * FROM alumno WHERE id_alumno = ? or nombre LIKE' %?%'or dni LIKE '%?%';";
        PreparedStatement ps = con.prepareStatement(sql);//, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, "%"+nombre+"%");  
      //  preparedStatement.setString(1, "%" + DT + "%");
        ResultSet rs=  ps.executeQuery();
        
        while (rs.next()){
       
        inquilino =new Inquilino() ;
       inquilino.setDni_inquilino(rs.getInt("dni_inquilino"));
            inquilino.setNombre_inquilino(rs.getString("nombre_inquilino"));
            inquilino.setApellido_inquilino(rs.getString("apellido_inquilino"));
            inquilino.setCuit_inquilino(rs.getString("cuit_inquilino"));
            inquilino.setLugar_trabajo_inquilino(rs.getString("lugar_trabajo_inquilino"));
            inquilino.setNom_garante_inquilino(rs.getString("nom_garante_inquilino"));
            inquilino.setDni_garante_inquilino(rs.getInt("dni_garante_inquilino"));
        }
       
        ps.close();
        
        } catch (SQLException ex){
            
           
            System.out.println("Error al  buscar " + ex.getMessage());
        }
         //System.out.println("Alumno: id: " + alumno.getId() + "; Nombre:  " + alumno.getNombre() +"; Dni: " + alumno.getDni() +"; Domicilio:  " +alumno.getDomicilio()) ;       
         return inquilino;
    }//FIN buscar x nombre
   
   public List <Inquilino>  busquedaXNomApeDni(StringBuffer query) {
       List <Inquilino> inquilinos= new ArrayList<Inquilino>();
       //  PreparedStatement ps = null;
       //ResultSet rs= null;
        Connection con = conexion();
     
        Inquilino inquilino= null ;
        try{
        String sql = query.toString() ;
       // String sql ="SELECT * FROM alumno WHERE id_alumno = ? or nombre LIKE' %?%'or dni LIKE '%?%';";
        PreparedStatement ps = con.prepareStatement(sql);//, Statement.RETURN_GENERATED_KEYS);
       // ps.setString(1, "%"+nombre+"%");  
      //  preparedStatement.setString(1, "%" + DT + "%");
        ResultSet rs=  ps.executeQuery();
        
        while (rs.next()){
       
        inquilino =new Inquilino() ;
            inquilino.setDni_inquilino(rs.getInt("dni_inquilino"));
            inquilino.setNombre_inquilino(rs.getString("nombre_inquilino"));
            inquilino.setApellido_inquilino(rs.getString("apellido_inquilino"));
            inquilino.setCuit_inquilino(rs.getString("cuit_inquilino"));
            inquilino.setLugar_trabajo_inquilino(rs.getString("lugar_trabajo_inquilino"));
            inquilino.setNom_garante_inquilino(rs.getString("nom_garante_inquilino"));
            inquilino.setDni_garante_inquilino(rs.getInt("dni_garante_inquilino"));
            inquilinos.add(inquilino);
        }
       
        ps.close();
        
        } catch (SQLException ex){
            
           
            System.out.println("Error al  buscar " + ex.getMessage());
        }
         //System.out.println("Alumno: id: " + alumno.getId() + "; Nombre:  " + alumno.getNombre() +"; Dni: " + alumno.getDni() +"; Domicilio:  " +alumno.getDomicilio()) ;       
         return inquilinos;
    }//FIN buscar x nombre
    
      
/*public boolean buscarInquilinoXNombre(Inquilino inquilino){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
     
        
        String sql = "SELECT * FROM inquilino WHERE nombre_inquilino LIKE ?;"; 
        
        try {
           ps = con.prepareStatement(sql);//, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, "%"+inquilino.getNombre_inquilino()+"%");  
     
            if(rs.next()){
                inquilino.setDni_inquilino(rs.getInt("dni_inquilino"));
                inquilino.setNombre_inquilino(rs.getString("nombre_inquilino"));
                inquilino.setApellido_inquilino(rs.getString("apellido_inquilino"));
                inquilino.setCuit_inquilino(rs.getString("cuit_inquilino"));
                inquilino.setLugar_trabajo_inquilino(rs.getString("lugar_trabajo_inquilino"));
                inquilino.setNom_garante_inquilino(rs.getString("nom_garante_inquilino"));
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
        
    }*/
 
}
