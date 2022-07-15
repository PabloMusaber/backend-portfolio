
package com.portfolio.service;

import com.portfolio.model.Portfolio;
import com.portfolio.repository.PortfolioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService {

    @Autowired
    public PortfolioRepository portRepo;
    
    @Override
    public List<Portfolio> verPortfolio() {
        return portRepo.findAll();
    }

    @Override
    public void crearPortfolio(Portfolio port) {
        portRepo.save(port);
    }

    @Override
    public void borrarPortfolio(Long id) {
        portRepo.deleteById(id);
    }

    @Override
    public Portfolio buscarPortfolio(Long id) {
        return portRepo.findById(id).orElse(null);
    }
    
    @Override
    public Portfolio editarPortfolio(Portfolio port, Long id){
        Portfolio portEdited = portRepo.findById(id).get();
        portEdited.setNombre(port.getNombre());
        portEdited.setTitulo(port.getTitulo());
        portEdited.setIntroduccion(port.getIntroduccion());
        portEdited.setFooter(port.getFooter());
        portEdited.setImagen(port.getImagen());
        return portRepo.save(portEdited);        
    }    
}
