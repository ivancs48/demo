package com.example.demo.dato;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.demo.entity.EstudianteEntity;

public class EstudianteDto {

	private long id;
	private String nombre;
	private Date fechaNacimiento;
	private boolean estado;
	private List<MateriasDto> materias;
	
	private String foto;

	public EstudianteDto() {
	}

	public EstudianteDto(EstudianteEntity estudianteEntity) {
		super();
		this.id = estudianteEntity.getId();
		this.nombre = estudianteEntity.getNombre();
		this.fechaNacimiento = estudianteEntity.getFechaNacimiento();
		this.estado = estudianteEntity.isEstado();
		this.materias = estudianteEntity.getMaterias().stream().map(MateriasDto::new).collect(Collectors.toList());
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * @return the materias
	 */
	public List<MateriasDto> getMaterias() {
		return materias;
	}

	/**
	 * @param materias the materias to set
	 */
	public void setMaterias(List<MateriasDto> materias) {
		this.materias = materias;
	}
	
	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public static EstudianteDto EntityToDto(EstudianteEntity estudianteEntity) {
		return Objects.nonNull(estudianteEntity) ? new EstudianteDto(estudianteEntity) : new EstudianteDto();
	}

}
