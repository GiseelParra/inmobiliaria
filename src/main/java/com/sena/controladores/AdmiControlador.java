package com.sena.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.modelo.Administrador;
import com.sena.servicio.AdmiServicio;

@Controller
@RequestMapping ("/AdmiControlador")
public class AdmiControlador {

	@Autowired
	private AdmiServicio admiServicio;

	@GetMapping("/")
	public String Administrar(Model model) {
		model.addAttribute("listaruAdmi", admiServicio.ListaAdmi());
		return "Administrar";
	}

	@GetMapping("FormularioCrearAdmi")
	public String FormularioCrearAdmi(Model model) {
		model.addAttribute("ObAdmi", new Administrador());
		return "FormularioCrearAdmi";
	}

	@GetMapping("FormularioActualizarAdmi")
	public String FormularioActualizarAdmi(Model model, @PathVariable("IdAdmi") int IdAdmi) {
		model.addAttribute("ObAdmi", admiServicio.buscarAdmi(IdAdmi));
		return "FormularioActualizarAdmi";
	}

	@GetMapping("/EliminarAdmi/{IdAdmi}")
	public String EliminarAdmi(@PathVariable("IdAdmi") int IdAdmi) {
		admiServicio.eliminarAdmi(IdAdmi);
		return "redirect:/AdmiControlador/";
	}

	@PostMapping("/AnadirAdmi")
	public String AnadirAdmi(Administrador AnadirAdmi) {
		admiServicio.AnadirAdmi(AnadirAdmi);
		return "redirect:/AdmiControlador/";
	}

	@PostMapping("/ActualizarAdmi")
	public String ActualizarAdmi(Administrador ActualizarAdmi) {
		admiServicio.ActualizarAdmi(ActualizarAdmi);
		return "redirect:/AdmiControlador/";
	}
}
