package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.controller.EstudianteServiceImpl;
import com.example.controller.IAplicacion;

@Configuration
public class ApplicationConfig {

    @Bean
    public IAplicacion applicationService() {
        return new EstudianteServiceImpl();
    }
}
