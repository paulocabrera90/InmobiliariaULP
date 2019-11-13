/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConsultaContrato {
   
    public boolean Guardar(Contrato cont){
        
        PreparedStatement ps = null;
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

    private Connection conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
