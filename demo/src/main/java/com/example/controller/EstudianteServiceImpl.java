package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dato.EstudianteDto;
import com.example.demo.entity.EstudianteEntity;
import com.example.repository.IEstudioRepository;

@Service
public class EstudianteServiceImpl implements IAplicacion {

	@Autowired
	private IEstudioRepository estudioRepository;
	
	@Override
	public EstudianteDto getEstudiante(long id) {
		EstudianteEntity estdudiante = estudioRepository.findById(id).get();
		EstudianteDto estudianteDto = EstudianteDto.EntityToDto(estdudiante);
		return estudianteDto;
	}

}
