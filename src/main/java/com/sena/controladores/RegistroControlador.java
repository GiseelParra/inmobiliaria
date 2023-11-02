package com.sena.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroControlador {

	@GetMapping("/Registro")
	public String Registro() {
		return "Registro";
	}
}
