package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.imp.EstudianteServiceImpl;

@Configuration
public class AplicationConfiguration {

	@Bean
	public EstudianteServiceImpl estudianteServiceImpl() {
		return new EstudianteServiceImpl(); 
	}
}
