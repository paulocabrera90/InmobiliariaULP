/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmueble.Modelo;

/**
 *
 * @author garba
 */
public class TipoInmueble {
    private int id_tipo_inmueble;
    private String tipo_inmueble;
    private String zona_inmueble;

    public TipoInmueble(int id_tipo_inmueble, String tipo_inmueble, String zona_inmueble) {
        this.id_tipo_inmueble = id_tipo_inmueble;
        this.tipo_inmueble = tipo_inmueble;
        this.zona_inmueble = zona_inmueble;
    }
    
    public TipoInmueble(){}

    public int getId_tipo_inmueble() {
        return id_tipo_inmueble;
    }

    public void setId_tipo_inmueble(int id_tipo_inmueble) {
        this.id_tipo_inmueble = id_tipo_inmueble;
    }

    public String getTipo_inmueble() {
        return tipo_inmueble;
    }

    public void setTipo_inmueble(String tipo_inmueble) {
        this.tipo_inmueble = tipo_inmueble;
    }

    public String getZona_inmueble() {
        return zona_inmueble;
    }

    public void setZona_inmueble(String zona_inmueble) {
        this.zona_inmueble = zona_inmueble;
    }
    
    @Override
    public String toString(){
        return this.tipo_inmueble+", zona "+this.zona_inmueble;
    }
    
    
}
