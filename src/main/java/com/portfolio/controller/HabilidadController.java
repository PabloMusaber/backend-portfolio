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
    
    @PostMapping("/habilidad/new")
    public void agregarHabilidad (@RequestBody Habilidad habi){
       habiServ.crearHabilidad(habi);
    }
    
    @GetMapping("/habilidad/ver")
    @ResponseBody
    public List<Habilidad> verHabilidad(){
        return habiServ.verHabilidad();
    }
    
    @GetMapping("/habilidad/ver/{id}")
    @ResponseBody
    public Habilidad buscarHabilidad(@PathVariable Long id){
        return habiServ.buscarHabilidad(id);
    }
    
    @DeleteMapping("/habilidad/delete/{id}")
    public void borrarHabilidad(@PathVariable Long id){
        habiServ.borrarHabilidad(id);
    }
    
    @PutMapping("/habilidad/editar/{id}")
    public Habilidad editarHabilidad (@RequestBody Habilidad habi,
                                      @PathVariable Long id){
        
        Habilidad habiOriginal = habiServ.buscarHabilidad(id);
        
        if("".equals(habi.getNombre())){
            habi.setNombre(habiOriginal.getNombre());
        }
        if(habi.getPorcentaje() == 0){
            habi.setPorcentaje(habiOriginal.getPorcentaje());
        }
        
        return habiServ.editarHabilidad(habi, id);
    }
}
