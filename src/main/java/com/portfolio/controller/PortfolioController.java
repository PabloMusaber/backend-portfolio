
package com.portfolio.controller;

import com.portfolio.model.Portfolio;
import com.portfolio.service.IPortfolioService;
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
public class PortfolioController {
    
    @Autowired
    private IPortfolioService portServ;
    
    @PostMapping("/portfolio/new")
    public void agregarPortfolio (@RequestParam("imagen")MultipartFile imagen,
                                  @Valid @ModelAttribute("port") Portfolio port,
                                  BindingResult result){
       
        if(!imagen.isEmpty()){
            String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Argentina Programa\\Módulo 3 - Desarrollo Front End Dinámico\\Angular Porftfolio\\Portfolio\\src\\assets\\img";
            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                port.setImagen(imagen.getOriginalFilename());
            }catch (IOException e){
            }
        }
        portServ.crearPortfolio(port);
    }

    @GetMapping("/portfolio/ver")
    @ResponseBody
    public List<Portfolio> verPortfolio(){
        return portServ.verPortfolio();
    }
    
    @GetMapping("/portfolio/data")
    @ResponseBody
    public Portfolio verPortfolioPrincipal(){
        return portServ.buscarPortfolio(Long.valueOf(1));
    }
    
    @PutMapping("/portfolio/editar-data")
    public Portfolio editarPortfolioPrincipal (@RequestParam(required=false) MultipartFile imagen,
                                               @ModelAttribute("port") Portfolio port,
                                               BindingResult result){
        
        Portfolio portOriginal = portServ.buscarPortfolio(Long.valueOf(1));
        
        
            if(imagen!=null && !imagen.isEmpty()){
                String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Argentina Programa\\Módulo 3 - Desarrollo Front End Dinámico\\Angular Porftfolio\\Portfolio\\src\\assets\\img";
                try{
                    byte[] bytesImg = imagen.getBytes();
                    Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                    Files.write(rutaCompleta, bytesImg);
                    port.setImagen(imagen.getOriginalFilename());
                }catch (IOException e){
                }
            }else{
                port.setImagen(portOriginal.getImagen());
            }
        
        
        if("".equals(port.getName())){
            port.setName(portOriginal.getName());
        }
        if("".equals(port.getTitle())){
            port.setTitle(portOriginal.getTitle());
        }
        if("".equals(port.getIntroduction())){
            port.setIntroduction(portOriginal.getIntroduction());
        }
        if("".equals(port.getFooter())){
            port.setFooter(portOriginal.getFooter());
        }
     
        return portServ.editarPortfolio(port, Long.valueOf(1));
    }
    
    
    
    @PutMapping("/portfolio/editar/{id}")
    public Portfolio editarPortfolio (@RequestParam(required=false) MultipartFile imagen,
                                      @ModelAttribute("port") Portfolio port,
                                      BindingResult result,
                                      @PathVariable Long id){
        
        Portfolio portOriginal = portServ.buscarPortfolio(id);
        
        if(imagen!=null && !imagen.isEmpty()){
            String rutaAbsoluta = "C:\\Users\\Pablo\\Desktop\\Argentina Programa\\Módulo 3 - Desarrollo Front End Dinámico\\Angular Porftfolio\\Portfolio\\src\\assets\\img";
            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);
                port.setImagen(imagen.getOriginalFilename());
            }catch (IOException e){
            }
        }else{
            port.setImagen(portOriginal.getImagen());
        }
        
        if("".equals(port.getName())){
            port.setName(portOriginal.getName());
        }
        if("".equals(port.getTitle())){
            port.setTitle(portOriginal.getTitle());
        }
        if("".equals(port.getIntroduction())){
            port.setIntroduction(portOriginal.getIntroduction());
        }
        if("".equals(port.getFooter())){
            port.setFooter(portOriginal.getFooter());
        }
     
        return portServ.editarPortfolio(port, id);
    }
    
    @DeleteMapping("/delete/portfolio/{id}")
    public void borrarPortfolio(@PathVariable Long id){
        portServ.borrarPortfolio(id);
    }
    
}
