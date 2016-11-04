package com.idits.rest.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona implements Serializable {

	@Id
	@Column(unique = true,nullable = false, length = 10)
	private int dni;

	private String cuil;

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	private Date fechaDeNacimiento;

	@Column(length = 11)
	private int telefono;

	private String email;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "localidad_id")
	private Localidad localidad;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;

	@Column(name = "codigo_postal", length = 5)
	private int codigoPostal;

	@Column(name = "aportes", length = 1)
	private int realizaAportes;

	@ManyToMany( cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "personas_cursos", joinColumns = { @JoinColumn(name = "persona_dni") }, inverseJoinColumns = { @JoinColumn(name = "curso_id") })
	private Set<Curso> cursos = new HashSet();

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getRealizaAportes() {
		return realizaAportes;
	}

	public void setRealizaAportes(int realizaAportes) {
		this.realizaAportes = realizaAportes;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Persona(int id, int dni, String cuil, String nombre, String apellido, Date fechaDeNacimiento, int telefono, String email, Localidad localidad, Provincia provincia, int codigoPostal, int realizaAportes) {

		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.telefono = telefono;
		this.email = email;
		this.localidad = localidad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.realizaAportes = realizaAportes;
	}

	public Persona(int id, int dni, String cuil, String nombre, String apellido, Date fechaDeNacimiento, int telefono, String email, int codigoPostal, int realizaAportes) {

		this.dni = dni;
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.telefono = telefono;
		this.email = email;
		this.codigoPostal = codigoPostal;
		this.realizaAportes = realizaAportes;
	}

	public Persona() {
	}

	@Override
	public String toString() {
		return "Persona [ dni=" + dni + ", cuil=" + cuil + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento + ", telefono=" + telefono + ", email=" + email + ", localidad=" + localidad + ", provincia=" + provincia + ", codigoPostal=" + codigoPostal + ", realizaAportes=" + realizaAportes + "]";
	}

}