package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IAplicacion;
import com.example.demo.dato.EstudianteDto;

@RestController
@RequestMapping("/pedidos")
public class RestAplication {

	private Logger logger = LoggerFactory.getLogger("Pedidos");

	@Autowired
	private IAplicacion iaplicacion;

	@GetMapping(value = "/saludar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> home() {
		logger.info("Este es un mensaje de información");
		logger.warn("Este es un mensaje de advertencia");
		logger.error("Este es un mensaje de error");
		return new ResponseEntity<>("Hola mundo", HttpStatus.OK);
	}

	@Transactional(readOnly = true)
	@GetMapping(value = "/estudiante/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteDto> getEstudiante(@PathVariable("id") long id) {
		EstudianteDto estudianteDto = iaplicacion.getEstudiante(id);
		return new ResponseEntity<>(estudianteDto, HttpStatus.OK);
	}

}
