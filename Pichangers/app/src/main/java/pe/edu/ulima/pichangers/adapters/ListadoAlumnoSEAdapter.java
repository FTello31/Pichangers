package pe.edu.ulima.pichangers.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.AlumnoSE;
import pe.edu.ulima.pichangers.beans.Equipos;
import pe.edu.ulima.pichangers.beans.Usuario;
import pe.edu.ulima.pichangers.listaintegrantes.ListarIntegranteActivity;

/**
 * Created by Fernando on 13/5/2016.
 */
public class ListadoAlumnoSEAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<AlumnoSE> mAlumnoSE;
    private Context mContext;


    public ListadoAlumnoSEAdapter(Context mContext, List<AlumnoSE> mAlumnoSE) {
        this.mAlumnoSE = mAlumnoSE;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mAlumnoSE.size();
    }

    @Override
    public Object getItem(int i) {
        return mAlumnoSE.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        ViewHolder viewholder;

        if (view == null){
            view = mInflater.inflate(R.layout.item_agregar_integrante,null);
            viewholder = new ViewHolder();
            viewholder.tviNombreIntegrante=(TextView) view.findViewById(R.id.tviNombreIntegrante);
            viewholder.tviCodigoIntegrante=(TextView) view.findViewById(R.id.tviCodigoIntegrante);

            view.setTag(viewholder);

        }else{
            viewholder = (ViewHolder) view.getTag();

        }
        
        AlumnoSE alumnos=mAlumnoSE.get(i);

        viewholder.tviNombreIntegrante.setText(alumnos.getNombre());
        viewholder.tviCodigoIntegrante.setText(alumnos.getCodigo());
        return view;
    }

    class ViewHolder{
        TextView tviNombreIntegrante;
        TextView tviCodigoIntegrante;
        ImageView iviMas;
    }

}
