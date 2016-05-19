package pe.edu.ulima.pichangers.remote;

import pe.edu.ulima.pichangers.beans.RespuestaLogin;
import pe.edu.ulima.pichangers.beans.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Fernando on 13/5/2016.
 */
public interface LoginService {

    @POST("/rest/alumnos/login")
    Call<RespuestaLogin> login(@Body Usuario usuario);

}
