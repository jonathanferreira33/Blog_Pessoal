package org.generation.blog_Pessoal.repository;

import java.util.List;

import org.generation.blog_Pessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	 public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
