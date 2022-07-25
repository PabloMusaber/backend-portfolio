package com.portfolio.controller;

import com.portfolio.model.Educacion;
import com.portfolio.service.IEducacionService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @PostMapping("/educacion/new")
    public void agregarEducacion (@RequestBody Educacion edu){
        eduServ.crearEducacion(edu);
    }
    
    @GetMapping("/educacion/ver")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return eduServ.verEducacion();
    }
    
    @DeleteMapping("/educacion/delete/{id}")
    public void borrarEducacion(@PathVariable Long id){
        eduServ.borrarEducacion(id);
    }
    
    @PutMapping("/educacion/editar/{id}")
    public Educacion editarEducacion (@RequestBody Educacion edu,
                                      @PathVariable Long id){
        
        Educacion eduOriginal = eduServ.buscarEducacion(id);
                
        if("".equals(edu.getAnio())){
            edu.setAnio(eduOriginal.getAnio());
        }
        if("".equals(edu.getInstitucion())){
            edu.setInstitucion(eduOriginal.getInstitucion());
        }
        if("".equals(edu.getTitulo())){
            edu.setTitulo(eduOriginal.getTitulo());
        }
        if("".equals(edu.getImagen())){
            edu.setImagen(eduOriginal.getImagen());
        }
        
        return eduServ.editarEducacion(edu, id);
    }
      
}