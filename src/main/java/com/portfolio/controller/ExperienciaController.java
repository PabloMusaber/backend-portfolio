
package com.portfolio.controller;

import com.portfolio.model.Experiencia;
import com.portfolio.service.IExperienciaService;
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
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    
    @PostMapping("/new/experiencia")
    public void agregarPersona (@RequestBody Experiencia exp){
       expServ.crearExperiencia(exp);
    }
    
    @GetMapping("/ver/experiencia")
    @ResponseBody
    public List<Experiencia> verExperiencia(){
        return expServ.verExperiencia();
    }
    
    @DeleteMapping("/delete/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        expServ.borrarExperiencia(id);
    }
    
    @PutMapping("/editar/experiencia")
    public Experiencia editarExperiencia (@RequestBody Experiencia exp){
        return expServ.editarExperiencia(exp);
    }
}