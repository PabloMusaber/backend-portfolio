
package com.portfolio.controller;

import com.portfolio.model.Educacion;
import com.portfolio.service.IEducacionService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @PostMapping("/educacion/new")
    public void agregarEducacion (@RequestParam("imagen")MultipartFile imagen,
                                  @Valid @ModelAttribute("edu") Educacion edu,
                                  BindingResult result){
        
        if(!imagen.isEmpty()){
            String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Argentina Programa\\Módulo 3 - Desarrollo Front End Dinámico\\Angular Porftfolio\\Portfolio\\src\\assets\\img";
            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                edu.setImagen(imagen.getOriginalFilename());
            }catch (IOException e){
            }
        }
        
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
    public Educacion editarEducacion (@RequestParam(required = false) MultipartFile imagen,
                                      @ModelAttribute("edu") Educacion edu,
                                      BindingResult result,
                                      @PathVariable Long id){
        
        Educacion eduOriginal = eduServ.buscarEducacion(id);
        if(imagen!=null && !imagen.isEmpty()){
            String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Argentina Programa\\Módulo 3 - Desarrollo Front End Dinámico\\Angular Porftfolio\\Portfolio\\src\\assets\\img";
            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                edu.setImagen(imagen.getOriginalFilename());
            }catch (IOException e){
            }
        }else{
            edu.setImagen(eduOriginal.getImagen());
        }
        
        if("".equals(edu.getAnio_edu())){
            edu.setAnio_edu(eduOriginal.getAnio_edu());
        }
        
        if("".equals(edu.getCompany_edu())){
            edu.setCompany_edu(eduOriginal.getCompany_edu());
        }
        
        if("".equals(edu.getTitle_edu())){
            edu.setTitle_edu(eduOriginal.getTitle_edu());
        }
        
        return eduServ.editarEducacion(edu, id);
    }
      
}
