package com.portfolio.controller;

import com.portfolio.model.Proyecto;
import com.portfolio.service.IProyectoService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyServ;
    
    @PostMapping("/proyecto/new")
    public void agregarProyecto (@RequestParam("imagen")MultipartFile imagen,
                                 @Valid @ModelAttribute("proy") Proyecto proy,
                                 BindingResult result){
        if(!imagen.isEmpty()){
            String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Portfolio\\src\\assets\\img";
            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                proy.setImagen(imagen.getOriginalFilename());
            }catch (IOException e){
            }
        }
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
    public Proyecto editarProyecto (@RequestParam(required=false) MultipartFile imagen,
                                    @ModelAttribute("proy") Proyecto proy,
                                    BindingResult result,
                                    @PathVariable Long id){
        
        Proyecto proyOriginal = proyServ.buscarProyecto(id);
        if(imagen!=null && !imagen.isEmpty()){
            String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Portfolio\\src\\assets\\img";
            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                proy.setImagen(imagen.getOriginalFilename());
            }catch (IOException e){
            }
        }else{
            proy.setImagen(proyOriginal.getImagen());
        }
        
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
        
        return proyServ.editarProyecto(proy, id);
        
    }
    
}
