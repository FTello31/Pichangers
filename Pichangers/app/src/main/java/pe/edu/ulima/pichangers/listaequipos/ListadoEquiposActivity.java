package pe.edu.ulima.pichangers.listaequipos;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.adapters.ListadoEquiposAdapter;
import pe.edu.ulima.pichangers.beans.Equipos;
import pe.edu.ulima.pichangers.mostrarinformacion.MostrarInformacionActivity;

public class ListadoEquiposActivity extends AppCompatActivity implements ListadoEquipoView {

    ListadoEquiposPresenter mPresenter;
    GridView gviEquipos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_equipos);

        //hará que aparezca el botón físico de atrás en la Action Bar de la aplicación.
        /*ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
*/

        gviEquipos = (GridView) findViewById(R.id.gviEquipos);

        setPresenter(new ListadoEquiposPresenterRemote(this));

        mPresenter.obtenerEquipos();


    }

    @Override
    public void setPresenter(ListadoEquiposPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void mostrarListadoEquipos(List<Equipos> equipos) {

        ListadoEquiposAdapter adapter = new ListadoEquiposAdapter(this, equipos);
        gviEquipos.setAdapter(adapter);
    }


    //hará que volvamos al layout anterior cuando pulsamos el botónn atras
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
        //http://androidstudiofaqs.com/tutoriales/como-poner-el-boton-de-atras-en-android-studio
        //http://cursoandroidstudio.blogspot.pe/2014/08/actionbar-ir-atras.html
    }
}