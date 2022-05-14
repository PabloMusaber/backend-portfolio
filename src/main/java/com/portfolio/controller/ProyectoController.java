
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
    
    @PostMapping("/new/proyecto")
    public void agregarProyecto (@RequestBody Proyecto proy){
       proyServ.crearProyecto(proy);
    }
    
    @GetMapping("/ver/proyecto")
    @ResponseBody
    public List<Proyecto> verProyecto(){
        return proyServ.verProyecto();
    }
    
    @DeleteMapping("/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proyServ.borrarProyecto(id);
    }
    
    @PutMapping("/editar/proyecto")
    public Proyecto editarProyecto (@RequestBody Proyecto proy){
        return proyServ.editarProyecto(proy);
    }
    
}
