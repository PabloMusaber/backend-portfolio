
package com.portfolio.controller;

import com.portfolio.model.Habilidad;
import com.portfolio.service.IHabilidadService;
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
public class HabilidadController {
    
    @Autowired
    private IHabilidadService habiServ;
    
    @PostMapping("/new/habilidad")
    public void agregarHabilidad (@RequestBody Habilidad habi){
       habiServ.crearHabilidad(habi);
    }
    
    @GetMapping("/ver/habilidad")
    @ResponseBody
    public List<Habilidad> verHabilidad(){
        return habiServ.verHabilidad();
    }
    
    @DeleteMapping("/delete/habilidad/{id}")
    public void borrarHabilidad(@PathVariable Long id){
        habiServ.borrarHabilidad(id);
    }
    
    @PutMapping("/editar/habilidad")
    public Habilidad editarHabilidad (@RequestBody Habilidad habi){
        return habiServ.editarHabilidad(habi);
    }
    
}
