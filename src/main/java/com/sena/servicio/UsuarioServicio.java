package com.sena.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.modelo.usuario;
import com.sena.repository.UsuarioRepository;

@Service
public class UsuarioServicio {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void AnadirUsuario(usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void ActualizarUsuario(usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public List<usuario> Listausuarios() {
		return usuarioRepository.findAll();
	}

	public usuario buscarUsuario(int IdUsuario) {
		return usuarioRepository.findById(IdUsuario).get();
	}

	public void eliminarUsuario(int IdUsuario) {
		usuarioRepository.deleteById(IdUsuario);
	}

}
