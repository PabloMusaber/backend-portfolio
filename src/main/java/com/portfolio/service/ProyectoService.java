
package com.portfolio.service;

import com.portfolio.model.Proyecto;
import com.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proyRepo;
    
    @Override
    public List<Proyecto> verProyecto() {
        return proyRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto proye) {
        proyRepo.save(proye);
    }

    @Override
    public void borrarProyecto(Long id) {
       proyRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyRepo.findById(id).orElse(null);
    }
    
    @Override
    public Proyecto editarProyecto(Proyecto proye, Long id){
        Proyecto proyEdited = proyRepo.findById(id).get();
        proyEdited.setNombre(proye.getNombre());
        proyEdited.setDescripcion(proye.getDescripcion());
        proyEdited.setGithub(proye.getGithub());
        proyEdited.setLink(proye.getLink());
        proyEdited.setImagen(proye.getImagen());
        return proyRepo.save(proyEdited);
    }
}
