package pe.edu.ulima.pichangers.listaequipos;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipos;
import pe.edu.ulima.pichangers.remote.EquiposService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fernando on 13/5/2016.
 */
public class ListadoEquiposPresenterRemote implements ListadoEquiposPresenter{

    ListadoEquipoView mView;

    public ListadoEquiposPresenterRemote(ListadoEquipoView view) {

        mView = view;
    }

    @Override
    public void obtenerEquipos() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EquiposService service =retrofit.create(EquiposService.class);
        service.obtenerEquipos().enqueue(new Callback<List<Equipos>>() {

            @Override
            public void onResponse(Call<List<Equipos>> call, Response<List<Equipos>> response) {
                List<Equipos> equipos =response.body();
                mView.mostrarListadoEquipos(equipos);
            }

            @Override
            public void onFailure(Call<List<Equipos>> call, Throwable t) {
                Log.e("Pichangers", t.getMessage());
            }
        });


    }
}
