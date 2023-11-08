package com.sena.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/AdministrarPrincipal")
	public String AdministrarPrincipal() {
		return "AdministracionPrincipal";
	}

	@GetMapping("/registro")
	public String registro() {
		return "registro";
	}
	
	@GetMapping("/RecuperarContra")
	public String RecuperarContra() {
		return "RecuperarContra";
	}
	
	@GetMapping ("/RestaContrasena")
	public String RestaContrasena() {
		return "RestaContrasena";
	}

}
