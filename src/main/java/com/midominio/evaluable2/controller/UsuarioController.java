package com.midominio.evaluable2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.midominio.evaluable2.dao.UsuarioRepository;
import com.midominio.evaluable2.entity.Usuario;
import com.midominio.evaluable2.service.MultiService;
import com.midominio.evaluable2.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRespository;
	@Autowired 
	MultiService multiService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@ModelAttribute(name="titulo")
	public String dameTitulo() {
		return "Usuarios";
	}
	
	@GetMapping("/usuario/todos")
	public String listarTodosLosUsuarios(Model model) {
		model.addAttribute("cabecera", "Listado de usuarios");
		model.addAttribute("usuarios", usuarioService.todosLosUsuarios());
		return "usuario/listado";
	}
	
	@GetMapping("usuario/borrar/{id}")
	public String borrarPorId(@PathVariable Long id) {
		usuarioService.deleteById(id);
		return "redirect:/usuario/todos";
	}
	
	@GetMapping("/usuario/form")
	public String muestraFormulario (Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("cabecera", "Formulario de usuario");
		return "usuario/form";
		
	}
	
	@PostMapping("/usuario/form")
	public String guardaFormulario(Usuario usuario) {
		usuarioService.save(usuario);
		return "redirect:/usuario/todos";
	}
	
	@GetMapping("/usuario/form/{id}")
	public String muestraFormulariosConDatos(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", usuarioService.findById(id));
		model.addAttribute("cabecera", "Formulario edicion de usuario");
		return "usuario/form";
	}
	
	@GetMapping("/usuario/listado")
	public String test1(Model model) {
		model.addAttribute("nomUsuario", usuarioRespository.findAll());
		System.out.println();
		return "usuario";
	}
	
	
}
