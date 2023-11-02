package com.sena.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sena.modelo.Publicacion;
import com.sena.servicio.publicServicio;


@Controller
@RequestMapping("/PublicControlador")
public class PublicControlador {

	@Autowired
	private publicServicio publicServicio;

	@GetMapping("/")
	public String AdministrarPubli(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "AdministrarPubli";
	}

	@GetMapping("/FormuCrearpublic")
	public String FormuCrearpublic(Model model) { 
		model.addAttribute("ObPublic", new Publicacion());
		return "FormuCrearpublic";
	}

	@GetMapping("/FormuActualizarpublic")
	public String FormuActualizarpublic(Model model, @PathVariable("IdLugar") int IdLugar) {
		model.addAttribute("ObPublic", publicServicio.buscarpublic(IdLugar));
		return "FormuActualizarpublic";
	}

	@GetMapping("/Eliminarpublic/{IdLugar}")
	public String Eliminarpublic(@PathVariable("IdLugar") int IdLugar) {
		return "redirect:/PublicControlador/";
	}

	@PostMapping("/AnadirPublic")
	public String AnadirPublic(Publicacion publicacion) {
		publicServicio.AnadirPublic(publicacion);
		return "redirect:/PublicControlador/";
	}

	@PostMapping("/ActualizarPublic")
	public String ActualizarPublic(Publicacion publicacion) {
		publicServicio.ActualizarPublic(publicacion);
		return "redirect:/PublicControlador/";
	}
}
