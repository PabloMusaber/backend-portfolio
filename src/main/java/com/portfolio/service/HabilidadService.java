
package com.portfolio.service;

import com.portfolio.model.Habilidad;
import com.portfolio.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService{

    @Autowired
    public HabilidadRepository habiRepo;
    
    @Override
    public List<Habilidad> verHabilidad() {
        return habiRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad habi) {
       habiRepo.save(habi);
    }

    @Override
    public void borrarHabilidad(Long id) {
       habiRepo.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habiRepo.findById(id).orElse(null);
    }
    
    @Override
    public Habilidad editarHabilidad(Habilidad habi, Long id){
        Habilidad habiEdited = habiRepo.findById(id).get();
        habiEdited.setNombre(habi.getNombre());
        habiEdited.setPorcentaje(habi.getPorcentaje());
        return habiRepo.save(habiEdited);        
    }
}
