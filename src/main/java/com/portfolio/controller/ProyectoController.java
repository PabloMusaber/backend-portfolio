package com.portfolio.controller;

import com.portfolio.model.Proyecto;
import com.portfolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyServ;
    
    @PostMapping("/proyecto/new")
    public void agregarProyecto (@RequestBody Proyecto proy){
        proyServ.crearProyecto(proy);
    }
    
    @GetMapping("/proyecto/ver")
    @ResponseBody
    public List<Proyecto> verProyecto(){
        return proyServ.verProyecto();
    }
    
    @DeleteMapping("/proyecto/delete/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proyServ.borrarProyecto(id);
    }
    
    @PutMapping("/proyecto/editar/{id}")
    public Proyecto editarProyecto (@RequestBody Proyecto proy,
                                    @PathVariable Long id){
        
        Proyecto proyOriginal = proyServ.buscarProyecto(id);
        
        if("".equals(proy.getNombre())){
            proy.setNombre(proyOriginal.getNombre());
        }
        if("".equals(proy.getDescripcion())){
            proy.setDescripcion(proyOriginal.getDescripcion());
        }
        if("".equals(proy.getGithub())){
            proy.setGithub(proyOriginal.getGithub());
        }
        if("".equals(proy.getLink())){
            proy.setLink(proyOriginal.getLink());
        }
        if("".equals(proy.getImagen())){
            proy.setImagen(proyOriginal.getImagen());
        }   
        
        return proyServ.editarProyecto(proy, id);
    }
    
}
