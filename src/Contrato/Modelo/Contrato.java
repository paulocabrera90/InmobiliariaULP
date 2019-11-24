/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contrato.Modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Contrato {
    private int id_contrato;
    private int id_inmueble;
    private int dni_inquilino;
    private int id_estado_contrato;
    private double monto;
    private short vigente;
    private Date fecha_ini;
    private Date fecha_fin;

    public Contrato(int id_contrato, int id_inmueble, int dni_inquilino, int id_estado_contrato, double monto, short vigente, Date fecha_ini, Date fecha_fin) {
        this.id_contrato = id_contrato;
        this.id_inmueble = id_inmueble;
        this.dni_inquilino = dni_inquilino;
        this.id_estado_contrato = id_estado_contrato;
        this.monto = monto;
        this.vigente = vigente;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }
    
    public Contrato() {
        this.id_contrato = -1;
        this.id_inmueble = -1;
        this.dni_inquilino = -1;
        this.id_estado_contrato = -1;
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

    public int getId_estado_contrato() {
        return id_estado_contrato;
    }

    public void setId_estado_contrato(int id_estado_contrato) {
        this.id_estado_contrato = id_estado_contrato;
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

    public Date getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(Date fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    
   
    
}
