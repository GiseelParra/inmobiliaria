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
	private String tipoLugar;

	@Column(columnDefinition = "TEXT")
	private String Descripcion;

	@Column(length = 20)
	private String direccion;

	@Column(columnDefinition = "TEXT")
	private String medida;

	@Column(length = 20)
	private String disponible;

	private String Imagen;

	public Publicacion() {

	}



	public Publicacion(int idLugar, String tipoLugar, String descripcion, String direccion, String medida,
			String disponible, String imagen) {
		super();
		IdLugar = idLugar;
		this.tipoLugar = tipoLugar;
		Descripcion = descripcion;
		this.direccion = direccion;
		this.medida = medida;
		this.disponible = disponible;
		Imagen = imagen;
	}



	public int getIdLugar() {
		return IdLugar;
	}

	public void setIdLugar(int idLugar) {
		IdLugar = idLugar;
	}

	public String getTipoLugar() {
		return tipoLugar;
	}

	public void setTipoLugar(String tipoLugar) {
		this.tipoLugar = tipoLugar;
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

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

}
