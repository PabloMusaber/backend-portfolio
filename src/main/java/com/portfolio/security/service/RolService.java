package com.portfolio.security.service;

import com.portfolio.security.enums.RolNombre;
import com.portfolio.security.model.Rol;
import com.portfolio.security.repository.RolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre (RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
}
