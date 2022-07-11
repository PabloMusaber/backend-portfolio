
package com.portfolio.service;

import com.portfolio.model.Habilidad;
import java.util.List;


public interface IHabilidadService {
    public List<Habilidad> verHabilidad();
    public void crearHabilidad (Habilidad habi);
    public void borrarHabilidad (Long id);
    public Habilidad buscarHabilidad (Long id);
    public Habilidad editarHabilidad (Habilidad habi, Long id);
}
