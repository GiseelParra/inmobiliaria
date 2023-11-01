package com.sena.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.modelo.Publicacion;
import com.sena.repository.PublicRepository;

@Service
public class publicServicio {

	@Autowired
	private PublicRepository publicRepository;
	
	public void AnadirPublic(Publicacion publicacion) {
		publicRepository.save(publicacion);
	}

	public void ActualizarPublic(Publicacion publicacion) {
		publicRepository.save(publicacion);
	}

	public List<Publicacion> Listapublic() {
		return publicRepository.findAll();
	}

	public Publicacion buscarpublic(int IdLugar) {
		return publicRepository.findById(IdLugar).get();
	}

	public void eliminarpublic(int IdLugar) {
		publicRepository.deleteById(IdLugar);
	}

}
