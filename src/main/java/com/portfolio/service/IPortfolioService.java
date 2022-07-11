
package com.portfolio.service;

import com.portfolio.model.Portfolio;
import java.util.List;

public interface IPortfolioService {
    public List<Portfolio> verPortfolio();
    public void crearPortfolio (Portfolio port);
    public void borrarPortfolio (Long id);
    public Portfolio buscarPortfolio (Long id);
    public Portfolio editarPortfolio (Portfolio port, Long id);
}
