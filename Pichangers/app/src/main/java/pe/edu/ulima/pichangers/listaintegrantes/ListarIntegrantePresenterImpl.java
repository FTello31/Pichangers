package pe.edu.ulima.pichangers.listaintegrantes;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pichangers.beans.AlumnoSE;
import pe.edu.ulima.pichangers.beans.Equipos;
import pe.edu.ulima.pichangers.beans.Usuario;
import pe.edu.ulima.pichangers.remote.IntegrantesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fernando on 13/5/2016.
 */
public class ListarIntegrantePresenterImpl implements ListarIntegrantePresenter {

    ListarIntegranteView mView;
    public ListarIntegrantePresenterImpl(ListarIntegranteView view){

        mView=view;
    }

    @Override
    public void obtenerIntegrante() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IntegrantesService service =retrofit.create(IntegrantesService.class);
        service.obtenerIntegrantes(true).enqueue(new Callback<List<AlumnoSE>>() {
            @Override
            public void onResponse(Call<List<AlumnoSE>> call, Response<List<AlumnoSE>> response) {
                List<AlumnoSE> alumnos=response.body();
                mView.mostrarListadoIntegrante(alumnos);
            }

            @Override
            public void onFailure(Call<List<AlumnoSE>> call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }
        });

    }
}
