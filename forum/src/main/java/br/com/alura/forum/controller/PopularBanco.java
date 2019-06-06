package br.com.alura.forum.controller;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.entity.Categoria;
import br.com.alura.forum.entity.Curso;
import br.com.alura.forum.entity.Topico;
import br.com.alura.forum.entity.TopicoSituacao;
import br.com.alura.forum.entity.Usuario;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("populaBanco")
public class PopularBanco {

	@Autowired
	TopicoRepository topicoRepository;
	
	@GetMapping
	public String populaBanco() {
			var subcategoria = new Categoria("Java", new Categoria("Programacao"));

			var curso1 = new Curso("Java e JSF", subcategoria);
			var curso2 = new Curso("Spring", subcategoria);
			
			var fulano = new Usuario("Fulano", "fulano@gmail.com");

			var topico1 = new Topico("Problemas com JSF", "Erro ao fazer conversão da data", fulano, curso1);
			topico1.setCriadoEm(LocalDate.now().minusDays(20));

			var topico2 = new Topico("Erro no JSF", "Erro com Taglib",
					new Usuario("Beltrano", "beltrano@gmail.com", LocalDate.now().minusDays(20)), curso1);
			topico2.setSituacao(TopicoSituacao.RESOLVIDO);
			topico2.setCriadoEm(LocalDate.now().minusDays(110));

			var topico3 = new Topico("Problema com SpringBoot", "Erro ao criar um Bean",
					new Usuario("Ciclano", "ciclano@gmail.com",LocalDate.now().minusDays(50)), curso2);
			topico3.setCriadoEm(LocalDate.now().minusDays(200));

			var topico4 = new Topico("JWT no SpringBoot", "Configuracao do JWT no Spring Boot", fulano, curso1);
			topico4.setCriadoEm(LocalDate.now().minusDays(300));

			var topico5 = new Topico("Erro no SpringBoot", "Erro ao criar controller",
					new Usuario("Joana", "joana@gmail.com", LocalDate.now().minusDays(300)), curso2);
			topico5.setSituacao(TopicoSituacao.RESOLVIDO);
			topico5.setCriadoEm(LocalDate.now().minusDays(350));

			var topico6 = new Topico("SpringBoot não sobe", "Application failed, erro no data source",
					new Usuario("Aline", "aline@gmail.com",LocalDate.now().minusDays(9)), curso2);
			topico6.setSituacao(TopicoSituacao.RESOLVIDO);
			topico6.setCriadoEm(LocalDate.now().minusDays(10));

			topicoRepository.saveAll(Arrays.asList(topico1, topico2, topico3, topico4, topico5, topico6));
			
			return "populado";

	}
	
}
