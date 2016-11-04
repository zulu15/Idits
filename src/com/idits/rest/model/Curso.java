package com.idits.rest.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

	@Id
	@Column(name = "curso_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String descripcion;

	@Lob
	@Column(length = 100000, nullable=false)
	private String contenidos;

	@Column(nullable = false)
	private String requisitos;

	@Column(nullable = false, length = 3)
	private int cargaHoraria;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "cursos")
	private transient Set<Persona> alumnos = new HashSet();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getContenidos() {
		return contenidos;
	}

	public void setContenidos(String contenidos) {
		this.contenidos = contenidos;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Set<Persona> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Persona> alumnos) {
		this.alumnos = alumnos;
	}

	public Curso(int id, String nombre, String descripcion, String contenidos, String requisitos, int cargaHoraria, Set<Persona> alumnos) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.contenidos = contenidos;
		this.requisitos = requisitos;
		this.cargaHoraria = cargaHoraria;
		this.alumnos = alumnos;
	}

	public Curso(int id, String nombre, String descripcion, String contenidos, String requisitos, int cargaHoraria) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.contenidos = contenidos;
		this.requisitos = requisitos;
		this.cargaHoraria = cargaHoraria;
	}

	public Curso() {
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", contenidos=" + contenidos + ", requisitos=" + requisitos + ", cargaHoraria=" + cargaHoraria + ", alumnos=" + alumnos + "]";
	}

}
