package com.sena.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Publicacion")
public class Publicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int IdLugar;

	@Column(length = 20)
	private String TipoLugar;

	@Column(columnDefinition = "TEXT")
	private String Descripcion;

	@Column(length = 20)
	private String direccion;

	private String Imagen;

	public Publicacion() {

	}

	public Publicacion(int idLugar, String tipoLugar, String descripcion, String direccion, String imagen) {
		IdLugar = idLugar;
		TipoLugar = tipoLugar;
		Descripcion = descripcion;
		this.direccion = direccion;
		Imagen = imagen;
	}

	public int getIdLugar() {
		return IdLugar;
	}

	public void setIdLugar(int idLugar) {
		IdLugar = idLugar;
	}

	public String getTipoLugar() {
		return TipoLugar;
	}

	public void setTipoLugar(String tipoLugar) {
		TipoLugar = tipoLugar;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

}
