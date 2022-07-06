package com.portfolio;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagenConfiguracion implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry); 
        registry.addResourceHandler("/img/**").addResourceLocations("file:/C:/Users/Pablo/Desktop/Argentina Programa/Módulo 3 - Desarrollo Front End Dinámico/Angular Porftfolio/Portfolio/src/assets/img");
    }
    
    
    
  
    
}
