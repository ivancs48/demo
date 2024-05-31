package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "estudiantes")
public class EstudianteEntity implements Serializable {

	private static final long serialVersionUID = 2187573283781340742L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;

	@Column
	private boolean estado;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = MateriasEntity.class, mappedBy = "estudiante", cascade = CascadeType.ALL)
	private List<MateriasEntity> materias = new ArrayList<>();

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
	 * @return the fecha
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fecha to set
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
	public List<MateriasEntity> getMaterias() {
		return materias;
	}

	/**
	 * @param materias the materias to set
	 */
	public void setMaterias(List<MateriasEntity> materias) {
		this.materias = materias;
	}

}
