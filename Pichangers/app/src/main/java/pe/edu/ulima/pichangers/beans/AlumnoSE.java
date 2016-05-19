package pe.edu.ulima.pichangers.beans;

import java.io.Serializable;

/**
 * Created by Fernando on 13/5/2016.
 */

//alumnos sin equipo
public class AlumnoSE implements Serializable{

    private String nombre;
    private String codigo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public AlumnoSE(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public AlumnoSE() {
    }
}
