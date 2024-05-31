package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.dato.MateriasDto;

@Entity
@Table(name = "materias")
public class MateriasEntity implements Serializable{

	private static final long serialVersionUID = -1532573550209722802L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;
	
	@Column
	private String creditos;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = EstudianteEntity.class)
	@JoinColumn(name = "id_estudiante")
	private EstudianteEntity estudiante;

	public MateriasEntity() {
		
	}
	
	public MateriasEntity(MateriasDto materiasDto) {
		this.nombre = materiasDto.getNombre();
		this.creditos = materiasDto.getCreditos();
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
