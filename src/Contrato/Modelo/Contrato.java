/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato.Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Contrato {
    private int id_contrato;
    private int id_inmueble;
    private int dni_inquilino;
    private String estado_contrato;
    private double monto;
    private short vigente;
    private LocalDate fecha_ini;
    private LocalDate fecha_fin;
    private String nombreInquilino;
    private String nombreInmueble;

    public Contrato(int id_contrato, int id_inmueble, int dni_inquilino, String estado_contrato, double monto, short vigente, LocalDate fecha_ini, LocalDate fecha_fin) {
        this.id_contrato = id_contrato;
        this.id_inmueble = id_inmueble;
        this.dni_inquilino = dni_inquilino;
        this.estado_contrato = estado_contrato;
        this.monto = monto;
        this.vigente = vigente;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }
    
    public Contrato() {
        this.id_contrato = -1;
        this.id_inmueble = -1;
        this.dni_inquilino = -1;
        this.estado_contrato = "";
        this.monto = -1;
        this.vigente = -1;
        this.fecha_ini = null;
        this.fecha_fin = null;
    }
    
    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public int getDni_inquilino() {
        return dni_inquilino;
    }

    public void setDni_inquilino(int dni_inquilino) {
        this.dni_inquilino = dni_inquilino;
    }

    public String getEstado_contrato() {
        return this.estado_contrato;
    }

    public void setEstado_contrato(String estado_contrato) {
        this.estado_contrato = estado_contrato;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public short getVigente() {
        return vigente;
    }

    public void setVigente(short vigente) {
        this.vigente = vigente;
    }

    public LocalDate getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(LocalDate fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    /**
     * @return the nombreInquilino
     */
    public String getNombreInquilino() {
        return nombreInquilino;
    }

    /**
     * @param nombreInquilino the nombreInquilino to set
     */
    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    /**
     * @return the nombreInmueble
     */
    public String getNombreInmueble() {
        return nombreInmueble;
    }

    /**
     * @param nombreInmueble the nombreInmueble to set
     */
    public void setNombreInmueble(String nombreInmueble) {
        this.nombreInmueble = nombreInmueble;
    }
    
   
    
}
