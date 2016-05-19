package pe.edu.ulima.pichangers.beans;

/**
 * Created by w3110 on 13/05/2016.
 */
public class RespuestaLogin {

    private String msg;

    public RespuestaLogin(String msg) {

        this.msg = msg;
    }

    public RespuestaLogin() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
