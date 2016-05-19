package pe.edu.ulima.pichangers.remote;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Fernando on 11/5/2016.
 */
public interface EquiposService {

    @GET("/rest/equipos")
    Call<List<Equipos>> obtenerEquipos();

}
