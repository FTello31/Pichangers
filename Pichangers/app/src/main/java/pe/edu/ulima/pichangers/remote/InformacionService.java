package pe.edu.ulima.pichangers.remote;



import pe.edu.ulima.pichangers.beans.Equipos;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Fernando on 13/5/2016.
 */
public interface InformacionService {

    @GET("/rest/equipos/{id}")
    Call<Equipos> obtenerInfo(@Path("id") long id);

    /* ejemplo
    @GET("users/{user}/repos")
  Call<List<Repo>> listRepos(@Path("user") String user);
     */
}
