package org.generation.blog_Pessoal.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.generation.blog_Pessoal.model.Postagem;
import org.generation.blog_Pessoal.repository.PostagemRepository;





@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> GettAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){ //pathvariable capitura qual uma variavel está sendo recebida que é o mesmo que o caminho da uri
		return repository.findById(id) // retonar a interface "Repository" chamando o metodo findById
				.map(resp -> ResponseEntity.ok(resp)) // em caso ok, devolver um objeto do tipo postagem
				.orElse(ResponseEntity.notFound().build()); // caso erro ou não exista ele devolve o erro
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
}
