package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.forum.entity.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	@Query("SELECT t FROM Topico t WHERE t.titulo = ?1")
	public List<Topico>topicoPorTituloJPQL(String titulo);
	
	@Query(value = "SELECT * FROM Topico t WHERE t.titulo = ?1", nativeQuery = true)
	public List<Topico>topicoPorTituloSQL(String titulo);
	
	public List<Topico> findByTitulo(String titulo);
	
}
