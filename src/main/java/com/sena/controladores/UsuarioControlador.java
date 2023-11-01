package com.sena.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.modelo.usuario;
import com.sena.servicio.UsuarioServicio;

@Controller
@RequestMapping("/UsuarioControlador")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping("/")
	public String AdministrarUsuario(Model model) {
		model.addAttribute("listarusuario", usuarioServicio.Listausuarios());
		return "AdministrarUsuario";
	}

	@GetMapping("FormularioCrearUsu")
	public String FormularioCrearUsu(Model model) {
		model.addAttribute("ObUsuario", new usuario());
		return "FormularioCrearUsu";
	}

	@GetMapping("FormularioActualizarUsu")
	public String FormularioActualizarUsu(Model model, @PathVariable("IdUsuario") int IdUsuario) {
		model.addAttribute("ObUsuario", usuarioServicio.buscarUsuario(IdUsuario));
		return "FormularioActualizarUsu";
	}

	@GetMapping("/EliminarUsuario/{IdUsuario}")
	public String EliminarUsuario(@PathVariable("IdUsuario") int IdUsuario) {
		usuarioServicio.eliminarUsuario(IdUsuario);
		return "redirect:/UsuarioControlador/";
	}

	@PostMapping("/AnadirUsuario")
	public String AnadirUsuario(usuario AnadirUsuario) {
		usuarioServicio.AnadirUsuario(AnadirUsuario);
		return "redirect:/UsuarioControlador/";
	}

	@PostMapping("/ActualizarUsuario")
	public String ActualizarUsuario(usuario ActualizarUsuario) {
		usuarioServicio.ActualizarUsuario(ActualizarUsuario);
		return "redirect:/UsuarioControlador/";
	}
}
