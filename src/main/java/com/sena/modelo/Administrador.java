package com.sena.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Administrador")
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdAdmi;

	@Column(length = 50)
	private String nombre;

	@Column(length = 50)
	private String apellido;

	@Column(length = 10)
	private String celular;

	@Column(length = 15)
	private String cargo;

	public Administrador() {

	}

	public Administrador(int idAdmi, String nombre, String apellido, String celular, String cargo) {
		IdAdmi = idAdmi;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.cargo = cargo;
	}

	public int getIdAdmi() {
		return IdAdmi;
	}

	public void setIdAdmi(int idAdmi) {
		IdAdmi = idAdmi;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
