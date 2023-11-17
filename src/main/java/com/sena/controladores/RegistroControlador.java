package com.sena.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sena.servicio.publicServicio;

@Controller
public class RegistroControlador {
	
	
	@Autowired
	private publicServicio publicServicio;


	@GetMapping("/Registro")
	public String Registro() {
		return "Registro";
	}

	@GetMapping("/casas")
	public String casa(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "casas";
	}

	@GetMapping("/apartamentos")
	public String apartamentos(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "apartamentos";
	}

	@GetMapping("/lotes")
	public String lotes(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "lotes";
	}

	@GetMapping("/terrenos")
	public String terrenos(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "terrenos";
	}

	@GetMapping("/fincas")
	public String fincas(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "fincas";
	}

	@GetMapping("/locales")
	public String locales(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "locales";
	}

	@GetMapping("/oficinas")
	public String oficinas(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "oficinas";
	}

	@GetMapping("/edificios")
	public String edificios(Model model) {
		model.addAttribute("listarPublic", publicServicio.Listapublica());
		return "edificios";
	}
}
