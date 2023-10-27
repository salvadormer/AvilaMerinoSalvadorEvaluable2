package com.midominio.evaluable2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.midominio.evaluable2.service.LibroService;

@Controller
//@RequestMapping("/libro")
public class Home {
	
	@GetMapping({"/","/home"})
	public String homeHandler(Model model) {
		model.addAttribute("titulo", "Inicio");
		model.addAttribute("tituloH1", "Catálogo de Libros");
		model.addAttribute("parrafo", "Visite nuestro catálogo de libros disponibles para préstamo");
		
		return "home";
	}
	
	
	
	
	


}