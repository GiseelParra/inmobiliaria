package com.sena.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sena.servicio.publicServicio;

@Controller
public class RegistroControlador {
	
	
	@Autowired
	private publicServicio publicServicio;

	@Autowired
	private PublicControlador publicControlador;

	@GetMapping("/Registro")
	public String Registro() {
		return "Registro";
	}

	@GetMapping("/casas")
	public String casa(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "casas";
	}

	@GetMapping("/apartamentos")
	public String apartamentos(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "apartamentos";
	}

	@GetMapping("/lotes")
	public String lotes(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "lotes";
	}

	@GetMapping("/terrenos")
	public String terrenos(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "terrenos";
	}

	@GetMapping("/fincas")
	public String fincas(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "fincas";
	}

	@GetMapping("/locales")
	public String locales(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "locales";
	}

	@GetMapping("/oficinas")
	public String oficinas(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "oficinas";
	}

	@GetMapping("/edificios")
	public String edificios(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "edificios";
	}
	
	@GetMapping("/arriendo")
	public String arriendo(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "arriendo";
	}
	@GetMapping("/alquiler")
	public String alquiler(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "alquiler";
	}
	@GetMapping("/venta")
	public String venta(Model model) {
		model.addAttribute("listarPublic", publicServicio.listarPublicaciones());
		return "venta";
	}

}
