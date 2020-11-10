package org.generation.blog_Pessoal.repository;

import java.util.List;

import org.generation.blog_Pessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface temaRepository extends JpaRepository<Tema, Long> {
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
