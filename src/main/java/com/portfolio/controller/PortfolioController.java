package com.portfolio.controller;

import com.portfolio.model.Portfolio;
import com.portfolio.service.IPortfolioService;
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
public class PortfolioController {
    
    @Autowired
    private IPortfolioService portServ;
    
    @PostMapping("/portfolio/new")
    public void agregarPortfolio (@RequestBody Portfolio port){
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
    public Portfolio editarPortfolioPrincipal (@RequestBody Portfolio port){
        
        Portfolio portOriginal = portServ.buscarPortfolio(Long.valueOf(1));
        
        if("".equals(port.getNombre())){
            port.setNombre(portOriginal.getNombre());
        }
        if("".equals(port.getTitulo())){
            port.setTitulo(portOriginal.getTitulo());
        }
        if("".equals(port.getIntroduccion())){
            port.setIntroduccion(portOriginal.getIntroduccion());
        }
        if("".equals(port.getFooter())){
            port.setFooter(portOriginal.getFooter());
        }
        if("".equals(port.getImagen())){
            port.setImagen(portOriginal.getImagen());
        }
     
        return portServ.editarPortfolio(port, Long.valueOf(1));
    }
    
    @PutMapping("/portfolio/editar/{id}")
    public Portfolio editarPortfolio (@RequestBody Portfolio port,
                                      @PathVariable Long id){
        
        Portfolio portOriginal = portServ.buscarPortfolio(id);
        
        if("".equals(port.getNombre())){
            port.setNombre(portOriginal.getNombre());
        }
        if("".equals(port.getTitulo())){
            port.setTitulo(portOriginal.getTitulo());
        }
        if("".equals(port.getIntroduccion())){
            port.setIntroduccion(portOriginal.getIntroduccion());
        }
        if("".equals(port.getFooter())){
            port.setFooter(portOriginal.getFooter());
        }
        if("".equals(port.getImagen())){
            port.setImagen(portOriginal.getImagen());
        }
     
        return portServ.editarPortfolio(port, id);
    }
    
    @DeleteMapping("/delete/portfolio/{id}")
    public void borrarPortfolio(@PathVariable Long id){
        portServ.borrarPortfolio(id);
    }
    
}
