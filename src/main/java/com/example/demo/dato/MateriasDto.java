package com.example.demo.dato;

import com.example.demo.entity.EstudianteEntity;
import com.example.demo.entity.MateriasEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MateriasDto {

	private Long id;
	private String nombre;
	private String creditos;
	@JsonIgnore
	private EstudianteEntity estudiante;

	public MateriasDto() {

	}

	public MateriasDto(MateriasEntity materiasEntity) {
		this.id = materiasEntity.getId();
		this.nombre = materiasEntity.getNombre();
		this.creditos = materiasEntity.getCreditos();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * @return the creditos
	 */
	public String getCreditos() {
		return creditos;
	}

	/**
	 * @param creditos the creditos to set
	 */
	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

	/**
	 * @return the estudiante
	 */
	public EstudianteEntity getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(EstudianteEntity estudiante) {
		this.estudiante = estudiante;
	}

}
