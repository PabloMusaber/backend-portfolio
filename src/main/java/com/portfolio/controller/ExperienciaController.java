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
    
    @PostMapping("/experiencia/new")
    public void agregarExperiencia (@RequestBody Experiencia exp){
        expServ.crearExperiencia(exp);
    }
    
    @GetMapping("/experiencia/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia(){
        return expServ.verExperiencia();
    }
    
    @DeleteMapping("/experiencia/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        expServ.borrarExperiencia(id);
    }
    
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editarExperiencia (@RequestBody Experiencia exp,
                                          @PathVariable Long id){
        
        Experiencia expOriginal = expServ.buscarExperiencia(id);
                
        if("".equals(exp.getEmpresa())){
            exp.setEmpresa(expOriginal.getEmpresa());
        }
        if("".equals(exp.getDescripcion())){
            exp.setDescripcion(expOriginal.getDescripcion());
        }
        if("".equals(exp.getImagen())){
            exp.setImagen(expOriginal.getImagen());
        }
        
        return expServ.editarExperiencia(exp, id);
    }
}
