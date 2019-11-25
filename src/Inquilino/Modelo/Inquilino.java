/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inquilino.Modelo;

/**
 *
 * @author Martin
 */
public class Inquilino {
    
    private int dni_inquilino;
    private String nombre_inquilino;
    private String apellido_inquilino;
    private String cuit_inquilino;
    private String lugar_trabajo_inquilino;
    private String nom_garante_inquilino;
    private int dni_garante_inquilino;

    public Inquilino(int dni_inquilino, String nombre_inquilino, String apellido_inquilino, String cuit_inquilino, String lugar_trabajo_inquilino, String nom_garante_inquilino, int dni_garante_inquilino) {
        this.dni_inquilino = dni_inquilino;
        this.nombre_inquilino = nombre_inquilino;
        this.apellido_inquilino = apellido_inquilino;
        this.cuit_inquilino = cuit_inquilino;
        this.lugar_trabajo_inquilino = lugar_trabajo_inquilino;
        this.nom_garante_inquilino = nom_garante_inquilino;
        this.dni_garante_inquilino = dni_garante_inquilino;
    }
    
    public Inquilino(){};

    public int getDni_inquilino() {
        return dni_inquilino;
    }

    public String getNombre_inquilino() {
        return nombre_inquilino;
    }

    public String getApellido_inquilino() {
        return apellido_inquilino;
    }

    public String getCuit_inquilino() {
        return cuit_inquilino;
    }

    public String getLugar_trabajo_inquilino() {
        return lugar_trabajo_inquilino;
    }

    public String getNom_garante_inquilino() {
        return nom_garante_inquilino;
    }

    public int getDni_garante_inquilino() {
        return dni_garante_inquilino;
    }

    public void setDni_inquilino(int dni_inquilino) {
        this.dni_inquilino = dni_inquilino;
    }

    public void setNombre_inquilino(String nombre_inquilino) {
        this.nombre_inquilino = nombre_inquilino;
    }

    public void setApellido_inquilino(String apellido_inquilino) {
        this.apellido_inquilino = apellido_inquilino;
    }

    public void setCuit_inquilino(String cuit_inquilino) {
        this.cuit_inquilino = cuit_inquilino;
    }

    public void setLugar_trabajo_inquilino(String lugar_trabajo_inquilino) {
        this.lugar_trabajo_inquilino = lugar_trabajo_inquilino;
    }

    public void setNom_garante_inquilino(String nom_garante_inquilino) {
        this.nom_garante_inquilino = nom_garante_inquilino;
    }

    public void setDni_garante_inquilino(int dni_garante_inquilino) {
        this.dni_garante_inquilino = dni_garante_inquilino;
    }
    
    public String toString(){
        return this.dni_inquilino + " - " + this.nombre_inquilino + " " + this.apellido_inquilino;
    }
}
