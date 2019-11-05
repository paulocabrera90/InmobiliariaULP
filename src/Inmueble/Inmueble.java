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
    private String tipo_inmueble;
    private Propietario propietario;
    private String direccion_inmueble;
    private int altura_inmueble;
    private double superficie;
    private String zona;
    private double precio_base;

    public Inmueble(int id_inmueble, String tipo_inmueble, Propietario propietario, String direccion_inmueble, int altura_inmueble, double superficie, String zona, double precio_base) {
        this.id_inmueble = id_inmueble;
        this.tipo_inmueble = tipo_inmueble;
        this.propietario = propietario;
        this.direccion_inmueble = direccion_inmueble;
        this.altura_inmueble = altura_inmueble;
        this.superficie = superficie;
        this.zona = zona;
        this.precio_base = precio_base;
    }
    
    public Inmueble(){}
    
    public Inmueble(String tipo_inmueble, Propietario propietario, String direccion_inmueble, int altura_inmueble, double superficie, String zona, double precio_base) {
        this.tipo_inmueble = tipo_inmueble;
        this.propietario = propietario;
        this.direccion_inmueble = direccion_inmueble;
        this.altura_inmueble = altura_inmueble;
        this.superficie = superficie;
        this.zona = zona;
        this.precio_base = precio_base;
    
    }
    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public String getTipo_inmueble() {
        return tipo_inmueble;
    }

    public void setTipo_inmueble(String tipo_inmueble) {
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

    public int getAltura_inmueble() {
        return altura_inmueble;
    }

    public void setAltura_inmueble(int altura_inmueble) {
        this.altura_inmueble = altura_inmueble;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public double getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(double precio_base) {
        this.precio_base = precio_base;
    }
}