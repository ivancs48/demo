package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dato.EstudianteDto;
import com.example.imp.EstudianteService;

@RestController
@RequestMapping("/colegio")
public class RestAplication {

	private Logger logger = LoggerFactory.getLogger("Colegio");

	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> home() {
		logger.info("Este es un mensaje de información");
		logger.warn("Este es un mensaje de advertencia");
		logger.error("Este es un mensaje de error");
		return new ResponseEntity<>("Hola mundo", HttpStatus.OK);
	}

	@Transactional(readOnly = true)
	@GetMapping(value = "/estudiante/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteDto> getEstudiante(@PathVariable("id") long id) {
		EstudianteDto estudianteDto = estudianteService.getEstudiante(id);
		return new ResponseEntity<>(estudianteDto, HttpStatus.OK);
	}
	
	@Transactional(readOnly = true)
	@GetMapping(value = "/listaEstudiante", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteDto>> getEstudiante() {
		List<EstudianteDto> estudianteDto = estudianteService.listarEstudiante();
		return new ResponseEntity<>(estudianteDto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/crear", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteDto> crearEstudiante(@RequestBody EstudianteDto estudianteDto) {
		estudianteDto = estudianteService.crearEstudiante(estudianteDto);
		return new ResponseEntity<>(estudianteDto, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstudianteDto> actualizarEstudiante(@RequestBody EstudianteDto estudianteDto) {
		estudianteDto = estudianteService.actualizarEstudiante(estudianteDto);
		return new ResponseEntity<>(estudianteDto, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarEstudiante(@PathVariable("id") long id) {
		estudianteService.eliminarEstudiante(id);
		return new ResponseEntity<>("Estudiante eliminado", HttpStatus.OK);
	}

}
