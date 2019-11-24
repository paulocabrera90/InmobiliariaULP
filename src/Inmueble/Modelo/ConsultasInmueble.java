/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmueble.Modelo;

import Propietario.Modelo.Conexion;
import Propietario.Modelo.ConsultasPropietario;
import Propietario.Modelo.Propietario;
import com.mysql.jdbc.Statement;
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
        
        String sql = "UPDATE inmueble SET id_tipo_inmueble=?,dni_propietario=?,direccion_inmueble=?,superficie=?,precio_base=?,estado_inmueble=?  WHERE id_inmueble=? "; 
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,inmueble.getTipo_inmueble().getId_tipo_inmueble());
            ps.setInt(2,inmueble.getPropietario().getDni_propietario());
            ps.setString(3,inmueble.getDireccion_inmueble());
            ps.setDouble(4,inmueble.getSuperficie());
            ps.setDouble(5,inmueble.getPrecio_base());
            ps.setString(6,inmueble.getEstado_inmueble());
            ps.setInt(7, inmueble.getId_inmueble());

           
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
      
public boolean Borrar(int id){
        
        PreparedStatement ps=null;
        Connection con = conexion();
        
        String sql = "DELETE FROM  inmueble WHERE id_inmueble=?"; 
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            if(ps.execute())
            return true;
            else return false;
            
            
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
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
            
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Inmueble inmueble=new Inmueble();
                Propietario propietario=new Propietario();
                TipoInmueble tipoinmueble=new TipoInmueble();
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
 
     
 
 
 
 public boolean filtrarInmueblesPrecioDniTipo(ArrayList<Inmueble> inmuebles, double precio_base, int dni_propietario, int id_tipo_inmueble){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM `inmueble` WHERE precio_base<"+precio_base+" AND dni_propietario="+dni_propietario+" AND id_tipo_inmueble="+id_tipo_inmueble;
        
        try {
            
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Propietario propietario=new Propietario();
                TipoInmueble tipoinmueble=new TipoInmueble();
                Inmueble inmueble=new Inmueble();
                propietario.setDni_propietario(rs.getInt("dni_propietario"));
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    public boolean filtrarInmueblesPrecioDni(ArrayList<Inmueble> inmuebles, double precio_base, int dni_propietario){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM `inmueble` WHERE precio_base <"+precio_base+" AND dni_propietario="+dni_propietario;
        
        try {
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Propietario propietario=new Propietario();
                TipoInmueble tipoinmueble=new TipoInmueble();
                Inmueble inmueble=new Inmueble();
                propietario.setDni_propietario(rs.getInt("dni_propietario"));
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    public boolean filtrarInmueblesPrecio(ArrayList<Inmueble> inmuebles, double precio_base){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM `inmueble` WHERE precio_base <"+precio_base;
        
        try {
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Propietario propietario=new Propietario();
                TipoInmueble tipoinmueble=new TipoInmueble();
                Inmueble inmueble=new Inmueble();
                propietario.setDni_propietario(rs.getInt("dni_propietario"));
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    public boolean filtrarInmueblesPrecioTipo(ArrayList<Inmueble> inmuebles, double precio_base, int tipo_inmueble){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM `inmueble` WHERE precio_base <"+precio_base+" AND id_tipo_inmueble="+tipo_inmueble;
        
        try {
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Propietario propietario=new Propietario();
                TipoInmueble tipoinmueble=new TipoInmueble();
                Inmueble inmueble=new Inmueble();
                propietario.setDni_propietario(rs.getInt("dni_propietario"));
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    public boolean filtrarInmueblesDniTipo(ArrayList<Inmueble> inmuebles, int dni_propietario, int tipo_inmueble){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM `inmueble` WHERE dni_propietario="+dni_propietario+" AND id_tipo_inmueble="+tipo_inmueble;
        
        try {
            
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Propietario propietario=new Propietario();
                TipoInmueble tipoinmueble=new TipoInmueble();
                Inmueble inmueble=new Inmueble();
                propietario.setDni_propietario(rs.getInt("dni_propietario"));
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    public boolean filtrarInmueblesDni(ArrayList<Inmueble> inmuebles,int dni_propietario){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM `inmueble` WHERE dni_propietario="+dni_propietario;
        
        try {
            
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Propietario propietario=new Propietario();
                TipoInmueble tipoinmueble=new TipoInmueble();
                Inmueble inmueble=new Inmueble();
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
        }finally{
            try {
                con.close();
                
            }
            catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
    public boolean filtrarInmueblesTipo(ArrayList<Inmueble> inmuebles, int tipo_inmueble){
        
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = conexion();
        
        String sql = "SELECT * FROM `inmueble` WHERE id_tipo_inmueble="+tipo_inmueble;
        
        try {
            
            ConsultasPropietario consultapropietario=new ConsultasPropietario();
            ConsultasTipoInmueble consultastipoinmueble=new ConsultasTipoInmueble();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Propietario propietario=new Propietario();
                TipoInmueble tipoinmueble=new TipoInmueble();
                Inmueble inmueble=new Inmueble();
                propietario.setDni_propietario(rs.getInt("dni_propietario"));
                tipoinmueble.setId_tipo_inmueble(rs.getInt("id_tipo_inmueble"));
                consultapropietario.Buscar(propietario);
                consultastipoinmueble.Buscar(tipoinmueble);
                inmueble.setTipo_inmueble(tipoinmueble);
                inmueble.setPropietario(propietario);
                inmueble.setId_inmueble(rs.getInt("Id_inmueble"));
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
