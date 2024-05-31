package com.example.imp;

import java.util.List;

import com.example.demo.dato.EstudianteDto;

public interface EstudianteService {

	public List<EstudianteDto> listarEstudiante();

	public EstudianteDto getEstudiante(long id);

	public EstudianteDto crearEstudiante(EstudianteDto estudianteDto);

	public EstudianteDto actualizarEstudiante(EstudianteDto estudianteDto);

	public void eliminarEstudiante(long id);

}
