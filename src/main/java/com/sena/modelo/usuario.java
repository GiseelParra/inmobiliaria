package com.sena.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdUsuario;

	@Column(length = 50)
	private String nombre;

	@Column(length = 50)
	private String apellido;

	@Column(length = 70)
	private String correo;

	public usuario() {

	}

	public usuario(int idUsuario, String nombre, String apellido, String correo) {
		IdUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
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
		return correo;
	}

	public void setCelular(String correo) {
		this.correo = correo;
	}

}
