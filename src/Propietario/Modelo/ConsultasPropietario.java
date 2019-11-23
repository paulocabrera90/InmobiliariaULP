/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Propietario.Modelo;

import Inquilino.Modelo.Inquilino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            ps.setString(5,propi.getTelefono_propietario());
           
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
            ps.setString(4,propi.getTelefono_propietario());
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
                propi.setTelefono_propietario(rs.getString("telefono_propietario"));
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

public boolean obtenerPropietarios(List <Propietario> propietarios){
        new ArrayList<Propietario>();
         PreparedStatement ps = null;
       ResultSet rs= null;
        Connection con = conexion();
          try {
            
            
            String sql= "SELECT * FROM propietario ORDER BY apellido_propietario;";
             ps= con.prepareStatement(sql);
             rs= ps.executeQuery();
            Propietario propietario;// = new Inquilino();
                      
           // ConsultasPropietario consultapropietario=new ConsultasPropietario();
           
          
            
            while(rs.next()){
            propietario= new Propietario();
              propietario.setDni_propietario(rs.getInt("dni_propietario"));
            propietario.setNombre_propietario(rs.getString("nombre_propietario"));
            propietario.setApellido_propietario(rs.getString("apellido_propietario"));
            propietario.setDomicilio_propietario(rs.getString("domicilio_propietario"));
            propietario.setTelefono_propietario(rs.getString("telefono_propietario"));
            propietarios.add(propietario);
            }
           ps.close();
           return true;
          
          }   catch (SQLException ex) {
           // Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);obtener
            System.out.println("No se puede obtener lista de propietario ");
           return false;
        }
          

    }

public Propietario buscarPropietarioXNombre(String nombre) {
       
     
       Propietario propietario= null ;
        try{
        String sql = "SELECT * FROM propietario WHERE nombre_propietario LIKE ?;";
       // String sql ="SELECT * FROM alumno WHERE id_alumno = ? or nombre LIKE' %?%'or dni LIKE '%?%';";
        PreparedStatement ps = con.prepareStatement(sql);//, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, "%"+nombre+"%");  
      //  preparedStatement.setString(1, "%" + DT + "%");
        ResultSet rs=  ps.executeQuery();
        
        while (rs.next()){
       
        propietario =new Propietario() ;
       propietario.setDni_propietario(rs.getInt("dni_propietario"));
            propietario.setNombre_propietario(rs.getString("nombre_propietario"));
            propietario.setApellido_propietario(rs.getString("apellido_propietario"));
            propietario.setDomicilio_propietario(rs.getString("domicilio_propietario"));
            propietario.setTelefono_propietario(rs.getString("telefono_propietario"));
            
        }
       
        ps.close();
        
        } catch (SQLException ex){
            
           
            System.out.println("Error al  buscar " + ex.getMessage());
        }
         //System.out.println("Alumno: id: " + alumno.getId() + "; Nombre:  " + alumno.getNombre() +"; Dni: " + alumno.getDni() +"; Domicilio:  " +alumno.getDomicilio()) ;       
         return propietario;
    }//FIN buscar x nombre
    

public List <Propietario>  busquedaXNomApeDniP(StringBuffer query) {
       List <Propietario> propietarios= new ArrayList<Propietario>();
       //  PreparedStatement ps = null;
       //ResultSet rs= null;
        Connection con = conexion();
     
        Propietario propietario= null ;
        try{
        String sql = query.toString() ;
       // String sql ="SELECT * FROM alumno WHERE id_alumno = ? or nombre LIKE' %?%'or dni LIKE '%?%';";
        PreparedStatement ps = con.prepareStatement(sql);//, Statement.RETURN_GENERATED_KEYS);
       // ps.setString(1, "%"+nombre+"%");  
      //  preparedStatement.setString(1, "%" + DT + "%");
        ResultSet rs=  ps.executeQuery();
        
        while (rs.next()){
       
        propietario =new Propietario() ;
            propietario.setDni_propietario(rs.getInt("dni_propietario"));
            propietario.setNombre_propietario(rs.getString("nombre_propietario"));
            propietario.setApellido_propietario(rs.getString("apellido_propietario"));
            propietario.setDomicilio_propietario(rs.getString("domicilio_propietario"));
            propietario.setTelefono_propietario(rs.getString("telefono_propietario"));
         
            propietarios.add(propietario);
        }
       
        ps.close();
        
        } catch (SQLException ex){
            
           
            System.out.println("Error al  buscar " + ex.getMessage());
        }
         //System.out.println("Alumno: id: " + alumno.getId() + "; Nombre:  " + alumno.getNombre() +"; Dni: " + alumno.getDni() +"; Domicilio:  " +alumno.getDomicilio()) ;       
         return propietarios;

}
 
}
