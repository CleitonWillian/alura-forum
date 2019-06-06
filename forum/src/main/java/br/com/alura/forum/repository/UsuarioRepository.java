package br.com.alura.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
