
package com.portfolio.service;

import com.portfolio.model.Educacion;
import com.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
       eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }
    
    @Override
    public Educacion editarEducacion(Educacion edu, Long id){
        Educacion eduEdited = eduRepo.findById(id).get();
        eduEdited.setAnio(edu.getAnio());
        eduEdited.setInstitucion(edu.getInstitucion());
        eduEdited.setTitulo(edu.getTitulo());
        eduEdited.setImagen(edu.getImagen());
        return eduRepo.save(eduEdited);
    }
    
}
