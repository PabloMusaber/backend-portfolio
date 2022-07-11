
package com.portfolio.service;

import com.portfolio.model.Proyecto;
import java.util.List;


public interface IProyectoService {
    public List<Proyecto> verProyecto();
    public void crearProyecto (Proyecto proye);
    public void borrarProyecto (Long id);
    public Proyecto buscarProyecto (Long id);
    public Proyecto editarProyecto(Proyecto proye, Long id);
}
