package pe.edu.ulima.pichangers.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.Equipos;
import pe.edu.ulima.pichangers.listaintegrantes.ListarIntegranteActivity;
import pe.edu.ulima.pichangers.mostrarinformacion.MostrarInformacionActivity;

/**
 * Created by Fernando on 12/5/2016.
 */
public class ListadoEquiposAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<Equipos> mEquipos;
    private Context mContext;


    public ListadoEquiposAdapter(Context mContext,List<Equipos> mEquipos) {
        mInflater = LayoutInflater.from(mContext);
        this.mEquipos = mEquipos;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mEquipos.size();
    }

    @Override
    public Object getItem(int i) {
        return mEquipos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mEquipos.get(i).getId();
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ViewHolder viewholder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_listado_equipos,null);
            viewholder = new ViewHolder();
            viewholder.iviEquipoImagen=(ImageView) view.findViewById(R.id.iviEquipoImagen);
            viewholder.tviNombreEquipo = (TextView) view.findViewById(R.id.tviEquipoNombre);
            viewholder.iviMas = (ImageView)view.findViewById(R.id.iviMas);
            viewholder.iviMas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("CLICK" , "Entra");
                    Intent intent = new Intent(mContext, ListarIntegranteActivity.class);
                    intent.putExtra("id",getItemId(i));
                    mContext.startActivity(intent);
                }
            });

            viewholder.iviEquipoImagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("CLICK", "Entra");
                    Intent intent = new Intent(mContext, MostrarInformacionActivity.class);
                    intent.putExtra("id",getItemId(i));
                    mContext.startActivity(intent);
                }
            });

            view.setTag(viewholder);

        }else{
            viewholder = (ViewHolder) view.getTag();
        }
        Equipos equipos = mEquipos.get(i);

        viewholder.tviNombreEquipo.setText(equipos.getNombre());
        Picasso.with(mContext)
                .load(equipos.getUrlFoto())
                .resize(200,200)
                .centerCrop()
                .into(viewholder.iviEquipoImagen);

        return view;
    }

    class ViewHolder{
        ImageView iviEquipoImagen;
        TextView tviNombreEquipo;
        ImageView iviMas;
    }
}
