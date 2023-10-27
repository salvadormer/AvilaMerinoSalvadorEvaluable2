package com.midominio.evaluable2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.midominio.evaluable2.dao.LibroRepository;

import com.midominio.evaluable2.service.LibroService;
import com.midominio.evaluable2.service.MultiService;

@Controller
//@RequestMapping("/test")
public class LibroController {
	
	@Autowired
	LibroRepository libroRespository;
	@Autowired
	LibroService libroService;
	@Autowired
	MultiService multiservice;
	
	@Value("tests diversos")
	String titulo;
	
	@ModelAttribute
	String devuelveTitulo() {
		return "Tests diversos";
	}
	
	@GetMapping("/libro")
	public String test1(Model model) {
		model.addAttribute("nomLibros", libroRespository.findAll());
		model.addAttribute("titulo", "Listado");
		model.addAttribute("tituloH2", "Listado de libros");
		System.out.println();
		return "Libro/libro";
	}
	

	
	@GetMapping("/catalogo/info/{id}")
	public String muestraFormulariosConDatos(@PathVariable Long id, Model model) {
		model.addAttribute("libro", libroService.findById(id).orElse(null));
		
		return "catalogo/info";
	}

	
	

}
