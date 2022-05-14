
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
    public Portfolio editarPortfolio(Portfolio port){
        Long id = port.getId_portfolio();
        Portfolio portEdited = portRepo.findById(id).get();
        portEdited.setName(port.getName());
        portEdited.setTitle(port.getTitle());
        portEdited.setIntroduction(port.getIntroduction());
        portEdited.setFooter(port.getFooter());
        return portRepo.save(portEdited);        
    }    
}