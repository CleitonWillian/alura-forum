package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.entity.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;

	@GetMapping
	public List<Usuario> todosUsuarios() {
		return repository.findAll();

	}

}
