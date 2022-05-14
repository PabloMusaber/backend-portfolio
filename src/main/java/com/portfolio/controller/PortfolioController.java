
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
    
    @PostMapping("/new/portfolio")
    public void agregarPersona (@RequestBody Portfolio port){
       portServ.crearPortfolio(port);
    }
    
    @GetMapping("/ver/portfolio")
    @ResponseBody
    public List<Portfolio> verPortfolio(){
        return portServ.verPortfolio();
    }
    
    @DeleteMapping("/delete/portfolio/{id}")
    public void borrarPortfolio(@PathVariable Long id){
        portServ.borrarPortfolio(id);
    }
    
    @PutMapping("/editar/portfolio")
    public Portfolio editarPortfolio (@RequestBody Portfolio port){
        return portServ.editarPortfolio(port);
    }
    
}
