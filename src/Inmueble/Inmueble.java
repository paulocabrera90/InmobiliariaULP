/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inmueble;

import Propietario.Modelo.Propietario;

/**
 *
 * @author garba
 */
public class Inmueble {
    private int id_inmueble;
    private TipoInmueble tipo_inmueble;
    private Propietario propietario;
    private String direccion_inmueble;
    private double superficie;
    private double precio_base;
    private String estado_inmueble;

    public Inmueble(int id_inmueble, TipoInmueble tipo_inmueble, Propietario propietario, String direccion_inmueble, double superficie, double precio_base, String estado_inmueble) {
        this.id_inmueble = id_inmueble;
        this.tipo_inmueble = tipo_inmueble;
        this.propietario = propietario;
        this.direccion_inmueble = direccion_inmueble;
        this.precio_base = precio_base;
        this.estado_inmueble=estado_inmueble;
    }
    
    public Inmueble(){}
    
    public Inmueble(TipoInmueble tipo_inmueble, Propietario propietario, String direccion_inmueble, double superficie,double precio_base, String estado_inmueble) {
        this.tipo_inmueble = tipo_inmueble;
        this.propietario = propietario;
        this.direccion_inmueble = direccion_inmueble;
        this.superficie = superficie;
        this.precio_base = precio_base;
        this.estado_inmueble=estado_inmueble;
    
    }
    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public TipoInmueble getTipo_inmueble() {
        return tipo_inmueble;
    }

    public void setTipo_inmueble(TipoInmueble tipo_inmueble) {
        this.tipo_inmueble = tipo_inmueble;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getDireccion_inmueble() {
        return direccion_inmueble;
    }

    public void setDireccion_inmueble(String direccion_inmueble) {
        this.direccion_inmueble = direccion_inmueble;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
    }

    public String getEstado_inmueble() {
        return estado_inmueble;
    }

    public void setEstado_inmueble(String estado_inmueble) {
        this.estado_inmueble = estado_inmueble;
    }
    
}