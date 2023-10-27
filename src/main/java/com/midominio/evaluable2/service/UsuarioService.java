package com.midominio.evaluable2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midominio.evaluable2.dao.UsuarioRepository;
import com.midominio.evaluable2.entity.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public long count() {
		return usuarioRepository.count();
	}
	
	public Iterable<Usuario> todosLosUsuarios(){
		return usuarioRepository.findAll();
		
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> findById(Long id){
		return usuarioRepository.findById(id);
	}

}
