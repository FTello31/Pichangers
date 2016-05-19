package pe.edu.ulima.pichangers.remote;

import java.util.List;

import pe.edu.ulima.pichangers.beans.AlumnoSE;
import pe.edu.ulima.pichangers.beans.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Fernando on 13/5/2016.
 */
public interface IntegrantesService {
   // @GET("/rest/alumnos")
    //Call<List<AlumnoSE>> obtenerIntegrantes();

    @GET("/rest/alumnos?sin_equipo=true")
    Call<List<AlumnoSE>> obtenerIntegrantes(@Query("sin_equipo") boolean sinequipo);
}
