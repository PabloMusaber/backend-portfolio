
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
    public Educacion editarEducacion(Educacion edu){
        Long id = edu.getId_edu();
        Educacion eduEdited = eduRepo.findById(id).get();
        eduEdited.setAnio_edu(edu.getAnio_edu());
        eduEdited.setCompany_edu(edu.getCompany_edu());
        eduEdited.setTitle_edu(edu.getTitle_edu());
        return eduRepo.save(eduEdited);
    }
    
}
