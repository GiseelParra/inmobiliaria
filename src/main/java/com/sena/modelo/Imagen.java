package com.sena.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

public class Imagen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String NombreImg;
	private String contenidoImg;

	@Lob
	private Byte[] data;

	public Imagen() {
		
	}

	public Imagen(Long id, String nombreImg, String contenidoImg, Byte[] data) {
		this.id = id;
		NombreImg = nombreImg;
		this.contenidoImg = contenidoImg;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreImg() {
		return NombreImg;
	}

	public void setNombreImg(String nombreImg) {
		NombreImg = nombreImg;
	}

	public String getContenidoImg() {
		return contenidoImg;
	}

	public void setContenidoImg(String contenidoImg) {
		this.contenidoImg = contenidoImg;
	}

	public Byte[] getData() {
		return data;
	}

	public void setData(Byte[] data) {
		this.data = data;
	}

}
