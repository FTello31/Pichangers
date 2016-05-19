package pe.edu.ulima.pichangers.mostrarinformacion;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import javax.security.auth.callback.Callback;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.Equipos;
import pe.edu.ulima.pichangers.remote.InformacionService;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MostrarInformacionActivity extends AppCompatActivity {

    ImageView iviEquipoImagen;
    TextView tviEquipoNombre;
    TextView tviPartidosGanados;
    TextView tviPartidosPerdidos;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_informacion);

        /*ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
*/
        Intent intentPasado = getIntent();
        long id = intentPasado.getLongExtra("id",1);
        //Equipos equipo = (Equipos)intentPasado.getSerializableExtra("equipo");


        iviEquipoImagen = (ImageView)findViewById(R.id.iviEquipoImagen);
        tviEquipoNombre = (TextView)findViewById(R.id.tviEquipoNombre);
        tviPartidosGanados = (TextView)findViewById(R.id.tviPartidosGanados);
        tviPartidosPerdidos = (TextView)findViewById(R.id.tviPartidosPerdidos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InformacionService service =retrofit.create(InformacionService.class);
        service.obtenerInfo(id).enqueue(new retrofit2.Callback<Equipos>() {

            @Override
            public void onResponse(Call<Equipos> call, Response<Equipos> response) {

                String nombre = response.body().getNombre();
                String urlFoto = response.body().getUrlFoto();
                int partidosGanados = response.body().getPartidosGanados();
                int partidosPerdidos = response.body().getPartidosPerdidos();

                tviPartidosGanados.setText("Partidos Ganados: " + partidosGanados);
                tviPartidosPerdidos.setText("Partidos Perdidos: " + partidosPerdidos);
                tviEquipoNombre.setText(nombre);

                Picasso.with(mContext).load(urlFoto).resize(200, 200)
                        .centerCrop()
                        .into(iviEquipoImagen);

            }

            @Override
            public void onFailure(Call<Equipos> call, Throwable t) {

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        //agregamos en el manifest---metadata donde direccionaremos el activity a donde debe retroceder
    }

}
