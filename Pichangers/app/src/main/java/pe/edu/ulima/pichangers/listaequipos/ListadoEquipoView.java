package pe.edu.ulima.pichangers.listaequipos;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipos;

/**
 * Created by Fernando on 12/5/2016.
 */
public interface ListadoEquipoView {
    public void setPresenter(ListadoEquiposPresenter presenter);
    public void mostrarListadoEquipos(List<Equipos> equipos);
}
