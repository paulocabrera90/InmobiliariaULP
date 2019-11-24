
package Propietario.Modelo;


public class Propietario {
    
    
    private int dni_propietario;
    private String nombre_propietario;
    private String apellido_propietario;
    private String domicilio_propietario;
    private String telefono_propietario;

    public int getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(int dni_propietario) {
        this.dni_propietario = dni_propietario;
    }

    public String getNombre_propietario() {
        return nombre_propietario;
    }

    public void setNombre_propietario(String nombre_propietario) {
        this.nombre_propietario = nombre_propietario;
    }

    public String getApellido_propietario() {
        return apellido_propietario;
    }

    public void setApellido_propietario(String apellido_propietario) {
        this.apellido_propietario = apellido_propietario;
    }

    public String getDomicilio_propietario() {
        return domicilio_propietario;
    }

    public void setDomicilio_propietario(String domicilio_propietario) {
        this.domicilio_propietario = domicilio_propietario;
    }

    public String getTelefono_propietario() {
        return telefono_propietario;
    }

    public void setTelefono_propietario(String telefono_propietario) {
        this.telefono_propietario = telefono_propietario;
    }
    public String toString(){
        return this.nombre_propietario+" "+this.apellido_propietario;
    }
    
    
    
}
