package com.portfolio.controller;

import com.portfolio.model.Experiencia;
import com.portfolio.service.IExperienciaService;
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
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    
    @PostMapping("/experiencia/new")
    public void agregarExperiencia (@RequestParam("imagen")MultipartFile imagen,
                                    @Valid @ModelAttribute("exp") Experiencia exp,
                                    BindingResult result){
        
        if(!imagen.isEmpty()){
            String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Portfolio\\src\\assets\\img";
            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                exp.setImagen(imagen.getOriginalFilename());
            }catch (IOException e){
            }
        }
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
    public Experiencia editarExperiencia (@RequestParam(required=false) MultipartFile imagen,
                                          @ModelAttribute("exp") Experiencia exp,
                                          BindingResult result,
                                          @PathVariable Long id){
        
        Experiencia expOriginal = expServ.buscarExperiencia(id);
        if(imagen!=null && !imagen.isEmpty()){
            String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Portfolio\\src\\assets\\img";
            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                exp.setImagen(imagen.getOriginalFilename());
            }catch (IOException e){
            }
        }else{
            exp.setImagen(expOriginal.getImagen());
        }
        
        if("".equals(exp.getEmpresa())){
            exp.setEmpresa(expOriginal.getEmpresa());
        }
        
        if("".equals(exp.getDescripcion())){
            exp.setDescripcion(expOriginal.getDescripcion());
        }
        
        return expServ.editarExperiencia(exp, id);
    }
}
