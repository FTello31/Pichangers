package pe.edu.ulima.pichangers.listaintegrantes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.adapters.ListadoAlumnoSEAdapter;
import pe.edu.ulima.pichangers.beans.AlumnoSE;
import pe.edu.ulima.pichangers.beans.RespuestaLogin;
import pe.edu.ulima.pichangers.listaequipos.ListadoEquiposActivity;
import pe.edu.ulima.pichangers.remote.AgregarService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListarIntegranteActivity extends AppCompatActivity implements ListarIntegranteView {

    ListarIntegrantePresenter mPresenter;
    ListView lviIntegrantes;

    AgregarService service;

//cuando aprietes el mas tienen que salir todos los integrantes sin equipo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_integrante);

        setPresenter(new ListarIntegrantePresenterImpl(this));

        mPresenter.obtenerIntegrante();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service =retrofit.create(AgregarService.class);

        lviIntegrantes=(ListView)findViewById(R.id.lviIntegrantes);

        lviIntegrantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int i, long id1) {
                   //http://stackoverflow.com/questions/4709870/setonitemclicklistener-on-custom-listview
                    AlumnoSE listitem =(AlumnoSE)lviIntegrantes.getItemAtPosition(i);

               Intent intentPasado = getIntent();
               long id = intentPasado.getLongExtra("id", 1);

               service.agregarAlumno(id,listitem.getCodigo()).enqueue(new Callback<RespuestaLogin>() {
                   @Override
                   public void onResponse(Call<RespuestaLogin> call, Response<RespuestaLogin> response) {

                       if(response.body().getMsg().equals("OK")){
                        // Login correcto
                        Toast.makeText(ListarIntegranteActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ListarIntegranteActivity.this, ListadoEquiposActivity.class);
                           startActivity(intent);
                    }else{
                        Toast.makeText(ListarIntegranteActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    }



                   @Override
                   public void onFailure(Call<RespuestaLogin> call, Throwable t) {
                       Toast.makeText(ListarIntegranteActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               });

            }
        });

    }

    @Override
    public void setPresenter(ListarIntegrantePresenter presenter) {
        this.mPresenter=presenter;
    }

    @Override
    public void mostrarListadoIntegrante(List<AlumnoSE> alumnos) {
         ListadoAlumnoSEAdapter adapter=new ListadoAlumnoSEAdapter(this,alumnos);
        lviIntegrantes.setAdapter(adapter);
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
