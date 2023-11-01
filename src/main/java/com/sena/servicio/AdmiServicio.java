package com.sena.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.modelo.Administrador;
import com.sena.repository.AdmiRepository;

@Service
public class AdmiServicio {

	@Autowired
	private AdmiRepository administradorRepository;

	public void AnadirAdmi(Administrador administrador) {
		administradorRepository.save(administrador);
	}

	public void ActualizarAdmi(Administrador administrador) {
		administradorRepository.save(administrador);
	}

	public List<Administrador> ListaAdmi() {
		return administradorRepository.findAll();
	}

	public Administrador buscarAdmi(int IdAdministrador) {
		return administradorRepository.findById(IdAdministrador).get();
	}

	public void eliminarAdmi(int IdAdministrador) {
		administradorRepository.deleteById(IdAdministrador);
	}

}
