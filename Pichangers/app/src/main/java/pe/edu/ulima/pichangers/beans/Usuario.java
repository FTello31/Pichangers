package pe.edu.ulima.pichangers.beans;

import java.io.Serializable;

/**
 * Created by W3209 on 11/05/2016.
 */
public class Usuario implements Serializable{
    private String usuario;
    private String password;

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
