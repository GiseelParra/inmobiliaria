package com.sena.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sena.modelo.Publicacion;
import com.sena.servicio.publicServicio;

@Controller
@RequestMapping("/PublicControlador")
public class PublicControlador {

	List<String> tipoLugar = new ArrayList<String>(
			Arrays.asList("CASAS","HABITACIONES", "APARTAMENTOS", "LOTES", "TERRENOS", "FINCAS", "lOCALES", "OFICINAS", "EDIFICIOS")

	);

	List<String> disponible = new ArrayList<String>(Arrays.asList("ARRIENDO", "ALQUILER", "VENTA"));

	@Autowired
	private publicServicio publicServicio;

	@GetMapping("/")
	public String AdministrarPubli(Model model, @Param("palabraClave") String palabraClave) {
		List<Publicacion> Listapublica = publicServicio.listAll(palabraClave);
		model.addAttribute("listarPublic", Listapublica);
		model.addAttribute("palabraClave", palabraClave);

		return "AdministrarPubli";
	}

	@GetMapping("/FormuCrearpublic")
	public String FormuCrearpublic(Model model) {
		model.addAttribute("TipoLugar", tipoLugar);
		model.addAttribute("disponible", disponible);
		model.addAttribute("ObPublic", new Publicacion());
		return "FormuCrearpublic";
	}

	@GetMapping("/FormuActualizarpublic/{IdLugar}")
	public String FormuActualizarpublic(Model model, @PathVariable("IdLugar") int IdLugar) {
		model.addAttribute("ObPublic", publicServicio.buscarpublic(IdLugar));
		return "FormuActualizarpublic";
	}

	@GetMapping("/Eliminarpublic/{IdLugar}")
	public String Eliminarpublic(@PathVariable("IdLugar") int IdLugar) {
		publicServicio.eliminarpublic(IdLugar);
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

	@PostMapping("/guardar")
	public String guardar(@Validated @ModelAttribute("ObPublic") Publicacion publicacion, BindingResult result,
			Model model, @RequestParam("Imagen") MultipartFile imagenes, RedirectAttributes attributes,
			@RequestParam("ImagenUno") MultipartFile ImagenUno ,@RequestParam("ImagenDos") MultipartFile ImagenDos,
			@RequestParam("ImagenTres") MultipartFile ImagenTres,
			@RequestParam("ImagenCuarta") MultipartFile ImagenCuarta) {

		/*
		 * if (result.hasErrors()) { model.addAttribute("titulo", "FormuCrearpublic");
		 * model.addAttribute("ObPublic", publicacion);
		 * 
		 * attributes.addFlashAttribute("advertencia",
		 * "Existieron errores en el formulario"); return
		 * "redirect:/PublicControlador/FormuCrearpublic"; }
		 */
		
		
		
		publicServicio.guardar(publicacion);
		
		Path directorioimagenes = Paths.get("src//main//resources//static/imagenes");
		String rutaAbsoluta = directorioimagenes.toFile().getAbsolutePath();
		

		if (!imagenes.isEmpty()) {

			try {
				byte[] bytesImg = imagenes.getBytes();
				String ruta = rutaAbsoluta + "\\" + publicacion.getIdLugar()+ ".jpeg";
				Path rutaCompleta = Paths.get(ruta);
				Files.write(rutaCompleta, bytesImg);

				publicacion.setImagen(publicacion.getIdLugar()+ ".jpeg");
				publicServicio.ActualizarPublic(publicacion);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}else if(!ImagenUno.isEmpty() && !ImagenDos.isEmpty() && !ImagenTres.isEmpty() && !ImagenCuarta.isEmpty()) {
			
			try {
					
				
				    byte[] bytesImg = ImagenUno.getBytes();
					String ruta = rutaAbsoluta + "\\" + publicacion.getIdLugar()+ ".jpeg";
					Path rutaCompleta = Paths.get(ruta);
					Files.write(rutaCompleta, bytesImg);

					publicacion.setImagen(publicacion.getIdLugar()+ ".jpeg");
					publicServicio.ActualizarPublic(publicacion);
					
					
					  byte[] bytesImgDos = ImagenDos.getBytes();
					  String rutaDos = rutaAbsoluta + "\\" + "2-"+publicacion.getIdLugar()+ ".jpeg";
					  Path rutaCompletaDos = Paths.get(rutaDos);
					  Files.write(rutaCompletaDos, bytesImgDos);
					  
					  
					  byte[] bytesImgTres = ImagenTres.getBytes();
					  String rutaTres = rutaAbsoluta + "\\" + "3-"+publicacion.getIdLugar()+ ".jpeg";
					  Path rutaCompletaTres = Paths.get(rutaTres);
					  Files.write(rutaCompletaTres, bytesImgTres);
					  
					  byte[] bytesImgCuatro = ImagenCuarta.getBytes();
					  String rutaCuatro = rutaAbsoluta + "\\" + "4-"+publicacion.getIdLugar()+ ".jpeg";
					  Path rutaCompletaCuatro = Paths.get(rutaCuatro);
					  Files.write(rutaCompletaCuatro, bytesImgCuatro);
					
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		


		attributes.addFlashAttribute("exito", "Producto guardado con exito");
		return "redirect:/PublicControlador/";
	}

}
