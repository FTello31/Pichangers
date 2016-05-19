package pe.edu.ulima.pichangers.beans;

import java.io.Serializable;

/**
 * Created by Fernando on 11/5/2016.
 */
public class Equipos implements Serializable {

    private long id;
    private String nombre;
    private int partidosGanados;
    private int partidosPerdidos;
    private String urlFoto;

    public Equipos(long id, String nombre, int partidosGanados, int partidosPerdidos, String urlFoto) {
        this.id = id;
        this.nombre = nombre;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.urlFoto = urlFoto;
    }

    public Equipos() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
