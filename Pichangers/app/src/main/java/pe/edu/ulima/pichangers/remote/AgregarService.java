package pe.edu.ulima.pichangers.remote;


import pe.edu.ulima.pichangers.beans.RespuestaLogin;
import retrofit2.Call;

import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Fernando on 17/5/2016.
 */
public interface AgregarService {

    @POST("/rest/equipos/{id}/{codigo_alumno}")
    Call<RespuestaLogin> agregarAlumno(@Path("id") long id,@Path("codigo_alumno") String codigo);

}
