package com.example.imp;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dato.EstudianteDto;
import com.example.demo.dato.MateriasDto;
import com.example.demo.entity.EstudianteEntity;
import com.example.demo.entity.MateriasEntity;
import com.example.repository.IEstudioRepository;
import com.example.repository.IMateriasReposytory;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private IEstudioRepository estudioRepository;

	@Autowired
	private IMateriasReposytory materiasReposytory;

	@Override
	public List<EstudianteDto> listarEstudiante() {
		return estudioRepository.findAll().stream().map(EstudianteDto::new).collect(Collectors.toList());
	}

	@Override
	public EstudianteDto getEstudiante(long id) {
		EstudianteEntity estdudiante = estudioRepository.getById(id);
		return EstudianteDto.EntityToDto(estdudiante);
	}

	@Override
	public EstudianteDto crearEstudiante(EstudianteDto estudianteDto) {
		EstudianteEntity estudiante = getEstudianteEntity(estudianteDto);
		estudiante = estudioRepository.save(estudiante);
		String base64String = estudianteDto.getFoto();
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(base64String);
			Files.write(Paths.get("fotos/" + estudiante.getId() + ".jpg"), decodedBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		estudianteDto = EstudianteDto.EntityToDto(estudiante);
		return estudianteDto;
	}

	@Override
	public EstudianteDto actualizarEstudiante(EstudianteDto estudianteDto) {
		EstudianteEntity estudiante = estudioRepository.getById(estudianteDto.getId());
		estudiante = getEstudianteEntity(estudianteDto);
		estudiante = estudioRepository.save(estudiante);
		String base64String = estudianteDto.getFoto();
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(base64String);
			Files.write(Paths.get("fotos/" + estudiante.getId() + ".jpg"), decodedBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		estudianteDto = EstudianteDto.EntityToDto(estudiante);
		return estudianteDto;
	}

	@Override
	public void eliminarEstudiante(long id) {
		estudioRepository.deleteById(id);
	}

	public EstudianteEntity getEstudianteEntity(EstudianteDto estudianteDto) {
		EstudianteEntity estudiante = new EstudianteEntity();
		if (Objects.nonNull(estudianteDto.getId())) {
			estudiante.setId(estudianteDto.getId());
		}

		if (Objects.nonNull(estudianteDto.getMaterias())) {

			List<MateriasEntity> materiasEntity = new ArrayList<>();
			for (MateriasDto materiaDto : estudianteDto.getMaterias()) {
				if (Objects.isNull(materiaDto.getId())) {
					MateriasEntity materiaEntity = new MateriasEntity(materiaDto);
					materiaEntity.setEstudiante(estudiante);
					materiasEntity.add(materiaEntity);
				} else {
					MateriasEntity materiaEntity = materiasReposytory.getById(materiaDto.getId());
					materiaEntity.setNombre(materiaDto.getNombre());
					materiaEntity.setCreditos(materiaDto.getCreditos());
					materiaEntity.setEstudiante(estudiante);
					materiasEntity.add(materiaEntity);
				}
			}
			estudiante.setMaterias(materiasEntity);
		}
		estudiante.setNombre(estudianteDto.getNombre());
		estudiante.setFechaNacimiento(estudianteDto.getFechaNacimiento());
		estudiante.setEstado(estudianteDto.isEstado());

		return estudiante;
	}

}
