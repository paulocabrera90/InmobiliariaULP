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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexion.Conexion;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
/**
 *
 * @author Usuario
 */
public class ConsultaContrato extends  Conexion {
   
    private Connection con = conexion();
    private PreparedStatement ps = null;

   public boolean Guardar(Contrato cont){
       
        String sql = "INSERT INTO contrato (id_inmueble, dni_inquilino, estado_contrato, monto, fecha_ini, fecha_fin) VALUES (?,?,?,?,?,?);"; 
        
         try {
            ps=con.prepareStatement(sql);
            //ps.setInt(1,cont.getId_contrato());
            ps.setInt(1, cont.getId_inmueble());
            ps.setInt(2, cont.getDni_inquilino());
            ps.setString(3, cont.getEstado_contrato());
            ps.setDouble(4,cont.getMonto());
            ps.setDate(5, Date.valueOf(cont.getFecha_ini().toString()));
            ps.setDate(6, Date.valueOf(cont.getFecha_fin().toString()));
            
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
                
                inmueble.setId_inmueble(rs.getInt("id_inmueble"));
                inquilino.setDni_inquilino(rs.getInt("dni_inquilino"));
                
                consultasInmueble.Buscar(inmueble);
                consultasInquilino.Buscar(inquilino);
                
                contrato.setNombreInmueble(inmueble.getTipo_inmueble().getZona_inmueble() + " - " + inmueble.getDireccion_inmueble());
                contrato.setNombreInquilino(inquilino.toString());
                contrato.setId_contrato(rs.getInt("id_contrato"));
                contrato.setEstado_contrato(rs.getString("estado_contrato"));
                contrato.setMonto(rs.getDouble("monto"));
                contrato.setFecha_ini(rs.getDate("fecha_ini").toLocalDate());
               contrato.setFecha_fin(rs.getDate("fecha_fin").toLocalDate()); 
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
    
}
