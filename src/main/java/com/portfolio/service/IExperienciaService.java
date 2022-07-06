
package com.portfolio.service;

import com.portfolio.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> verExperiencia();
    public void crearExperiencia (Experiencia exp);
    public void borrarExperiencia (Long id);
    public Experiencia buscarExperiencia (Long id);
    public Experiencia editarExperiencia (Experiencia exp, Long id);
}
