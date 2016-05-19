package pe.edu.ulima.pichangers.listaintegrantes;

import java.util.List;

import pe.edu.ulima.pichangers.beans.AlumnoSE;
import pe.edu.ulima.pichangers.beans.Usuario;

/**
 * Created by Fernando on 13/5/2016.
 */
public interface ListarIntegranteView {

    public void setPresenter(ListarIntegrantePresenter presenter);
    public void mostrarListadoIntegrante(List<AlumnoSE> alumnos);
}

