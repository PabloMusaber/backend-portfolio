package com.portfolio.security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/* Comprueba si hay un token, si no lo hay devuelve una respuesta NO AUTORIZADO */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    //Se utiliza en producción para ver donde hay errores
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
    
    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fail en el método commece");
        res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
    
}
