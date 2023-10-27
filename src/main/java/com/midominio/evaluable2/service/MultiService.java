package com.midominio.evaluable2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.evaluable2.dao.LibroRepository;
import com.midominio.evaluable2.dao.UsuarioRepository;

@Service
public class MultiService {
	@Autowired
	LibroRepository libroRespository;
	
	@Autowired
	UsuarioRepository usuarioRespository;
	 
	public void destruyeElMundo() {
		libroRespository.deleteAll();
		usuarioRespository.deleteAll();
	}
	
	
}
